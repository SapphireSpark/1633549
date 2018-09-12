package ca.cours5b5.paulsasu.modeles;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.global.GConstantes;
import ca.cours5b5.paulsasu.serialisation.AttributSerialisable;

public class MParametres extends Modele {
    public static MParametres instance;

    @AttributSerialisable
    public Integer hauteur = GConstantes.HAUT_DEF;
    private final String __hauteur = "hauteur";

    @AttributSerialisable
    public Integer largeur = GConstantes.LARG_DEF;
    private final String __largeur = "largeur";

    @AttributSerialisable
    public Integer pourGagner = GConstantes.WIN_DEF;
    private final String __pourGagner= "pourGagner";

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


    @Override
    public void aPartirObjetJson(Map<String, Object> objectJson) {

    }

    @Override
    public Map<String, Object> enObjetJson() {
        return null;
    }
}
