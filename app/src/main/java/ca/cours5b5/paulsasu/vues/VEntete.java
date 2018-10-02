package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.Gravity;

public class VEntete extends AppCompatButton {
    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VEntete(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int colonne;

    public VEntete(Context context, int colonne){
        super(context);

        this.colonne = colonne;
        this.setWidth(0);
        this.setHeight(0);
        this.setGravity(Gravity.FILL);
        this.setText(colonne);

    }
}
