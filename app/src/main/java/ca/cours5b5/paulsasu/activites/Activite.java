package ca.cours5b5.paulsasu.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Map;

import ca.cours5b5.paulsasu.R;
import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.Modele;
import ca.cours5b5.paulsasu.serialisation.Jsonification;

public abstract class Activite extends AppCompatActivity {
    Class metaDonnes = this.getClass();
    protected Modele modele = MParametres.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        if(savedInstanceState != null){
            String json = savedInstanceState.getString("Activite");

            Map<String, Object> objetJson = Jsonification.enObjetJson(json);

            for(Map.Entry<String, Object> entry : objetJson.entrySet()){
                String cle = entry.getKey();
                Object valeur = entry.getValue();
            }

            modele.aPartirObjetJson(objetJson);
        }
        Log.d("Atelier04",metaDonnes.getSimpleName() + "::onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Atelier04",metaDonnes.getSimpleName() + "::onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Atelier04",metaDonnes.getSimpleName() + "::onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Map<String, Object> objetJson = modele.enObjetJson();
        String json = Jsonification.enChaine(objetJson);
        outState.putString("Activite", json);
        Log.d("Atelier04",metaDonnes.getSimpleName() + "::onSaveInstanceState");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Atelier04",metaDonnes.getSimpleName() + "::onDestroy");
    }

    static {
        Log.d("Atelier04","Activite::Static");
    }
}
