package ca.cours5b5.Paul2.activites;

import android.os.Bundle;

import ca.cours5b5.Paul2.R;
import ca.cours5b5.Paul2.controleurs.ControleurAction;
import ca.cours5b5.Paul2.controleurs.ControleurModeles;
import ca.cours5b5.Paul2.controleurs.ControleurPartie;
import ca.cours5b5.Paul2.controleurs.ControleurPartieReseau;
import ca.cours5b5.Paul2.controleurs.interfaces.Fournisseur;
import ca.cours5b5.Paul2.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.Paul2.donnees.SauvegardeTemporaire;
import ca.cours5b5.Paul2.donnees.Serveur;
import ca.cours5b5.Paul2.global.GCommande;
import ca.cours5b5.Paul2.global.GConstantes;
import ca.cours5b5.Paul2.modeles.MParametres;
import ca.cours5b5.Paul2.modeles.MPartieReseau;


public class APartieReseau extends Activite implements Fournisseur {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partie_reseau);

        fournirActionTerminerPartie();

        ControleurPartieReseau.getInstance().connecterAuServeur();

    }


    private void fournirActionTerminerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.TERMINER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        // XXX: terminerPartie() est appelée sur onDestroy
                        quitterCetteActivite();

                    }
                });
    }


    private void terminerPartie() {

        String nomModele = MPartieReseau.class.getSimpleName();

        ControleurPartieReseau.getInstance().deconnecterDuServeur();

        ControleurModeles.detruireModele(nomModele);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String nomModele = MPartieReseau.class.getSimpleName();

        ControleurModeles.sauvegarderModeleDansCetteSource(nomModele,
                new SauvegardeTemporaire(outState));

    }


    @Override
    protected void onPause() {
        super.onPause();

        ControleurPartieReseau.getInstance().detruireSauvegardeServeur();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        terminerPartie();

    }


}
