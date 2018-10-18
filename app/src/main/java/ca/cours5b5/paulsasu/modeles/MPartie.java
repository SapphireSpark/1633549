package ca.cours5b5.paulsasu.modeles;

import java.util.Map;

import ca.cours5b5.paulsasu.serialisation.AttributSerialisable;

public class MPartie extends Modele {

    @AttributSerialisable
    public MParametresPartie parametres;
    private final String __parametres = "parametres";

    public MPartie(MParametresPartie parametres){
        this.parametres = parametres;
    }

    public MParametresPartie getParametres() {
        return parametres;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        //vide
    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
        //vide
    }
}
