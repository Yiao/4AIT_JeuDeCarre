package App.Classes.Joueur;

import App.Classes.PlateauBase.Case;
import App.Classes.PlateauBase.Plateau;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.shape.Rectangle;

import java.awt.*;

/**
 * Created by sya on 5/22/2017.
 */
public abstract class Joueurs {
    protected String nom;
    protected String color;
    protected boolean isIA ;
    protected boolean tourDeJouer;
    protected int points = 0;

    public boolean isTourDeJouer() {
        return tourDeJouer;
    }

    public void setTourDeJouer(boolean tourDeJouer) {
        this.tourDeJouer = tourDeJouer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isIA() {
        return isIA;
    }

    public void setIA(boolean IA) {
        isIA = IA;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void Jouer(Plateau startPlate, Event event, Joueurs joueur1, Joueurs joueur2);

    public void ChangeTopBouton(Plateau startPlate, Event event,int i, int j){

        boolean gagneUneCase = false;

        //check  top  0
        if (i == 0 ) {
            //    Button
            //B            B
            //o     C      o
            //u     A      u
            //t     S      t
            //o     E      o
            //n            n
            //    Button
            startPlate.getPlateau()[i][j].getTraits().setHaut(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_top_" + i + "_" + j).setStyle("-fx-base: "+color +";");


        } else if (i != 0) {
            //B            B
            //o     C      o
            //u     A      u
            //t     S      t
            //o     E      o
            //n            n
            //    Button

            startPlate.getPlateau()[i-1][j].getTraits().setBas(true);
            startPlate.getPlateau()[i][j].getTraits().setHaut(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_bot_" + (i-1) + "_" + j).setStyle("-fx-base: "+color +";");
        }

        RecalculerLesPoids(startPlate);

        if (startPlate.getPlateau()[i][j].getPoids()==4){
            ChangeColorRect(i,j,event,color);
            int point = getPoints();
            setPoints(point+1);
            gagneUneCase = true;
        }

        if (!gagneUneCase){
            QuiJoue.ChangeJoueur();
        }
    }
    public void ChangeBotBouton(Plateau startPlate, Event event,int i, int j){
        boolean gagneUneCase = false;

        if (i==startPlate.getTailleDePlateau()-1){
            //
            //B            B
            //o     C      o
            //u     A      u
            //t     S      t
            //o     E      o
            //n            n
            //    Button
            startPlate.getPlateau()[i][j].getTraits().setBas(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_bot_" + i + "_" + j).setStyle("-fx-base: "+color +";");


        }else if(i!=startPlate.getTailleDePlateau()-1){

            //B            B
            //o     C      o
            //u     A      u
            //t     S      t
            //o     E      o
            //n            n
            //    Button
            startPlate.getPlateau()[i][j].getTraits().setBas(true);
            startPlate.getPlateau()[i+1][j].getTraits().setHaut(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_bot_" + i + "_" + j).setStyle("-fx-base: "+color +";");
        }

        RecalculerLesPoids(startPlate);

        if (startPlate.getPlateau()[i][j].getPoids()==4){
            ChangeColorRect(i,j,event,color);
            int point = getPoints();
            setPoints(point+1);
            gagneUneCase = true;
        }

        if (!gagneUneCase){
            QuiJoue.ChangeJoueur();
        }
    }
    public void ChangeLeftBouton(Plateau startPlate, Event event,int i, int j){
        boolean gagneUneCase = false;

        //check left  0
        if (j==0){
            //B            B
            //o     C      o
            //u     A      u
            //t     S      t
            //o     E      o
            //n            n
            //    Button

            ((Node) event.getTarget()).getScene().lookup("#bt_left_" + i + "_" + j).setStyle("-fx-base: "+color +";");
            startPlate.getPlateau()[i][j].getTraits().setGauche(true);

        }else if(j!=0){

            //            B
            //     C      o
            //     A      u
            //     S      t
            //     E      o
            //            n
            //    Button
            startPlate.getPlateau()[i][j-1].getTraits().setDroite(true);
            startPlate.getPlateau()[i][j].getTraits().setGauche(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_right_" + i + "_" + (j-1)).setStyle("-fx-base: "+color +";");
        }


        RecalculerLesPoids(startPlate);

        if (startPlate.getPlateau()[i][j].getPoids()==4){
            ChangeColorRect(i,j,event,color);
            int point = getPoints();
            setPoints(point+1);
            gagneUneCase = true;
        }

        if (!gagneUneCase){
            QuiJoue.ChangeJoueur();
        }
    }
    public void ChangeRightBouton(Plateau startPlate, Event event,int i, int j){
        boolean gagneUneCase = false;
        //check right 0
        if (j==startPlate.getTailleDePlateau()-1){
            //            B
            //     C      o
            //     A      u
            //     S      t
            //     E      o
            //            n
            //    Button
            startPlate.getPlateau()[i][j].getTraits().setDroite(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_right_" + i + "_" + j).setStyle("-fx-base: "+color +";");


        } else if (j!=startPlate.getTailleDePlateau()-1){
            //B            B
            //o     C      o
            //u     A      u
            //t     S      t
            //o     E      o
            //n            n
            //    Button

            startPlate.getPlateau()[i][j].getTraits().setDroite(true);
            startPlate.getPlateau()[i][j+1].getTraits().setGauche(true);
            ((Node) event.getTarget()).getScene().lookup("#bt_right_" + i + "_" + j).setStyle("-fx-base: "+color +";");
        }

        RecalculerLesPoids(startPlate);

        if (startPlate.getPlateau()[i][j].getPoids()==4){
            ChangeColorRect(i,j,event,color);
            int point = getPoints();
            setPoints(point+1);
            gagneUneCase = true;
        }

        if (!gagneUneCase){
            QuiJoue.ChangeJoueur();
        }
    }

    public int[] PositionElementClick(Event event){
        String [] positionTableau = ((Control) event.getSource()).getId().split("_");
        int i =Integer.parseInt(positionTableau[2]);
        int j = Integer.parseInt(positionTableau[3]);
        return new int[]{i,j};
    }

    public int CalculerPoidsCase(Case caseIn){
        int poidCase = 0;
        if (caseIn.getTraits().isHaut()){
            poidCase += 1;
        }
        if (caseIn.getTraits().isBas()){
            poidCase += 1;
        }
        if (caseIn.getTraits().isGauche()){
            poidCase += 1;
        }
        if (caseIn.getTraits().isDroite()){
            poidCase += 1;
        }
        return poidCase;
    }

    public void RecalculerLesPoids(Plateau StartPlate){
        StartPlate.setNbPoids0(0);
        StartPlate.setNbPoids1(0);
        StartPlate.setNbPoids2(0);
        StartPlate.setNbPoids3(0);
        for (int i = 0; i < StartPlate.getTailleDePlateau(); i++) {
            for (int j = 0; j < StartPlate.getTailleDePlateau(); j++) {
                // calculer le poids de case et on fait mise a jour de poids case
                int poidsCase  = CalculerPoidsCase(StartPlate.getPlateau()[i][j]);
                StartPlate.getPlateau()[i][j].setPoids(poidsCase);

                //faire mise a jours des listes de poids pour IA
                switch (poidsCase){
                    case 0 :
                        StartPlate.setNbPoids0(StartPlate.getNbPoids0()+1);
                        break;
                    case 1:
                        StartPlate.setNbPoids1(StartPlate.getNbPoids1()+1);
                        break;
                    case 2:
                        StartPlate.setNbPoids2(StartPlate.getNbPoids2()+1);
                        break;
                    default:
                        StartPlate.setNbPoids3(StartPlate.getNbPoids3()+1);
                        break;
                }
            }
        }
    }

    public void ChangeColorRect(int i, int j,Event event, String color){
        //color :  -fx-base: rgb(0, 246, 40);
        Rectangle tmpRect = (Rectangle) ((Node) event.getTarget()).getScene().lookup("#rect_" + i + "_" + j);
        tmpRect.setFill(javafx.scene.paint.Color.web(color));
    }
}
