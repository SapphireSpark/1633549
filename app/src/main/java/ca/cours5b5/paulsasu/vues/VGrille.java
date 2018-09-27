package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

;import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.MParametresPartie;

public class VGrille extends GridLayout {
    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase> {}

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void intialiser() {

    }

    void creerGrille(int hauteur, int largeur) {
        hauteur = 0;
        largeur = 0;



    }

    private void initialiserColonnes(int largeur) {

    }

    private void ajouterEnTetes(int largeur){

    }

    private LayoutParams getMiseEnPageEntetes(int colonnes){

        return null;
    }

    private void ajouterCases(int hauteur, int largeur){

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        return null;
    }
}
