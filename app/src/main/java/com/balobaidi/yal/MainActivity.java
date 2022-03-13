package com.balobaidi.yal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private SignInButton signInButton;
    private Button signOutButton;
    private Button play;

    private TextView stat;

    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    private FirebaseFirestore db;
    private DocumentReference userDocumentPath;

    private final int reqCode = 4001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signInButton = findViewById(R.id.sign_in_button);
        signOutButton = findViewById(R.id.sign_out_button);
        play = findViewById(R.id.play);
        stat = findViewById(R.id.google_stat);
        db = FirebaseFirestore.getInstance();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(getString(R.string.acid))
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(v -> {
            Intent signInIntent = googleSignInClient.getSignInIntent();
            //noinspection deprecation
            startActivityForResult(signInIntent, reqCode);
        });

        signOutButton.setOnClickListener(v -> {
            if (firebaseUser.getEmail() != null){
                db.collection("users").document(firebaseUser.getEmail()).delete();

                firebaseAuth.signOut();
                googleSignInClient.signOut();

                stat.setText(R.string.sign_out);
                signOutButton.setEnabled(false);
                play.setEnabled(false);
            }
        });

        play.setOnClickListener(view -> {
            String userDocumentPathString = userDocumentPath.getPath();
            Intent intent = new Intent(this, Defence.class);
            intent.putExtra("userDocPathStr", userDocumentPathString);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null){
            stat.setText(account.getDisplayName());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == reqCode){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                stat.setText(account.getDisplayName());
                signOutButton.setEnabled(true);

                firebaseAuthWithGoogle(account.getIdToken());

            } catch (ApiException e) {
                Log.e("BASHEER", e.toString() + e.getMessage() + e.getStatus() + e.getStackTrace());
                stat.setText(R.string.failed);
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        firebaseUser = firebaseAuth.getCurrentUser();
                        if (firebaseUser != null) {
                            stat.setText(firebaseUser.getDisplayName());
                        }

                        Map<String, String> data = new HashMap<>();
                        data.put("displayName", firebaseUser.getDisplayName());
                        data.put("status", "free");
                        data.put("match", "none");

                        if (firebaseUser.getEmail() != null){
                            userDocumentPath = db.collection("users").document(firebaseUser.getEmail());
                            userDocumentPath.set(data);
                        }

                        findFreePlayer();

                    } else {
                        stat.setText(R.string.Auth_failed);
                    }
                });
    }

    private void findFreePlayer() {
        db.collection("users").get().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                for (QueryDocumentSnapshot document : task.getResult()){
                    if (document.get("status") != null && document.get("displayName") != null){
                        if (document.get("status").toString().equals("free") && !(document.get("displayName").toString().equals(firebaseUser.getDisplayName()))){

                            //db.collection("users").document(document.getId()).update("status", "busy", "match", firebaseUser.getEmail());
                            db.collection("users").document(firebaseUser.getEmail()).update("status", "busy", "match", document.getId());

                            play.setEnabled(true);
                        }
                    }
                }
            }
        });
    }
}










