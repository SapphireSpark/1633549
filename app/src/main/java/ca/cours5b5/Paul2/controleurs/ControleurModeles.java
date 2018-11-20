package ca.cours5b5.Paul2.controleurs;

import android.net.sip.SipSession;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.Paul2.controleurs.interfaces.Fournisseur;
import ca.cours5b5.Paul2.controleurs.interfaces.ListenerGetModele;
import ca.cours5b5.Paul2.donnees.ListenerChargement;
import ca.cours5b5.Paul2.donnees.Serveur;
import ca.cours5b5.Paul2.donnees.SourceDeDonnees;
import ca.cours5b5.Paul2.exceptions.ErreurModele;
import ca.cours5b5.Paul2.modeles.MParametres;
import ca.cours5b5.Paul2.modeles.MParametresPartie;
import ca.cours5b5.Paul2.modeles.MPartie;
import ca.cours5b5.Paul2.modeles.Modele;
import ca.cours5b5.Paul2.donnees.Disque;
import ca.cours5b5.Paul2.usagers.UsagerCourant;

public final class ControleurModeles {

    private ControleurModeles(){}

    private static Map<String, Modele> modelesEnMemoire;

    private static SourceDeDonnees[] sequenceDeChargement;

    private static List<SourceDeDonnees> listeDeSauvegardes;

    static {

        modelesEnMemoire = new HashMap<>();

        listeDeSauvegardes = new ArrayList<>();
        listeDeSauvegardes.add(Disque.getInstance());

        listeDeSauvegardes.add(Serveur.getInstance());

    }

    static void getModele(final String nomModele, ListenerGetModele listenerGetModele) {
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::getModele");
        Modele modele = modelesEnMemoire.get(nomModele);

        if (modele != null) {
            listenerGetModele.reagirAuModele(modele);

        } else {
            creerModeleEtChargerDonnees(nomModele, listenerGetModele);

        }
    }

    private static void creerModeleSelonNom(String nomModele, final ListenerGetModele listenerGetModele) throws ErreurModele {
        Modele modele;

        if(nomModele.equals(MParametres.class.getSimpleName())){

            modele = new MParametres();
            modelesEnMemoire.put(nomModele, modele);
            listenerGetModele.reagirAuModele(modele);

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            MParametres mParametres = (MParametres) getModele(MParametres.class.getSimpleName());
            modele = new MPartie(mParametres.getParametresPartie().cloner());
            modelesEnMemoire.put(nomModele, modele);
            listenerGetModele.reagirAuModele(modele);

        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }

    }

    private static void creerModeleEtChargerDonnees(final String nomModele, final ListenerGetModele listenerGetModele) {
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::creerModeleEtChargerDonnees");

        Modele modele;

        if(nomModele.equals(MParametres.class.getSimpleName())){

            modele = new MParametres();
            modelesEnMemoire.put(nomModele, modele);
            listenerGetModele.reagirAuModele(modele);

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            MParametres mParametres = (MParametres) getModele(MParametres.class.getSimpleName());
            modele = new MPartie(mParametres.getParametresPartie().cloner());
            modelesEnMemoire.put(nomModele, modele);
            listenerGetModele.reagirAuModele(modele);

        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }

        //creerModeleSelonNom(nomModele, listenerGetModele);

        //modelesEnMemoire.put()

        chargerDonnees(modele, nomModele, listenerGetModele);
        //modelesEnMemoire.put()
        //memoriser le modele en memoire
    }

    private static void chargerDonnees(Modele modele, String nomModele, ListenerGetModele listenerGetModele){
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::chargerDonnees");
        chargementViaSequence(modele, getCheminSauvegarde(nomModele), listenerGetModele, 0);
    }

    private static void chargementViaSequence(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante){
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::chargementViaSequence");
        if (sequenceDeChargement.length <= indiceSourceCourante){
            terminerChargement(modele, listenerGetModele);

        } else {

            chargementViaSourceCouranteOuSuivante(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante);

        }
    }

