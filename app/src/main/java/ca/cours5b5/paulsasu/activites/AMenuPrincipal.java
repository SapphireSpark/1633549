package ca.cours5b5.paulsasu.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.paulsasu.R;

public class AMenuPrincipal extends Activite {

    static {
        Log.d("Atelier04","AMenuPrincipal::Static");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        Button boutonParametres = this.findViewById(R.id.bouton_parametres);

        Button boutonPartie = this.findViewById(R.id.bouton_partie);

        boutonPartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessPartie();
            }
        });

        boutonParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accessParam();

            }
        });

    }

    private void accessParam() {
        Intent monIntention = new Intent(this, AParametres.class);
        this.startActivity(monIntention);
    }

    private void accessPartie() {
        Intent monIntention = new Intent(this, APartie.class);
        this.startActivity(monIntention);
    }

}
