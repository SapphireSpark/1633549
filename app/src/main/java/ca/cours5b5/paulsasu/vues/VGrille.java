package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;

;import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.paulsasu.modeles.MParametres;
import ca.cours5b5.paulsasu.modeles.MParametresPartie;
import ca.cours5b5.paulsasu.modeles.MPartie;

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

    private VCase[][] lesCases;

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    void creerGrille(int hauteur, int largeur) {
        this.addView(this, getMiseEnPageEntetes(largeur));
        this.addView(this, getMiseEnPageCase(hauteur, largeur));
        for (int i = 0; i < hauteur; i++) {
            for (int z = 0; z < largeur; z++) {

            }
        }



    }

    private void initialiserColonnes(int largeur) {
        this.ajouterEnTetes(largeur);
        for (int i = 0; i < largeur; i++) {
            Colonne colonne = new Colonne();
            colonnesDeCases.add(colonne);
        }


    }

    private void initialiserTableauDeCases (int hauteur, int largeur) {

        for (int i = 0; i < hauteur; i++) {
            for (int z = 0; z < largeur; z++) {
                VCase cases = new VCase(this.getContext(), i, z);
                lesCases[i][z] = cases;
            }
        }
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
        Colonne colonne = new Colonne();
        VCase cases = new VCase(this.getContext(), hauteur, largeur);
        colonne.add(cases);
        colonnesDeCases.add(colonne);
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){
        rangee = (int) 1.03;
        colonne = (int) 1.03;

        float poidsRangee = 0;
        float poidsColonne = 0;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }
}
