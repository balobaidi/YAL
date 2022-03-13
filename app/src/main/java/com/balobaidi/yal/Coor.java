package com.balobaidi.yal;

import android.widget.ImageView;

public class Coor {

    private final Defence defence;

    public Coor(Defence defence) {
        this.defence = defence;
    }

    private ImageView getView(int id){
        return defence.findViewById(id);
    }

    public int getYCoor(ImageView v) {
        int y;

        if (v.equals(getView(R.id.q1)) || v.equals(getView(R.id.q2)) || v.equals(getView(R.id.q3)) || v.equals(getView(R.id.q4)) || v.equals(getView(R.id.q5)) || v.equals(getView(R.id.q6)) || v.equals(getView(R.id.q7)) || v.equals(getView(R.id.q8)) || v.equals(getView(R.id.q9)) || v.equals(getView(R.id.q10))) {y = 1;}
        else if (v.equals(getView(R.id.q11)) || v.equals(getView(R.id.q12)) || v.equals(getView(R.id.q13)) || v.equals(getView(R.id.q14)) || v.equals(getView(R.id.q15)) || v.equals(getView(R.id.q16)) || v.equals(getView(R.id.q17)) || v.equals(getView(R.id.q18)) || v.equals(getView(R.id.q19)) || v.equals(getView(R.id.q20))) {y = 2;}
        else if (v.equals(getView(R.id.q21)) || v.equals(getView(R.id.q22)) || v.equals(getView(R.id.q23)) || v.equals(getView(R.id.q24)) || v.equals(getView(R.id.q25)) || v.equals(getView(R.id.q26)) || v.equals(getView(R.id.q27)) || v.equals(getView(R.id.q28)) || v.equals(getView(R.id.q29)) || v.equals(getView(R.id.q30))) {y = 3;}
        else if (v.equals(getView(R.id.q31)) || v.equals(getView(R.id.q32)) || v.equals(getView(R.id.q33)) || v.equals(getView(R.id.q34)) || v.equals(getView(R.id.q35)) || v.equals(getView(R.id.q36)) || v.equals(getView(R.id.q37)) || v.equals(getView(R.id.q38)) || v.equals(getView(R.id.q39)) || v.equals(getView(R.id.q40))) {y = 4;}
        else if (v.equals(getView(R.id.q41)) || v.equals(getView(R.id.q42)) || v.equals(getView(R.id.q43)) || v.equals(getView(R.id.q44)) || v.equals(getView(R.id.q45)) || v.equals(getView(R.id.q46)) || v.equals(getView(R.id.q47)) || v.equals(getView(R.id.q48)) || v.equals(getView(R.id.q49)) || v.equals(getView(R.id.q50))) {y = 5;}
        else if (v.equals(getView(R.id.q51)) || v.equals(getView(R.id.q52)) || v.equals(getView(R.id.q53)) || v.equals(getView(R.id.q54)) || v.equals(getView(R.id.q55)) || v.equals(getView(R.id.q56)) || v.equals(getView(R.id.q57)) || v.equals(getView(R.id.q58)) || v.equals(getView(R.id.q59)) || v.equals(getView(R.id.q60))) {y = 6;}
        else if (v.equals(getView(R.id.q61)) || v.equals(getView(R.id.q62)) || v.equals(getView(R.id.q63)) || v.equals(getView(R.id.q64)) || v.equals(getView(R.id.q65)) || v.equals(getView(R.id.q66)) || v.equals(getView(R.id.q67)) || v.equals(getView(R.id.q68)) || v.equals(getView(R.id.q69)) || v.equals(getView(R.id.q70))) {y = 7;}
        else if (v.equals(getView(R.id.q71)) || v.equals(getView(R.id.q72)) || v.equals(getView(R.id.q73)) || v.equals(getView(R.id.q74)) || v.equals(getView(R.id.q75)) || v.equals(getView(R.id.q76)) || v.equals(getView(R.id.q77)) || v.equals(getView(R.id.q78)) || v.equals(getView(R.id.q79)) || v.equals(getView(R.id.q80))) {y = 8;}
        else if (v.equals(getView(R.id.q81)) || v.equals(getView(R.id.q82)) || v.equals(getView(R.id.q83)) || v.equals(getView(R.id.q84)) || v.equals(getView(R.id.q85)) || v.equals(getView(R.id.q86)) || v.equals(getView(R.id.q87)) || v.equals(getView(R.id.q88)) || v.equals(getView(R.id.q89)) || v.equals(getView(R.id.q90))) {y = 9;}
        else {y = 10;}

        return y;
    }

