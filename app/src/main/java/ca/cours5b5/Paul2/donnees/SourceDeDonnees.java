package ca.cours5b5.Paul2.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract Map<String, Object> chargerModele(final String cheminSauvegarde);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    protected String getNomModele(String cheminSauvegarde) {
        String [] partie = cheminSauvegarde.split("/");
        String nomModele = partie[0];

        return nomModele;
    }

}
