package ca.cours5b5.Paul2.donnees;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

public final class Serveur extends SourceDeDonnees {

    private Serveur(){}
    private static final Serveur instance = new Serveur();

    public static Serveur getInstance() {
        return instance;
    }


    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {
        return null;
    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {
        String chemin = cheminSauvegarde;
        DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(chemin);
        noeud.setValue(objetJson);

    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {

    }
}
