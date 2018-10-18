package ca.cours5b5.paulsasu.modeles;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.global.GConstantes;
import ca.cours5b5.paulsasu.serialisation.AttributSerialisable;

public class MParametres extends Modele {
    public static MParametres instance = new MParametres();

    @AttributSerialisable
    public MParametresPartie parametresPartie = new MParametresPartie();
    private String __parametresPartie = "parametresPartie";

    public List<Integer> getChoixHauteur() {
        List<Integer> listH = new ArrayList<>();

        for (int i = 0; i <= (GConstantes.HAUT_MAX - GConstantes.HAUT_MIN); i++) {
            listH.add(GConstantes.HAUT_MIN + i);
        }
        return listH;
    }

    public List<Integer> getChoixLargeur() {
        List<Integer> listL = new ArrayList<>();

        for (int i = 0; i <= (GConstantes.LARG_MAX - GConstantes.LARG_MIN); i++) {
            listL.add(GConstantes.LARG_MIN + i);
        }
        return listL;
    }

    public List<Integer> getChoixPourGagner() {
        List<Integer> listW = new ArrayList<>();

        for (int i = 0; i <= (GConstantes.WIN_MAX - GConstantes.WIN_MIN); i++) {
            listW.add(GConstantes.WIN_MIN + i);
        }
        return listW;
    }

    public MParametresPartie getParametresPartie() {
        return parametresPartie;
    }

    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) {

        this.parametresPartie.hauteur = Integer.parseInt(objetJson.get("hauteur").toString());
        this.parametresPartie.largeur = Integer.parseInt(objetJson.get("largeur").toString());
        this.parametresPartie.pourGagner = Integer.parseInt(objetJson.get("pourGagner").toString());

    }

    @Override
    public Map<String, Object> enObjetJson() {
        Map<String, Object> objet = new HashMap<>();

        objet.put("hauteur", this.parametresPartie.hauteur.toString());
        objet.put("largeur", this.parametresPartie.largeur.toString());
        objet.put("pourGagner", this.parametresPartie.pourGagner.toString());

        return objet;
    }
}