    private static void chargementViaSourceCouranteOuSuivante(final Modele modele, final String cheminDeSauvegarde, final ListenerGetModele listenerGetModele, final int indiceSourceCourante ){
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::chargementViaSequenceCouranteOuSuivante");
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::chemein = " + cheminDeSauvegarde);
        SourceDeDonnees source = sequenceDeChargement[indiceSourceCourante];
        source.chargerModele(cheminDeSauvegarde, new ListenerChargement() {
            @Override
            public void reagirSucces(Map<String, Object> objetJson) {
                Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::ReagirSuccess");
                terminerChargementAvecDonnees(objetJson, modele, listenerGetModele);
            }

            @Override
            public void reagirErreur(Exception e) {
                Log.d("atelier12", "Reagir Erreur:: Erreur");
                chargementViaSourceSuivante(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante);
            }
        });
    }

    private static void terminerChargementAvecDonnees(Map<String, Object> objetJson, Modele modele, ListenerGetModele listenerGetModele) {
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::terminerChargementAvecDonnees");
        modele.aPartirObjetJson(objetJson);
        terminerChargement(modele, listenerGetModele);
    }

    private static void terminerChargement(Modele modele, ListenerGetModele listenerGetModele) {
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::terminerChargement");
        listenerGetModele.reagirAuModele(modele);
    }

    private static void chargementViaSourceSuivante(Modele modele, String cheminDeSauvegarde, ListenerGetModele listenerGetModele, int indiceSourceCourante) {
        Log.d("atelier12", ControleurModeles.class.getSimpleName() + "::chargementViaSourceSuivante");
        chargementViaSequence(modele, cheminDeSauvegarde, listenerGetModele, indiceSourceCourante+1);
    }

    public static void setSequenceDeChargement(SourceDeDonnees... sequenceDeChargement){

        ControleurModeles.sequenceDeChargement = sequenceDeChargement;

    }

    public static void sauvegarderModeleDansCetteSource(String nomModele, SourceDeDonnees sourceDeDonnees) {

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele != null){

            Map<String, Object> objetJson = modele.enObjetJson();

            if (sourceDeDonnees == Serveur.getInstance()) {
                Serveur.getInstance().sauvegarderModele(getCheminSauvegarde(nomModele), objetJson);
            } else {
                sourceDeDonnees.sauvegarderModele(nomModele, objetJson);
            }

        }
    }

    static Modele getModele(final String nomModele){

        Modele modele = modelesEnMemoire.get(nomModele);

        if(modele == null){

            modele =  chargerViaSequenceDeChargement(nomModele);

        }

        return modele;
    }


    private static Modele chargerViaSequenceDeChargement(final String nomModele){

        Modele modele = creerModeleSelonNom(nomModele);

        modelesEnMemoire.put(nomModele, modele);

        for(SourceDeDonnees sourceDeDonnees : sequenceDeChargement){

            Map<String, Object> objetJson = sourceDeDonnees.chargerModele(nomModele);

            if(objetJson != null){

                modele.aPartirObjetJson(objetJson);
                break;

            }

        }

        return modele;
    }

    public static void sauvegarderModele(String nomModele) throws ErreurModele {

        for(SourceDeDonnees source : listeDeSauvegardes){

            sauvegarderModeleDansCetteSource(nomModele, source);

        }

    }


    private static Modele creerModeleSelonNom(String nomModele) throws ErreurModele {

        if(nomModele.equals(MParametres.class.getSimpleName())){

            return new MParametres();

        }else if(nomModele.equals(MPartie.class.getSimpleName())){

            MParametres mParametres = (MParametres) getModele(MParametres.class.getSimpleName());

            return new MPartie(mParametres.getParametresPartie().cloner());

        }else{

            throw new ErreurModele("Modèle inconnu: " + nomModele);

        }
    }

    public static void detruireModele(String nomModele) {

    }

    private static String getCheminSauvegarde(String nomModele) {
        return nomModele + "/" + UsagerCourant.getId();
    }

}
