package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.global.GConstantes;
import ca.cours5b5.paulsasu.interfaces.ControleurObservation;
import ca.cours5b5.paulsasu.interfaces.ListenerObservateur;
import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.Modele;

public class VParametres extends Vue{
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ControleurObservation.observerModele(MParametres.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {
                afficherParam((MParametres) modele);
            }

            @Override
            public void reagirChangementAuModele(Modele modele) {
                afficherParam((MParametres) modele);
            }

        });
    }
        private void afficherParam(MParametres parametres){

            Spinner spinH = this.findViewById(R.id.spinnerH);
            Spinner spinL = this.findViewById(R.id.spinnerL);
            Spinner spinW = this.findViewById(R.id.spinnerW);

            ArrayAdapter<Integer> adapterH = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
            ArrayAdapter<Integer> adapterL = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
            ArrayAdapter<Integer> adapterW = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);

            adapterH.addAll(MParametres.instance.getChoixHauteur());
            adapterL.addAll(MParametres.instance.getChoixLargeur());
            adapterW.addAll(MParametres.instance.getChoixPourGagner());

            spinH.setAdapter(adapterH);
            spinL.setAdapter(adapterL);
            spinW.setAdapter(adapterW);

            spinH.setSelection(adapterH.getPosition(MParametres.instance.parametresPartie.hauteur));
            spinL.setSelection(adapterL.getPosition(MParametres.instance.parametresPartie.largeur));
            spinW.setSelection(adapterW.getPosition(MParametres.instance.parametresPartie.pourGagner));

            spinH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MParametres.instance.parametresPartie.hauteur = (int) parent.getAdapter().getItem(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            spinL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MParametres.instance.parametresPartie.largeur = (int) parent.getAdapter().getItem(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            spinW.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MParametres.instance.parametresPartie.pourGagner = (int) parent.getAdapter().getItem(position);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

    public VParametres(Context context) {
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VParametres(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    static {
        Log.d("Atelier04", "VParametres::Static");
    }
}
