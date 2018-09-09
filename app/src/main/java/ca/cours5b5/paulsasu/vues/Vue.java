package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.paulsasu.R;

public abstract class Vue extends ConstraintLayout {
    Class metaDonnes = Vue.class;
    public Vue(Context context) {
        super(context);
    }

    public Vue(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Vue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Vue",this.getResources().getString(Integer.parseInt(metaDonnes.getSimpleName())));
    }

    static {
        Log.d("Vue","::Static");
    }
}
