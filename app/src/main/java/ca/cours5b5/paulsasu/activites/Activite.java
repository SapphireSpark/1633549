package ca.cours5b5.paulsasu.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.paulsasu.R;

public abstract class Activite extends AppCompatActivity {
    Class metaDonnes = Activite.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        Log.d("MenuPrincipal",this.getResources().getString(Integer.parseInt(metaDonnes.getSimpleName())));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MenuPrincipal",this.getResources().getString(Integer.parseInt(metaDonnes.getSimpleName())));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MenuPrincipal",this.getResources().getString(Integer.parseInt(metaDonnes.getSimpleName())));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MenuPrincipal",this.getResources().getString(Integer.parseInt(metaDonnes.getSimpleName())));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MenuPrincipal",this.getResources().getString(Integer.parseInt(metaDonnes.getSimpleName())));
    }

    static {
        Log.d("Activite","::Static");
    }
}
