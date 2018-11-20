package ca.cours5b5.Paul2.donnees;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Map;

import ca.cours5b5.Paul2.global.GConstantes;
import ca.cours5b5.Paul2.modeles.MParametres;
import ca.cours5b5.Paul2.modeles.MPartie;
import ca.cours5b5.Paul2.serialisation.Jsonification;

public final class Disque extends SourceDeDonnees {

    private static final Disque instance = new Disque();

    public static Disque getInstance() {
        return instance;
    }

    private File repertoireRacine;

    private Disque() {}

    public void setRepertoireRacine(File repertoireRacine) {

        this.repertoireRacine = repertoireRacine;

    }

    @Override
    public Map<String, Object> chargerModele(String cheminSauvegarde) {

        if (findNomModele(getNomFichier(cheminSauvegarde))) {
            File fichier = getFichier(cheminSauvegarde);

            try {

                String json = new String(Files.readAllBytes(fichier.toPath()));

                Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);

                return objetJson;

            } catch (FileNotFoundException e) {

                return null;

            } catch (IOException e) {

                return null;

            }

        } else {
            return null;
        }

    }

    @Override
    public void sauvegarderModele(String cheminSauvegarde, Map<String, Object> objetJson) {

        File fichier = getFichier(cheminSauvegarde);

        String json = Jsonification.enChaineJson(objetJson);

        try {

            OutputStream outputStream = new FileOutputStream(fichier);

            outputStream.write(json.getBytes());

        } catch (FileNotFoundException e) {

            Log.d("Atelier07", "File not found: " + cheminSauvegarde);

        } catch (IOException e) {

            Log.d("Atelier07", "IOException: " + cheminSauvegarde);

        }
    }

    @Override
    public void chargerModele(String cheminSauvegarde, ListenerChargement listenerChargement) {
        if (findNomModele(getNomFichier(cheminSauvegarde))){

            File fichier = getFichier(cheminSauvegarde);

            try {

                String json = new String(Files.readAllBytes(fichier.toPath()));

                Map<String, Object> objetJson = Jsonification.aPartirChaineJson(json);
                Log.d("atelier12", "chargement de la sauvegarde disque");
                listenerChargement.reagirSucces(objetJson);

            } catch (FileNotFoundException e) {
                Log.d("atelier12", "non-chargement de la sauvegarde disque");

                listenerChargement.reagirErreur(e);

            } catch (IOException e) {
                Log.d("atelier12", "non-chargement de la sauvegarde disque");

                listenerChargement.reagirErreur(e);

            }

        }
    }


    private File getFichier(String cheminSauvegarde) {
        String nomModele = this.getNomModele(cheminSauvegarde);

        String nomFichier = getNomFichier(nomModele);

        return new File(repertoireRacine, nomFichier);

    }

    private String getNomFichier(String nomModele) {

        return nomModele + GConstantes.EXTENSION_PAR_DEFAUT;

    }

    private Boolean findNomModele(String cheminSauvegarde){
        boolean retour = true;

        Log.d("atelier12", this.getClass().getSimpleName() + "::findNomModele = "+ cheminSauvegarde);

        if(cheminSauvegarde.contains("/")){
            retour = false;

        } else {

            String[] cheminSplit = cheminSauvegarde.split("\\.");
            String nomModele = cheminSplit[0];
            String extension = cheminSplit[1];

            if (nomModele.equals(MPartie.class.getSimpleName()) || nomModele.equals(MParametres.class.getSimpleName())){

            } else if (!extension.equals(GConstantes.EXTENSION_PAR_DEFAUT)){

                retour = false;
            } else {

                retour = false;
            }

        }

        Log.d("atelier12", this.getClass().getSimpleName() + "::findNomModele = "+ retour);
        return retour;
    }

}
