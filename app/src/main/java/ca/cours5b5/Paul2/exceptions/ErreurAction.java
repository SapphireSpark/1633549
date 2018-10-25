package ca.cours5b5.Paul2.exceptions;


public class ErreurAction extends RuntimeException {

    public ErreurAction(String message){
        super(message);
    }

    public ErreurAction(Exception e){
        super(e);
    }

}
