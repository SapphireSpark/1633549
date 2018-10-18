package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.paulsasu.interfaces.ControleurObservation;
import ca.cours5b5.paulsasu.interfaces.ListenerObservateur;
import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.MParametresPartie;
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
        observerPartie();
    }


    private void observerPartie() {
        ControleurObservation.observerModele(MPartie.class.getSimpleName(), new ListenerObservateur() {
            @Override
            public void reagirNouveauModele(Modele modele) {
                initialiserGrille(getPartie(modele));
            }

            @Override
            public void reagirChangementAuModele(Modele modele) {
            }
        });
    }

    private MPartie getPartie(Modele modele){
        MPartie partie = (MPartie) modele;
        return partie;
    }

    private void initialiserGrille(MPartie partie) {
        Log.d("Atelier06",partie.parametres.hauteur.toString());
        grille.creerGrille(partie.parametres.hauteur, partie.parametres.largeur);
        Log.d("Atelier06",partie.parametres.hauteur.toString());
    }


}
