package ca.cours5b5.paulsasu.interfaces;

import android.util.Log;

import java.util.Map;

import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.MPartie;
import ca.cours5b5.paulsasu.modeles.Modele;

public class ControleurObservation {
    private static Map<Modele, ListenerObservateur> observations;
    private static MPartie partie;

    static {

    }

    public static  void observerModele(String nomModele, final ListenerObservateur listenerObservateur) {
        if (nomModele.equals(MParametres.class.getSimpleName())){
            listenerObservateur.reagirNouveauModele(MParametres.instance);
            Log.d("Atelier06",MParametres.instance.toString());

        } else if (nomModele.equals(MPartie.class.getSimpleName())){
            partie = new MPartie(MParametres.instance.getParametresPartie().cloner());
            listenerObservateur.reagirNouveauModele(partie);
            Log.d("Atelier06",partie.toString());
        }


    }
}
