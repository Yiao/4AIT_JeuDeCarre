package App.Classes;

/**
 * Created by sya on 5/22/2017.
 */
public class Traits {
    private  boolean haut = false;
    private boolean bas = false;
    private boolean gauche = false;
    private boolean droite = false;

    public boolean isHaut() {
        return haut;
    }

    public void setHaut(boolean haut) {
        this.haut = haut;
    }

    public boolean isBas() {
        return bas;
    }

    public void setBas(boolean bas) {
        this.bas = bas;
    }

    public boolean isGauche() {
        return gauche;
    }

    public void setGauche(boolean gauche) {
        this.gauche = gauche;
    }

    public boolean isDroite() {
        return droite;
    }

    public void setDroite(boolean droite) {
        this.droite = droite;
    }
}
