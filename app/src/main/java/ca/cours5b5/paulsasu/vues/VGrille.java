package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
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
        this.addView(this, getMiseEnPageEntetes(largeur));
        this.addView(this, getMiseEnPageCase(hauteur, largeur));



    }

    private void initialiserColonnes(int largeur) {

    }

    private void ajouterEnTetes(int largeur){
        for (int i = 0; i < largeur; i++) {
            entetes.add(new VEntete(this.getContext(), i));
        }

    }

    private LayoutParams getMiseEnPageEntetes(int colonnes){
        LayoutParams param = new LayoutParams();
        param.width = 0;
        param.height = 0;
        param.setGravity(Gravity.FILL);

        for (VEntete entete : entetes) {
            entete.setLayoutParams(param);
        }
        return param;
    }

    private void ajouterCases(int hauteur, int largeur){

    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){

        return null;
    }
}
