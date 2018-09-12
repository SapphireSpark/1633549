package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.global.GConstantes;
import ca.cours5b5.paulsasu.modeles.MParametres;

public class VParametres extends Vue{
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        Spinner spinH = this.findViewById(R.id.spinnerH);
        Spinner spinL = this.findViewById(R.id.spinnerL);
        Spinner spinW = this.findViewById(R.id.spinnerW);

        ArrayAdapter<Integer> adapterH = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, MParametres.instance.getChoixHauteur());
        ArrayAdapter<Integer> adapterL = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, MParametres.instance.getChoixLargeur());
        ArrayAdapter<Integer> adapterW = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item, MParametres.instance.getChoixPourGagner());

        spinH.setAdapter(adapterH);
        spinL.setAdapter(adapterL);
        spinW.setAdapter(adapterW);

        spinH.setSelection(adapterH.getPosition(MParametres.instance.hauteur));
        spinL.setSelection(adapterL.getPosition(MParametres.instance.largeur));
        spinW.setSelection(adapterW.getPosition(MParametres.instance.pourGagner));

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
        Log.d("Atelier04","VParametres::Static");
    }
}
