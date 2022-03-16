package com.balobaidi.yal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;


public class Defence extends AppCompatActivity {

    private Coor coor;
    private CoorToView coorToView;

    private ConstraintLayout rootNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defence);

        coor = new Coor(this);
        coorToView = new CoorToView(this);

        rootNode = findViewById(R.id.zz);
        DragListenerSetter.setDragListener(rootNode, coor, coorToView);

        Intent intent = getIntent();
        String userDocPathStr = intent.getStringExtra("userDocPathStr");

        FirebaseFirestore firebaseFirestoreInstance = FirebaseFirestore.getInstance();
        DocumentReference userDocPath = firebaseFirestoreInstance.document(userDocPathStr);

        listenToUserDocument(userDocPath);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onStart() {
        super.onStart();

        MyUnits tank = new MyUnits(findViewById(R.id.TANK), 5, "tank", getDrawable(R.drawable.tank));
        MyUnits jet = new MyUnits(findViewById(R.id.JET), 5, "jet", getDrawable(R.drawable.jet));
        MyUnits canon = new MyUnits(findViewById(R.id.CANON), 3, "canon", getDrawable(R.drawable.canon));
        MyUnits frigate = new MyUnits(findViewById(R.id.FRIGATE), 3, "frigate", getDrawable(R.drawable.frigate));
        MyUnits submarine = new MyUnits(findViewById(R.id.SUBMARINE), 2, "submarine", getDrawable(R.drawable.submarine));
    }

    private void listenToUserDocument(DocumentReference userDocumentPath) {
        userDocumentPath.addSnapshotListener((snapshot, error) -> {
            if(error != null){return;}

            if(snapshot != null && snapshot.exists()){
                interact(snapshot);
            }
        });
    }

    private void interact(DocumentSnapshot snapshot) {
        Log.i("BASHEERA", snapshot.getData().toString());
    }
}






