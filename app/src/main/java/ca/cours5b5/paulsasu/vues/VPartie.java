package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.paulsasu.interfaces.ControleurObservation;
import ca.cours5b5.paulsasu.interfaces.ListenerObservateur;
import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.MPartie;
import ca.cours5b5.paulsasu.modeles.Modele;

public class VPartie extends Vue {
    private VGrille grille;

    public VPartie(Context context) {
        super(context);
    }

    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void initialiser() {

    }

    private void observerPartie() {
        ControleurObservation.observerModele(MParametres.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {
                observerPartie();
            }
        });
    }

    private MPartie getPartie(Modele modele){

        return null;
    }

    private void intialiserGrille(MPartie partie) {


    }


}
