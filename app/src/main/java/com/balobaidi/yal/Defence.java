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

    private ImageView qw;
    private static final String IMAGWVIEW_TAG = "tank_permanent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defence);

        coor = new Coor(this);
        coorToView = new CoorToView(this);

        qw = findViewById(R.id.ass);
        qw.setTag(IMAGWVIEW_TAG);

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

        qw.setOnLongClickListener(v-> {
            ClipData.Item item = new ClipData.Item((CharSequence) qw.getTag());
            ClipData dragData = new ClipData((CharSequence) qw.getTag(), new String[] {ClipDescription.MIMETYPE_TEXT_PLAIN}, item);

            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(qw);
            v.startDragAndDrop(dragData, myShadow, null, 0);

            return true;
        });
    }

    private static class MyDragShadowBuilder extends View.DragShadowBuilder {

        private static Drawable shadow;

        public MyDragShadowBuilder(View v) {
            super(v);
            shadow = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onProvideShadowMetrics (Point size, Point touch) {

            int width, height;

            width = getView().getWidth();
            height = getView().getHeight();

            shadow.setBounds(0, 0, width, height);
            size.set(width, height);
            touch.set(width / 2, height / 2);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            shadow.draw(canvas);
        }
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






