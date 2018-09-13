package ca.cours5b5.paulsasu.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.serialisation.Jsonification;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

        if(savedInstanceState != null){
            String json = savedInstanceState.getString(modele.getClass().getSimpleName());

            Map<String, Object> objetJson = Jsonification.enObjetJson(json);

            modele.aPartirObjetJson(objetJson);

            restaurerParametres(savedInstanceState);
        }



    }

    private void restaurerParametres(Bundle savedInstanceState) {
        String json = savedInstanceState.getString(modele.getClass().getSimpleName());
        Map<String, Object> objetJson = Jsonification.enObjetJson(json);

        modele.aPartirObjetJson(objetJson);
        Log.d("Atelier05",metaDonnes.getSimpleName() + "::restaurerParametres, clé: " + modele.getClass().getSimpleName());
        Log.d("Atelier05",metaDonnes.getSimpleName() + "::restaurerParametres, json:" + json);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        Map<String, Object> objetJson = modele.enObjetJson();
        String json = Jsonification.enChaine(objetJson);

        sauvegarderParametres(outState);

    }

    private void sauvegarderParametres(Bundle outState) {
        if (outState != null) {
            Map<String, Object> objetJson = modele.enObjetJson();
            String json = Jsonification.enChaine(objetJson);
            Log.d("Atelier05",metaDonnes.getSimpleName() + "::sauvegarderParametres, clé: " + modele.getClass().getSimpleName());
            Log.d("Atelier05",metaDonnes.getSimpleName() + "::sauvegarderParametres, json: " + json);
            outState.putString(modele.getClass().getSimpleName(), json);
        }

    }

    static {
        Log.d("Atelier04","AParametres::Static");
    }

}
