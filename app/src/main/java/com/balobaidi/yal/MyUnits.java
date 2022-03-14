package com.balobaidi.yal;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class MyUnits {

    private ImageView imageView;
    private String tag;
    private int count;

    public MyUnits(ImageView imageView, int count, String tag) {
        this.imageView = imageView;
        this.tag = tag;
        this.count = count;

        attachDragListener();
    }

    private void attachDragListener() {
        imageView.setOnLongClickListener(v-> {
            ClipData.Item item = new ClipData.Item((CharSequence) imageView.getTag());
            ClipData dragData = new ClipData((CharSequence) imageView.getTag(), new String[] {ClipDescription.MIMETYPE_TEXT_PLAIN}, item);

            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);
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
}



