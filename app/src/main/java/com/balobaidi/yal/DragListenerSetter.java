package com.balobaidi.yal;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.widget.ImageView;

import androidx.annotation.IdRes;
import androidx.constraintlayout.widget.ConstraintLayout;

public class DragListenerSetter {
    private static ImageView [] ver, hor, inc_1, inc_2;
    private static final String IMAGWVIEW_TAG = "tank_permanent";

    public static Drawable Dragged_Unit_Ref;

    public static void setDragListener(ConstraintLayout root, Coor coor, CoorToView coorToView) {
        int childCount = root.getChildCount();

        for(int i = 0; i < childCount; ++i) {
            int finalI = i;
            if (!(root.getChildAt(i).getTag().equals("grid"))) {continue;}

            root.getChildAt(i).setOnDragListener((v, e) -> {

                switch (e.getAction()) {

                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (!((ImageView) root.getChildAt(finalI)).getTag().equals("grid")) {
                            return false;
                        }
                        ((ImageView) root.getChildAt(finalI)).setForeground( Dragged_Unit_Ref);

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
                        ((ImageView) root.getChildAt(finalI)).setForeground(null);

                        ((ImageView) v).setTag("grid");
                        ((ImageView) v).setImageResource(R.drawable.oo);

                        resetPossibilities(ver);
                        resetPossibilities(hor);
                        resetPossibilities(inc_1);
                        resetPossibilities(inc_2);

                        break;

                    case DragEvent.ACTION_DROP:

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
                img.setForeground(Dragged_Unit_Ref);
                img.setTag("temp");
            }
        }
    }

    private static void resetPossibilities(ImageView [] array) {
        for (ImageView img : array) {
            if (img != null && img.getTag().equals("temp")) {
                img.setForeground(null);
                img.setTag("grid");
            }
        }
    }
}
