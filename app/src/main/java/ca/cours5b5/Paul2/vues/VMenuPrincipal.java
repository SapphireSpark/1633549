package ca.cours5b5.Paul2.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.Paul2.R;
import ca.cours5b5.Paul2.controleurs.Action;
import ca.cours5b5.Paul2.controleurs.ControleurAction;
import ca.cours5b5.Paul2.global.GCommande;


public class VMenuPrincipal extends Vue {

    private Button boutonParametres;
    private Action actionParametres;

    private Button boutonPartie;
    private Action actionPartie;
    private Button boutonConnection;
    private Action actionConnection;
    private Button boutonDeconnection;
    private Action actionDeconnection;

    public VMenuPrincipal(Context context) {
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();

        recupererControles();

        demanderActions();

        installerListeners();

    }


    private void recupererControles() {

        boutonParametres = findViewById(R.id.bouton_parametres);

        boutonPartie = findViewById(R.id.bouton_partie);

        boutonConnection = findViewById(R.id.connect);

        boutonDeconnection = findViewById(R.id.deco);



    }

    private void demanderActions() {

        actionParametres = ControleurAction.demanderAction(GCommande.OUVRIR_MENU_PARAMETRES);

        actionPartie = ControleurAction.demanderAction(GCommande.DEMARRER_PARTIE);

        actionConnection = ControleurAction.demanderAction(GCommande.CONNECTION);

        actionDeconnection = ControleurAction.demanderAction((GCommande.DECONNECTION));



    }


    private void installerListeners() {

        installerListenerParametres();

        installerListenerPartie();

    }

    private void installerListenerPartie() {

        boutonPartie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionPartie.executerDesQuePossible();
            }
        });

    }

    private void installerListenerParametres() {

        boutonParametres.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionParametres.executerDesQuePossible();
            }
        });

    }

    private void installerListenerConnection() {
        boutonConnection.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionConnection.executerDesQuePossible();
            }
        });
    }

    private void installerListenerDeconnection() {
        boutonDeconnection.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionDeconnection.executerDesQuePossible();
            }
        });
    }

}
