package ca.cours5b5.Paul2.exceptions;


public class ErreurModele extends RuntimeException {

    public ErreurModele(Exception e) {super(e);}

    public ErreurModele(String message){
        super(message);
    }


}
