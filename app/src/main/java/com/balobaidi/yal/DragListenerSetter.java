package com.balobaidi.yal;

import android.content.ClipData;
import android.view.DragEvent;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class DragListenerSetter {
    private static ImageView [] ver, hor, inc_1, inc_2;
    private static final String IMAGWVIEW_TAG = "tank_permanent";

    public static void setDragListener(ConstraintLayout root, Coor coor, CoorToView coorToView) {
        int childCount = root.getChildCount();

        for(int i = 0; i < childCount; ++i) {
            int finalI = i;
            if (!(root.getChildAt(i).getTag().equals("grid"))) {continue;}

            root.getChildAt(i).setOnDragListener((v, e) -> {

                switch (e.getAction()) {

                    case DragEvent.ACTION_DRAG_ENTERED:
                        ((ImageView) root.getChildAt(finalI)).setImageResource(android.R.color.holo_blue_light);

                        int x, y;
                        x = coor.getXCoor((ImageView) v);
                        y = coor.getYCoor((ImageView) v);

                        ver = new ImageView[]{coorToView.getView(x, y - 1), coorToView.getView(x, y - 2), coorToView.getView(x, y + 1), coorToView.getView(x, y + 2)};
                        hor = new ImageView[]{coorToView.getView(x - 1, y), coorToView.getView(x - 2, y), coorToView.getView(x + 1, y), coorToView.getView(x + 2, y)};
                        inc_1 = new ImageView[]{coorToView.getView(x - 1, y - 1), coorToView.getView(x - 2, y - 2), coorToView.getView(x + 1, y + 1), coorToView.getView(x + 2, y + 2)};
                        inc_2 = new ImageView[]{coorToView.getView(x - 1, y + 1), coorToView.getView(x - 2, y + 2), coorToView.getView(x + 1, y - 1), coorToView.getView(x + 2, y - 2)};

                        showPossiblePositions(ver);
                        showPossiblePositions(hor);
                        showPossiblePositions(inc_1);
                        showPossiblePositions(inc_2);

                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        ((ImageView) root.getChildAt(finalI)).setImageResource(android.R.color.holo_orange_light);

                        resetPossibilities(ver);
                        resetPossibilities(hor);
                        resetPossibilities(inc_1);
                        resetPossibilities(inc_2);

                        break;

                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = e.getClipData().getItemAt(0);
                        CharSequence dragData = item.getText();
                        if (dragData.equals(IMAGWVIEW_TAG)) {
                            ((ImageView) v).setImageResource(R.drawable.tank);
                            ((ImageView) v).setTag(IMAGWVIEW_TAG);
                        }
                        resetPossibilities(ver);
                        resetPossibilities(hor);
                        resetPossibilities(inc_1);
                        resetPossibilities(inc_2);
                }

                return true;
            });
        }
    }

    public static void showPossiblePositions (ImageView [] array) {
        boolean all = false;
        for (ImageView img : array) {
            all = img != null && ((String)img.getTag()).equals("grid");
            if (!all) {break;}
        }

        if (all){
            for (ImageView img : array) {
                img.setTag("tank_temp");
                img.setImageResource(android.R.color.holo_green_light);
            }
        }
    }

    private static void resetPossibilities(ImageView [] array) {
        for (ImageView img : array) {
            if (img != null && img.getTag().equals("tank_temp")) {
                img.setTag("grid");
                img.setImageResource(R.drawable.oo);
            }
        }
    }
}
