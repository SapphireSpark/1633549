package ca.cours5b5.paulsasu.vues;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
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
        Log.d("Atelier06","Check");
    }

    void creerGrille(int hauteur, int largeur) {
        this.setRowCount(hauteur);
        this.setColumnCount(largeur);

        ajouterEnTetes(largeur);
        ajouterCases(hauteur, largeur);

    }

    private void ajouterEnTetes(int largeur){
        for (int i = 0; i < largeur; i++){
            VEntete entete = new VEntete(this.getContext(), i);
            this.addView(entete, getMiseEnPageEntetes(i));

        }

    }

    private LayoutParams getMiseEnPageEntetes(int colonnes){
        float poidsRangee = 2.0f;
        float poidsColonne = 1.0f;

        Spec specRangee = GridLayout.spec(0, poidsRangee);
        Spec specColonne = GridLayout.spec(colonnes, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }

    private void ajouterCases(int hauteur, int largeur){
        for (int i = 1; i < hauteur; i++){
            for (int z = 0; z < largeur; z++){
                this.addView(new VCase(this.getContext(), hauteur - 1 - i, z), getMiseEnPageCase(i,z));
            }
        }
    }

    private LayoutParams getMiseEnPageCase(int rangee, int colonne){
        float poidsRangee = 1.0f;
        float poidsColonne = 1.0f;

        Spec specRangee = GridLayout.spec(rangee, poidsRangee);
        Spec specColonne = GridLayout.spec(colonne, poidsColonne);

        LayoutParams mesParams = new LayoutParams(specRangee, specColonne);

        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }

}
