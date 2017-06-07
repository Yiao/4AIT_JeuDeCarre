package App.Classes.Joueur;

import App.Classes.PlateauBase.Plateau;
import javafx.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sya on 6/1/2017.
 */
public class IA extends Joueurs {

    public IA(String nom, String color,boolean tourDeJouer){
        this.color = color;
        this.nom  = nom;
        this.tourDeJouer =  tourDeJouer;
        this.isIA = true;
    }

    @Override
    public void Jouer(Plateau startPlate, Event event, Joueurs joueur1, Joueurs joueur2) {

        int nombrePoids0 = startPlate.getNbPoids0();
        int nombrePoids1 = startPlate.getNbPoids1();
        int nombrePoids2 = startPlate.getNbPoids2();
        int nombrePoids3 = startPlate.getNbPoids3();

        if (nombrePoids3!= 0){
            //SolutionPoids3(startPlate,event);
        } else if (nombrePoids3 == 0 && nombrePoids0 !=0) {
            //SolutionPoids0(startPlate,event);
        }

        QuiJoue.ChangeJoueur();
        System.out.println("IA fini");
    }

    private void SolutionPoids3 (Plateau startPlate, Event event){
        for (int i = 0; i <startPlate.getTailleDePlateau() ; i++) {
            for (int j = 0; j <startPlate.getTailleDePlateau() ; j++) {
                if (startPlate.getPlateau()[i][j].getPoids() == 3) {
                    if (!startPlate.getPlateau()[i][j].getTraits().isHaut()) {
                        ChangeTopBouton(startPlate,event,i,j);
                    } else if (!startPlate.getPlateau()[i][j].getTraits().isBas()) {
                        ChangeBotBouton(startPlate,event,i,j);
                    } else if (!startPlate.getPlateau()[i][j].getTraits().isDroite()) {
                        ChangeRightBouton(startPlate,event,i,j);
                    } else if (!startPlate.getPlateau()[i][j].getTraits().isGauche()) {
                        ChangeLeftBouton(startPlate,event,i,j);
                    }
                }
            }
        }
    }

    private void SolutionPoids2 (Plateau startPlate, Event event){
        for (int i = 0; i <startPlate.getTailleDePlateau() ; i++) {
            for (int j = 0; j <startPlate.getTailleDePlateau() ; j++) {

            }
        }
    }

    private void SolutionPoids1 (Plateau startPlate, Event event){
        for (int i = 0; i <startPlate.getTailleDePlateau() ; i++) {
            for (int j = 0; j <startPlate.getTailleDePlateau() ; j++) {

            }
        }
    }

    private void SolutionPoids0 (Plateau startPlate, Event event){
        List<int []> listePossible = new ArrayList<int[]>();

        for (int i = 0; i <startPlate.getTailleDePlateau() ; i++) {
            for (int j = 0; j <startPlate.getTailleDePlateau() ; j++) {
                if (startPlate.getPlateau()[i][j].getPoids() == 0) {
                    listePossible.add(new int[]{i, j});
                }
            }
        }
        int positionTab = GetUnRandom(listePossible.size());
        ChangeUnBoutonRandom(startPlate,event,listePossible.get(positionTab)[0],listePossible.get(positionTab)[1]);
    }

    // Si max = 4  resultat = 0 , 1,  2,  3
    private int GetUnRandom(int max){
        Random rn = new Random();
        int tmpResultat = rn.nextInt(max);
        return  tmpResultat;
    }
    private void ChangeUnBoutonRandom(Plateau plateau, Event event,int i,int j){
        int position = GetUnRandom(4);

        switch (position){
            //TOP
            case 0 :
                ChangeTopBouton(plateau,event,i,j);
                break;
            //BOT
            case 1 :
                ChangeBotBouton(plateau,event,i,j);
                break;
            //RIGHT
            case 2 :
                ChangeRightBouton(plateau,event,i,j);
                break;
            //LEFT
            default:
                ChangeLeftBouton(plateau,event,i,j);
                break;
        }
    }

}

