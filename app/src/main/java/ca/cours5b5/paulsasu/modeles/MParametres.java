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
