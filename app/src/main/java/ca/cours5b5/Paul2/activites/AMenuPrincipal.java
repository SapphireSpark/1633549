package ca.cours5b5.Paul2.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.Paul2.R;
import ca.cours5b5.Paul2.controleurs.ControleurAction;
import ca.cours5b5.Paul2.controleurs.interfaces.Fournisseur;
import ca.cours5b5.Paul2.controleurs.interfaces.ListenerFournisseur;
import ca.cours5b5.Paul2.global.GCommande;
import ca.cours5b5.Paul2.global.GConstantes;
import ca.cours5b5.Paul2.vues.VMenuPrincipal;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class AMenuPrincipal extends Activite implements Fournisseur {


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == GConstantes.MA_CONSTANTE_CODE_CONNEXION) {
            if (resultCode == RESULT_OK) {
                Button boutonConnection = findViewById(R.id.connect);
                Button boutonDeconnection = findViewById(R.id.deco);

                boutonConnection.setVisibility(View.INVISIBLE);
                boutonDeconnection.setVisibility(View.VISIBLE);

                Log.d("Atelier11", "Connexion Reussie");
            } else {
                Log.d("Atelier11", "Erreur de Connection");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

       fournirActions();

    }

    private void fournirActions() {

        fournirActionOuvrirMenuParametres();

        fournirActionDemarrerPartie();

        fournirActionConnection();

        fournirActionDeconnection();

    }

    private void transitionConnection() {
        List<AuthUI.IdpConfig> fournisseursDeConnexion = new ArrayList<>();

        fournisseursDeConnexion.add(new AuthUI.IdpConfig.GoogleBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.EmailBuilder().build());
        fournisseursDeConnexion.add(new AuthUI.IdpConfig.PhoneBuilder().build());

        Intent intentionConnexion = AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(fournisseursDeConnexion).build();

        this.startActivityForResult(intentionConnexion, GConstantes.MA_CONSTANTE_CODE_CONNEXION);

    }



    private void transitionDeconnection() {
        AuthUI.getInstance().signOut(this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Button boutonConnection = findViewById(R.id.connect);
                Button boutonDeconnection = findViewById(R.id.deco);

                boutonDeconnection.setVisibility(View.INVISIBLE);
                boutonConnection.setVisibility(View.VISIBLE);
            }
        });
    }

    private void fournirActionOuvrirMenuParametres() {

        ControleurAction.fournirAction(this,
                GCommande.OUVRIR_MENU_PARAMETRES,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionParametres();

                    }
                });
    }

    private void fournirActionDemarrerPartie() {

        ControleurAction.fournirAction(this,
                GCommande.DEMARRER_PARTIE,
                new ListenerFournisseur() {
                    @Override
                    public void executer(Object... args) {

                        transitionPartie();

                    }
                });
    }

    private void fournirActionConnection() {
        ControleurAction.fournirAction(this, GCommande.CONNECTION, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                transitionConnection();


            }
        });
    }

    private void fournirActionDeconnection() {
        ControleurAction.fournirAction(this, GCommande.DECONNECTION, new ListenerFournisseur() {
            @Override
            public void executer(Object... args) {
                transitionDeconnection();
            }
        });
    }

    private void transitionParametres(){

        Intent intentionParametres = new Intent(this, AParametres.class);
        startActivity(intentionParametres);

    }

    private void transitionPartie(){

        Intent intentionParametres = new Intent(this, APartie.class);
        startActivity(intentionParametres);

    }

}
