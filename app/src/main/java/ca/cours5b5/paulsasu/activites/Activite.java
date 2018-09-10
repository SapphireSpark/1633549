package ca.cours5b5.paulsasu.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ca.cours5b5.paulsasu.R;

public abstract class Activite extends AppCompatActivity {
    Class metaDonnes = this.getClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
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
