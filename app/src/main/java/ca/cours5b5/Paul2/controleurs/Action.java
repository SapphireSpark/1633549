package ca.cours5b5.Paul2.controleurs;


import ca.cours5b5.Paul2.controleurs.interfaces.Fournisseur;
import ca.cours5b5.Paul2.controleurs.interfaces.ListenerFournisseur;

public class Action {

    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args) {
        this.args = args;
    }

    public void executerDesQuePossible(){
        ControleurAction.executerDesQuePossible(this);
    }


    Action cloner(){

        Action clone = new Action();

        clone.fournisseur = fournisseur;
        clone.listenerFournisseur = listenerFournisseur;

        if(args != null){
            clone.args = args.clone();
        }

        return clone;
    }


}