    public int getXCoor(ImageView v) {
        int x;

        if (v.equals(getView(R.id.q1)) || v.equals(getView(R.id.q11)) || v.equals(getView(R.id.q21)) || v.equals(getView(R.id.q31)) || v.equals(getView(R.id.q41)) || v.equals(getView(R.id.q51)) || v.equals(getView(R.id.q61)) || v.equals(getView(R.id.q71)) || v.equals(getView(R.id.q81)) || v.equals(getView(R.id.q91))) {x = 1;}
        else if (v.equals(getView(R.id.q2)) || v.equals(getView(R.id.q12)) || v.equals(getView(R.id.q22)) || v.equals(getView(R.id.q32)) || v.equals(getView(R.id.q42)) || v.equals(getView(R.id.q52)) || v.equals(getView(R.id.q62)) || v.equals(getView(R.id.q72)) || v.equals(getView(R.id.q82)) || v.equals(getView(R.id.q92))) {x = 2;}
        else if (v.equals(getView(R.id.q3)) || v.equals(getView(R.id.q13)) || v.equals(getView(R.id.q23)) || v.equals(getView(R.id.q33)) || v.equals(getView(R.id.q43)) || v.equals(getView(R.id.q53)) || v.equals(getView(R.id.q63)) || v.equals(getView(R.id.q73)) || v.equals(getView(R.id.q83)) || v.equals(getView(R.id.q93))) {x = 3;}
        else if (v.equals(getView(R.id.q4)) || v.equals(getView(R.id.q14)) || v.equals(getView(R.id.q24)) || v.equals(getView(R.id.q34)) || v.equals(getView(R.id.q44)) || v.equals(getView(R.id.q54)) || v.equals(getView(R.id.q64)) || v.equals(getView(R.id.q74)) || v.equals(getView(R.id.q84)) || v.equals(getView(R.id.q94))) {x = 4;}
        else if (v.equals(getView(R.id.q5)) || v.equals(getView(R.id.q15)) || v.equals(getView(R.id.q25)) || v.equals(getView(R.id.q35)) || v.equals(getView(R.id.q45)) || v.equals(getView(R.id.q55)) || v.equals(getView(R.id.q65)) || v.equals(getView(R.id.q75)) || v.equals(getView(R.id.q85)) || v.equals(getView(R.id.q95))) {x = 5;}
        else if (v.equals(getView(R.id.q6)) || v.equals(getView(R.id.q16)) || v.equals(getView(R.id.q26)) || v.equals(getView(R.id.q36)) || v.equals(getView(R.id.q46)) || v.equals(getView(R.id.q56)) || v.equals(getView(R.id.q66)) || v.equals(getView(R.id.q76)) || v.equals(getView(R.id.q86)) || v.equals(getView(R.id.q96))) {x = 6;}
        else if (v.equals(getView(R.id.q7)) || v.equals(getView(R.id.q17)) || v.equals(getView(R.id.q27)) || v.equals(getView(R.id.q37)) || v.equals(getView(R.id.q47)) || v.equals(getView(R.id.q57)) || v.equals(getView(R.id.q67)) || v.equals(getView(R.id.q77)) || v.equals(getView(R.id.q87)) || v.equals(getView(R.id.q97))) {x = 7;}
        else if (v.equals(getView(R.id.q8)) || v.equals(getView(R.id.q18)) || v.equals(getView(R.id.q28)) || v.equals(getView(R.id.q38)) || v.equals(getView(R.id.q48)) || v.equals(getView(R.id.q58)) || v.equals(getView(R.id.q68)) || v.equals(getView(R.id.q78)) || v.equals(getView(R.id.q88)) || v.equals(getView(R.id.q98))) {x = 8;}
        else if (v.equals(getView(R.id.q9)) || v.equals(getView(R.id.q19)) || v.equals(getView(R.id.q29)) || v.equals(getView(R.id.q39)) || v.equals(getView(R.id.q49)) || v.equals(getView(R.id.q59)) || v.equals(getView(R.id.q69)) || v.equals(getView(R.id.q79)) || v.equals(getView(R.id.q89)) || v.equals(getView(R.id.q99))) {x = 9;}
        else {x = 10;}

        return x;
    }
}
