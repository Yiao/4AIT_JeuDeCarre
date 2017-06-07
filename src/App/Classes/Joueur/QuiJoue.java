package App.Classes.Joueur;

/**
 * Created by sya on 05/06/2017.
 */
public class QuiJoue {
    private static boolean joueur1 = true;

    public static boolean isJoueur1() {
        return joueur1;
    }

    public static void ChangeJoueur(){
        if (joueur1){
            joueur1 = false;
        }else {
            joueur1 = true;
        }
    }
}
