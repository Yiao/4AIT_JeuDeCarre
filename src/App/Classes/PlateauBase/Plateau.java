package App.Classes.PlateauBase;

import App.Classes.PlateauBase.Case;

/**
 * Created by sya on 5/22/2017.
 */
public class Plateau {

    //recupérer la taille du plateau from MAIN
    private int tailleDePlateau = 5;
    private int nbPoids3 = 0;
    private int nbPoids2 = 0;
    private int nbPoids1 = 0;
    private int nbPoids0 = 0;

    public int getNbPoids3() {
        return nbPoids3;
    }

    public void setNbPoids3(int nbPoids3) {
        this.nbPoids3 = nbPoids3;
    }

    public int getNbPoids2() {
        return nbPoids2;
    }

    public void setNbPoids2(int nbPoids2) {
        this.nbPoids2 = nbPoids2;
    }

    public int getNbPoids1() {
        return nbPoids1;
    }

    public void setNbPoids1(int nbPoids1) {
        this.nbPoids1 = nbPoids1;
    }

    public int getNbPoids0() {
        return nbPoids0;
    }

    public void setNbPoids0(int nbPoids0) {
        this.nbPoids0 = nbPoids0;
    }


    public int getTailleDePlateau() {
        return tailleDePlateau;
    }

    public void setTailleDePlateau(int tailleDePlateau) {
        this.tailleDePlateau = tailleDePlateau;
    }

    private Case[][] plateau =new Case[tailleDePlateau][tailleDePlateau];

    public void initPlateau(){
        for (int i = 0; i < tailleDePlateau ; i++) {
            for (int j = 0; j < tailleDePlateau ; j++) {

                Case myCase = new Case();
                myCase.positionCase.setX(i);
                myCase.positionCase.setY(j);

                plateau[i][j] = myCase;

                plateau[i][j].setPoids(0);
                int poids = plateau[i][j].getPoids();

                switch (poids){
                    case 0 :
                        nbPoids0 +=1;
                        break;
                    case 1:
                        nbPoids1 +=1;
                        break;
                    case 2:
                        nbPoids2 +=1;
                        break;
                    default:
                        nbPoids3 +=1;
                        break;
                }
            }
        }
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(Case[][] plateau) {
        this.plateau = plateau;
    }
}
