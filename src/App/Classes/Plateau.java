package App.Classes;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * Created by sya on 5/22/2017.
 */
public class Plateau {

    //recupérer la taille du plateau from MAIN
    private int tailleDePlateau = 5;


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
