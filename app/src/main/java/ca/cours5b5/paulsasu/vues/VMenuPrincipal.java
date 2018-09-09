package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.activites.AParametres;
import ca.cours5b5.paulsasu.global.GConstantes;

public class VMenuPrincipal extends Vue{
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }
    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    static {
        Log.d("VMenuPrincipal","::Static");
    }
}
