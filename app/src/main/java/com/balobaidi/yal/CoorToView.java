package com.balobaidi.yal;

import android.widget.ImageView;

public class CoorToView {

    private final Defence defence;

    public CoorToView(Defence def) {
        this.defence = def;
    }

    private ImageView getView(int id) {
        return defence.findViewById(id);
    }

    public ImageView getView(int x, int y){
        if (x < 1 || y < 1 || x > 10 || y > 10) {return  null;}

        if (y == 1) {
            if (x == 1) {return getView(R.id.q1);}
            else if (x == 2) {return getView(R.id.q2);}
            else if (x == 3) {return getView(R.id.q3);}
            else if (x == 4) {return getView(R.id.q4);}
            else if (x == 5) {return getView(R.id.q5);}
            else if (x == 6) {return getView(R.id.q6);}
            else if (x == 7) {return getView(R.id.q7);}
            else if (x == 8) {return getView(R.id.q8);}
            else if (x == 9) {return getView(R.id.q9);}
            else if (x == 10) {return getView(R.id.q10);}
        }
        else if (y == 2) {
            if (x == 1) {return getView(R.id.q11);}
            else if (x == 2) {return getView(R.id.q12);}
            else if (x == 3) {return getView(R.id.q13);}
            else if (x == 4) {return getView(R.id.q14);}
            else if (x == 5) {return getView(R.id.q15);}
            else if (x == 6) {return getView(R.id.q16);}
            else if (x == 7) {return getView(R.id.q17);}
            else if (x == 8) {return getView(R.id.q18);}
            else if (x == 9) {return getView(R.id.q19);}
            else if (x == 10) {return getView(R.id.q20);}
        }
        else if (y == 3) {
            if (x == 1) {return getView(R.id.q21);}
            else if (x == 2) {return getView(R.id.q22);}
            else if (x == 3) {return getView(R.id.q23);}
            else if (x == 4) {return getView(R.id.q24);}
            else if (x == 5) {return getView(R.id.q25);}
            else if (x == 6) {return getView(R.id.q26);}
            else if (x == 7) {return getView(R.id.q27);}
            else if (x == 8) {return getView(R.id.q28);}
            else if (x == 9) {return getView(R.id.q29);}
            else if (x == 10) {return getView(R.id.q30);}
        }
        else if (y == 4) {
            if (x == 1) {return getView(R.id.q31);}
            else if (x == 2) {return getView(R.id.q32);}
            else if (x == 3) {return getView(R.id.q33);}
            else if (x == 4) {return getView(R.id.q34);}
            else if (x == 5) {return getView(R.id.q35);}
            else if (x == 6) {return getView(R.id.q36);}
            else if (x == 7) {return getView(R.id.q37);}
            else if (x == 8) {return getView(R.id.q38);}
            else if (x == 9) {return getView(R.id.q39);}
            else if (x == 10) {return getView(R.id.q40);}
        }
        else if (y == 5) {
            if (x == 1) {return getView(R.id.q41);}
            else if (x == 2) {return getView(R.id.q42);}
            else if (x == 3) {return getView(R.id.q43);}
            else if (x == 4) {return getView(R.id.q44);}
            else if (x == 5) {return getView(R.id.q45);}
            else if (x == 6) {return getView(R.id.q46);}
            else if (x == 7) {return getView(R.id.q47);}
            else if (x == 8) {return getView(R.id.q48);}
            else if (x == 9) {return getView(R.id.q49);}
            else if (x == 10) {return getView(R.id.q50);}
        }
        else if (y == 6) {
            if (x == 1) {return getView(R.id.q51);}
            else if (x == 2) {return getView(R.id.q52);}
            else if (x == 3) {return getView(R.id.q53);}
            else if (x == 4) {return getView(R.id.q54);}
            else if (x == 5) {return getView(R.id.q55);}
            else if (x == 6) {return getView(R.id.q56);}
            else if (x == 7) {return getView(R.id.q57);}
            else if (x == 8) {return getView(R.id.q58);}
            else if (x == 9) {return getView(R.id.q59);}
            else if (x == 10) {return getView(R.id.q60);}
        }
        else if (y == 7) {
            if (x == 1) {return getView(R.id.q61);}
            else if (x == 2) {return getView(R.id.q62);}
            else if (x == 3) {return getView(R.id.q63);}
            else if (x == 4) {return getView(R.id.q64);}
            else if (x == 5) {return getView(R.id.q65);}
            else if (x == 6) {return getView(R.id.q66);}
            else if (x == 7) {return getView(R.id.q67);}
            else if (x == 8) {return getView(R.id.q68);}
            else if (x == 9) {return getView(R.id.q69);}
            else if (x == 10) {return getView(R.id.q70);}
        }
        else if (y == 8) {
            if (x == 1) {return getView(R.id.q71);}
            else if (x == 2) {return getView(R.id.q72);}
            else if (x == 3) {return getView(R.id.q73);}
            else if (x == 4) {return getView(R.id.q74);}
            else if (x == 5) {return getView(R.id.q75);}
            else if (x == 6) {return getView(R.id.q76);}
            else if (x == 7) {return getView(R.id.q77);}
            else if (x == 8) {return getView(R.id.q78);}
            else if (x == 9) {return getView(R.id.q79);}
            else if (x == 10) {return getView(R.id.q80);}
        }
        else if (y == 9) {
            if (x == 1) {return getView(R.id.q81);}
            else if (x == 2) {return getView(R.id.q82);}
            else if (x == 3) {return getView(R.id.q83);}
            else if (x == 4) {return getView(R.id.q84);}
            else if (x == 5) {return getView(R.id.q85);}
            else if (x == 6) {return getView(R.id.q86);}
            else if (x == 7) {return getView(R.id.q87);}
            else if (x == 8) {return getView(R.id.q88);}
            else if (x == 9) {return getView(R.id.q89);}
            else if (x == 10) {return getView(R.id.q90);}
        }
        else if (y == 10) {
            if (x == 1) {return getView(R.id.q91);}
            else if (x == 2) {return getView(R.id.q92);}
            else if (x == 3) {return getView(R.id.q93);}
            else if (x == 4) {return getView(R.id.q94);}
            else if (x == 5) {return getView(R.id.q95);}
            else if (x == 6) {return getView(R.id.q96);}
            else if (x == 7) {return getView(R.id.q97);}
            else if (x == 8) {return getView(R.id.q98);}
            else if (x == 9) {return getView(R.id.q99);}
        }
        return getView(R.id.q100);
    }
}