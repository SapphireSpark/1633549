package ca.cours5b5.Paul2.activites;

import android.os.Bundle;

import ca.cours5b5.Paul2.R;
import ca.cours5b5.Paul2.controleurs.ControleurAction;
import ca.cours5b5.Paul2.controleurs.ControleurModeles;
import ca.cours5b5.Paul2.controleurs.interfaces.Fournisseur;
import ca.cours5b5.Paul2.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.Paul2.global.GCommande;
import ca.cours5b5.Paul2.modeles.MPartie;

public class APartie extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie);

        fournirActionTerminerPartie();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        ControleurModeles.detruireModele(MPartie.class.getSimpleName());
                        quitterCetteActivite();

                    }
                });
    }


    @Override
    protected void onPause() {
        super.onPause();
        sauvegarderPartie();
    }


    protected void sauvegarderPartie(){
        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());
    }


}