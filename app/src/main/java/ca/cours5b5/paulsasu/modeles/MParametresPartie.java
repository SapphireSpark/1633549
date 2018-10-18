package ca.cours5b5.paulsasu.modeles;

import java.util.HashMap;
import java.util.Map;

import ca.cours5b5.paulsasu.global.GConstantes;
import ca.cours5b5.paulsasu.serialisation.AttributSerialisable;

public class MParametresPartie extends Modele {

    @AttributSerialisable
    public Integer hauteur = GConstantes.HAUT_DEF;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur = GConstantes.LARG_DEF;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner = GConstantes.WIN_DEF;
    private final String __pourGagner= "pourGagner";

    public static  MParametresPartie aPartirMParametres(MParametres mParametres){
        MParametresPartie partie = new MParametresPartie();
        partie.setHauteur(mParametres.parametresPartie.hauteur);
        partie.setLargeur(mParametres.parametresPartie.largeur);
        partie.setPourGagner(mParametres.parametresPartie.pourGagner);
        partie.cloner();

        return partie;
    }

    public MParametresPartie cloner(){
        MParametresPartie partie = new MParametresPartie();
        partie.setHauteur(this.hauteur);
        partie.setLargeur(this.largeur);
        partie.setPourGagner(this.pourGagner);
        return partie;
    }

    public MParametresPartie() {

    }

    public Integer getHauteur() {
        return hauteur;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public Integer getPourGagner() {
        return pourGagner;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public void setPourGagner(Integer pourGagner) {
        this.pourGagner = pourGagner;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {
        for(Map.Entry<String, Object> entry : objetJson.entrySet()){
            String key = entry.getKey();
            Object value = entry.getValue();
            value = value.toString().substring(0, value.toString().indexOf("."));
            if (key.equals(__hauteur)) {
                hauteur = Integer.valueOf(value.toString());
            } else if (key.equals(__largeur)) {
                largeur = Integer.valueOf(value.toString());
            } else if (key.equals(__pourGagner)) {
                pourGagner = Integer.valueOf(value.toString());
            }
        }
    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objet = new HashMap<>();
        objet.put(__hauteur, hauteur);
        objet.put(__largeur, largeur);
        objet.put(__pourGagner, pourGagner);
        return objet;
    }
}
