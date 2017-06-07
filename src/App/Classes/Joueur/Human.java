package App.Classes.Joueur;

import App.Classes.PlateauBase.Plateau;
import javafx.event.Event;

/**
 * Created by sya on 6/1/2017.
 */
public class Human extends Joueurs {

    public Human(String nom, String color,Boolean tourDeJouer){
        this.color = color;
        this.nom  = nom;
        this.tourDeJouer = tourDeJouer;
        this.isIA = false;
    }

    @Override
    public void Jouer(Plateau startPlate, Event event, Joueurs joueur1, Joueurs joueur2) {
        if (!QuiJoue.isJoueur1()){
            joueur2.Jouer(startPlate,event,joueur1,joueur2);
        }
    }
}
