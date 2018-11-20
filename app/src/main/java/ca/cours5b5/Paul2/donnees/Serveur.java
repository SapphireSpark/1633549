package ca.cours5b5.Paul2.donnees;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import ca.cours5b5.Paul2.modeles.MParametres;
import ca.cours5b5.Paul2.modeles.MPartie;

public final class Serveur extends SourceDeDonnees {

    private Serveur(){}
    private static final Serveur instance = new Serveur();

    public static Serveur getInstance() {
        return instance;
    }


    @Override
    public void chargerModele(String cheminSauvegarde, final ListenerChargement listenerChargement) {

        if (findNomModele(cheminSauvegarde)){ //vérifier le cheminSauvegarde, il doit etre de forme nomModele/IdUsager
            DatabaseReference noeud = FirebaseDatabase.getInstance().getReference(cheminSauvegarde);

            noeud.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Map<String, Object> objetJson = (Map<String, Object>) dataSnapshot.getValue();
                        Log.d("atelier12", Serveur.class.getSimpleName() + "::chargement de la sauvegarde serveur");
                        listenerChargement.reagirSucces(objetJson);
                        //donnees
                    } else {
                        //pas de donnees
                        Log.d("atelier12", Serveur.class.getSimpleName() + "::non-chargement de la sauvegarde serveur");
                        listenerChargement.reagirErreur(null);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    //erreur de lecture
                    Log.d("atelier12", Serveur.class.getSimpleName() + "::non-chargement de la sauvegarde serveur");
                    listenerChargement.reagirErreur(null);
                }
            });
        }
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

    private Boolean findNomModele(String cheminSauvegarde){
        boolean retour = true;

        Log.d("atelier12", this.getClass().getSimpleName() + "::findNomModele = "+ cheminSauvegarde);

        if(!cheminSauvegarde.contains("/")){
            retour = false;

        } else {

            String[] cheminSplit = cheminSauvegarde.split("/");
            String nomModele = cheminSplit[0];
            String extension = cheminSplit[1];

            if (nomModele.equals(MPartie.class.getSimpleName()) || nomModele.equals(MParametres.class.getSimpleName())){

            } else {

                retour = false;
            }

        }
        Log.d("atelier12", this.getClass().getSimpleName() + "::findNomModele = "+ retour);
        return retour;
    }

}
