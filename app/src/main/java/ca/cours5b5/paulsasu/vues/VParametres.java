package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.global.GConstantes;

public class VParametres extends Vue{
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Spinner spinH = this.findViewById(R.id.spinnerH);
        Spinner spinL = this.findViewById(R.id.spinnerL);
        Spinner spinW = this.findViewById(R.id.spinnerW);

        ArrayAdapter<Integer> adapterH = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<Integer> adapterL = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter<Integer> adapterW = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);

        spinH.setAdapter(adapterH);
        spinL.setAdapter(adapterL);
        spinW.setAdapter(adapterW);


        for (int i = 0; i <= (GConstantes.HAUT_MAX - GConstantes.HAUT_MIN); i++) {
            adapterH.add(GConstantes.HAUT_MIN + i);
        }

        for (int i = 0; i <= (GConstantes.LARG_MAX - GConstantes.LARG_MIN); i++) {
            adapterL.add(GConstantes.LARG_MIN + i);
        }

        for (int i = 0; i <= (GConstantes.WIN_MAX - GConstantes.WIN_MIN); i++) {
            adapterW.add(GConstantes.WIN_MIN + i);
        }

        spinH.setSelection(2);
        spinL.setSelection(3);
        spinW.setSelection(1);

    }
    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    static {
        Log.d("VParametres","::Static");
    }
}
