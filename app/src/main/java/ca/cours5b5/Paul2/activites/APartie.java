package ca.cours5b5.Paul2.activites;


import android.content.Intent;
import android.os.Bundle;



import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.Paul2.R;
import ca.cours5b5.Paul2.controleurs.ControleurModeles;
import ca.cours5b5.Paul2.donnees.SauvegardeTemporaire;
import ca.cours5b5.Paul2.modeles.MParametres;
import ca.cours5b5.Paul2.modeles.MPartie;

public class APartie extends Activite {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_partie);

    }

    @Override
    protected void onPause() {
        super.onPause();

        ControleurModeles.sauvegarderModele(MPartie.class.getSimpleName());

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ControleurModeles.sauvegarderModeleDansCetteSource(MPartie.class.getSimpleName(),
                new SauvegardeTemporaire(outState));

    }


}