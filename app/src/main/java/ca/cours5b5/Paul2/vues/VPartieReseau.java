package ca.cours5b5.Paul2.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.Paul2.R;
import ca.cours5b5.Paul2.controleurs.ControleurObservation;
import ca.cours5b5.Paul2.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.Paul2.exceptions.ErreurObservation;
import ca.cours5b5.Paul2.modeles.MParametresPartie;
import ca.cours5b5.Paul2.modeles.MPartie;
import ca.cours5b5.Paul2.modeles.MPartieReseau;
import ca.cours5b5.Paul2.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
