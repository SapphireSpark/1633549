package ca.cours5b5.Paul2.usagers;

import com.google.firebase.auth.FirebaseAuth;

public class UsagerCourant {
    public static boolean siUsagerConnecte() {
        boolean check = true;

        if (FirebaseAuth.getInstance().getCurrentUser() == null ) {
            check = false;
        }

        return check;

    }

    public static String getId() {
        String uid = "0";
        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        return uid;
    }
}
