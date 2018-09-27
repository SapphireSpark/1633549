package ca.cours5b5.paulsasu.interfaces;

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
        observations = (Map<Modele, ListenerObservateur>) listenerObservateur;
        observerModele(MParametres.instance.toString(), listenerObservateur);

    }
}
