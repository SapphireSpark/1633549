package ca.cours5b5.paulsasu.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.paulsasu.R;

public class AParametres extends Activite {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);

    }

    static {
        Log.d("Atelier04","AParametres::Static");
    }

}
