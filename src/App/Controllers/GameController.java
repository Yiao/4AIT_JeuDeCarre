package App.Controllers;

import App.Classes.Joueur.Human;
import App.Classes.Joueur.IA;
import App.Classes.Joueur.Joueurs;
import App.Classes.Joueur.QuiJoue;
import App.Classes.PlateauBase.Plateau;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Created by User on 5/05/2017.
 */
public class GameController implements Initializable {
    int plateSize= 5;

    @FXML
    private Pane idRootPane;
    //init Plate
    @FXML
    private Pane idGrid ;

    @FXML
    private Label Points1;

    @FXML
    private Label Points2;

    Plateau startPlate = new Plateau();

    Joueurs humanJoueur = new Human("Player 1","#2980b9",true);

    Joueurs iaJoueur = new IA("IA facile","#27ae60",false);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startPlate.initPlateau();
        GridPane gridpane = new GridPane();

        gridpane.setAlignment(Pos.CENTER);
       // gridpane.setMinHeight(500);
       // gridpane.setMinSize(553,355);

        for (int i = 0; i < plateSize; i++) {

            for (int j = 0; j < plateSize; j++) {


                if (i == 0 && j == 0) {
                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i + "_" + j);
                    //    Button
                    //B            B
                    //o     C      o
                    //u     A      u
                    //t     S      t
                    //o     E      o
                    //n            n
                    //    Button


                    //TOP Button
                    Button tmpTopButton = new Button();
                    tmpTopButton.setId("bt_top_" + i + "_" + j);
                    tmpTopButton.setStyle("-fx-base: #ecf0f1;");
                    tmpTopButton.setText("T");
                    tmpTopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new TopButtonEventHandler());
                    tmpTopButton.setMinSize(75, 25);
                    sousGrid.add(tmpTopButton, 1, 0);

                    //CASE
                    Rectangle tmpRectangle = new Rectangle();
                    tmpRectangle.setId("rect_"+i+"_"+j);
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(startPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle, 1, 1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_" + i + "_" + j);
                    tmpBotButton.setStyle("-fx-base: #ecf0f1;");
                    tmpBotButton.setText("B");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75, 25);
                    sousGrid.add(tmpBotButton, 1, 2);

                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_" + i + "_" + j);
                    tmpRightButton.setStyle("-fx-base: #ecf0f1;");
                    tmpRightButton.setText("R");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25, 75);
                    sousGrid.add(tmpRightButton, 2, 1);

                    //LEFT Button
                    Button tmpLeftButton = new Button();
                    tmpLeftButton.setId("bt_left_" + i + "_" + j);
                    tmpLeftButton.setStyle("-fx-base: #ecf0f1;");
                    tmpLeftButton.setText("L");
                    tmpLeftButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new LeftButtonEventHandler());
                    tmpLeftButton.setMinSize(25, 75);
                    sousGrid.add(tmpLeftButton, 0, 1);

                    gridpane.add(sousGrid, j, i);

                } else if (i == 0 && j != 0) {
                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i + "_" + j);
                    //    Button
                    //            B
                    //     C      o
                    //     A      u
                    //     S      t
                    //     E      o
                    //            n
                    //    Button

                    //TOP Button
                    Button tmpTopButton = new Button();
                    tmpTopButton.setId("bt_top_" + i + "_" + j);
                    tmpTopButton.setStyle("-fx-base: #ecf0f1;");
                    tmpTopButton.setText("T");
                    tmpTopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new TopButtonEventHandler());
                    tmpTopButton.setMinSize(75, 25);
                    sousGrid.add(tmpTopButton, 1, 0);

                    //CASE
                    Rectangle tmpRectangle = new Rectangle();
                    tmpRectangle.setId("rect_"+i+"_"+j);
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(startPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle, 1, 1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_" + i + "_" + j);
                    tmpBotButton.setStyle("-fx-base: #ecf0f1;");
                    tmpBotButton.setText("B");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75, 25);
                    sousGrid.add(tmpBotButton, 1, 2);


                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_" + i + "_" + j);
                    tmpRightButton.setStyle("-fx-base: #ecf0f1;");
                    tmpRightButton.setText("R");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25, 75);
                    sousGrid.add(tmpRightButton, 2, 1);

                    gridpane.add(sousGrid, j, i);
                } else if (i != 0 && j == 0) {

                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i + "_" + j);
                    //
                    //B            B
                    //o     C      o
                    //u     A      u
                    //t     S      t
                    //o     E      o
                    //n            n
                    //    Button


                    //CASE
                    Rectangle tmpRectangle = new Rectangle();
                    tmpRectangle.setId("rect_"+i+"_"+j);
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(startPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle, 1, 1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_" + i + "_" + j);
                    tmpBotButton.setStyle("-fx-base: #ecf0f1;");
                    tmpBotButton.setText("B");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75, 25);
                    sousGrid.add(tmpBotButton, 1, 2);


                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_" + i + "_" + j);
                    tmpRightButton.setStyle("-fx-base: #ecf0f1;");
                    tmpRightButton.setText("R");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25, 75);
                    sousGrid.add(tmpRightButton, 2, 1);


                    //LEFT Button
                    Button tmpLeftButton = new Button();
                    tmpLeftButton.setId("bt_left_" + i + "_" + j);
                    tmpLeftButton.setStyle("-fx-base: #ecf0f1;");
                    tmpLeftButton.setText("L");
                    tmpLeftButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new LeftButtonEventHandler());
                    tmpLeftButton.setMinSize(25, 75);
                    sousGrid.add(tmpLeftButton, 0, 1);

                    gridpane.add(sousGrid, j, i);
                } else if (i != 0 && j != 0) {
                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i + "_" + j);
                    //
                    //            B
                    //     C      o
                    //     A      u
                    //     S      t
                    //     E      o
                    //            n
                    //    Button


                    //CASE
                    Rectangle tmpRectangle = new Rectangle();
                    tmpRectangle.setId("rect_"+i+"_"+j);
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(startPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle, 1, 1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_" + i + "_" + j);
                    tmpBotButton.setStyle("-fx-base: #ecf0f1;");
                    tmpBotButton.setText("B");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75, 25);
                    sousGrid.add(tmpBotButton, 1, 2);

                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_" + i + "_" + j);
                    tmpRightButton.setStyle("-fx-base: #ecf0f1;");
                    tmpRightButton.setText("R");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25, 75);
                    sousGrid.add(tmpRightButton, 2, 1);

                    gridpane.add(sousGrid, j, i);
                }
            }

        }
        //Ajouter pour center GridPane
        gridpane.layoutXProperty().bind(idGrid.widthProperty().subtract(gridpane.widthProperty()).divide(2));
        idGrid.getChildren().setAll(gridpane);
    }

    // 4 types de Button et leurs actions
    private class TopButtonEventHandler implements EventHandler<Event> {

        @Override
        public void handle(Event event) {
            if (Objects.equals(((Control) event.getSource()).getStyle(), "-fx-base: #ecf0f1;")){
                if (QuiJoue.isJoueur1()){
                    int i,j;
                    int [] position = humanJoueur.PositionElementClick(event);
                    i = position[0];
                    j = position[1];
                    humanJoueur.ChangeTopBouton(startPlate,event,i,j);
                    humanJoueur.Jouer(startPlate,event,humanJoueur,iaJoueur);
                    Points1.setText(String.valueOf(humanJoueur.getPoints()));
                    Points2.setText(String.valueOf(iaJoueur.getPoints()));
                    etatPlateau();
                }
            }
        }
    }
    private class BotButtonEventHandler implements  EventHandler<Event>{

        @Override
        public void handle(Event event) {
            if (Objects.equals(((Control) event.getSource()).getStyle(), "-fx-base: #ecf0f1;")){
                if (QuiJoue.isJoueur1()){
                    int i,j;
                    int [] position = humanJoueur.PositionElementClick(event);
                    i = position[0];
                    j = position[1];
                    humanJoueur.ChangeBotBouton(startPlate,event,i,j);
                    humanJoueur.Jouer(startPlate,event,humanJoueur,iaJoueur);
                    Points1.setText(String.valueOf(humanJoueur.getPoints()));
                    Points2.setText(String.valueOf(iaJoueur.getPoints()));
                    etatPlateau();
                }
            }
        }
    }
    private class LeftButtonEventHandler implements  EventHandler<Event>{

        @Override
        public void handle(Event event) {
            if (Objects.equals(((Control) event.getSource()).getStyle(), "-fx-base: #ecf0f1;")){
                if (QuiJoue.isJoueur1()){
                    int i,j;
                    int [] position = humanJoueur.PositionElementClick(event);
                    i = position[0];
                    j = position[1];
                    humanJoueur.ChangeLeftBouton(startPlate,event,i,j);
                    humanJoueur.Jouer(startPlate,event,humanJoueur,iaJoueur);
                    Points1.setText(String.valueOf(humanJoueur.getPoints()));
                    Points2.setText(String.valueOf(iaJoueur.getPoints()));
                    etatPlateau();
                }
            }
        }
    }
    private class RightButtonEventHandler implements  EventHandler<Event>{

        @Override
        public void handle(Event event) {
            if (Objects.equals(((Control) event.getSource()).getStyle(), "-fx-base: #ecf0f1;")){
                if (QuiJoue.isJoueur1()){
                    int i,j;
                    int [] position = humanJoueur.PositionElementClick(event);
                    i = position[0];
                    j = position[1];
                    humanJoueur.ChangeRightBouton(startPlate,event,i,j);
                    humanJoueur.Jouer(startPlate,event,humanJoueur,iaJoueur);
                    Points1.setText(String.valueOf(humanJoueur.getPoints()));
                    Points2.setText(String.valueOf(iaJoueur.getPoints()));
                    etatPlateau();
                }
            }
        }
    }

    // tableau [] []   pour afficher les etats de chaque côtés Haut-Bas-Droite-Gauche aprés chaque tours
    // TODO supprimer a la fin
    private  void etatPlateau(){

        String [][] tableState= new String[plateSize][plateSize];
        System.out.println("");
        for (int i = 0; i < plateSize ; i++) {
            for (int j = 0; j < plateSize ; j++) {
               // System.out.print(TransBool(StartPlate.getPlateau()[i][j].getTraits().isHaut())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isBas())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isGauche())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isDroite()) + "  ");
                //System.out.print(plateau[i][j].getPoids()+" ");
                //System.out.print(plateau[i][j].getColor()+" ");
                tableState[i][j]=TransBool(startPlate.getPlateau()[i][j].getTraits().isHaut())+""+ TransBool(startPlate.getPlateau()[i][j].getTraits().isBas())+""+ TransBool(startPlate.getPlateau()[i][j].getTraits().isGauche())+""+ TransBool(startPlate.getPlateau()[i][j].getTraits().isDroite());
                System.out.print(tableState[i][j] + "  ");
            }
            System.out.println();

        }
    }
    // TODO supprimer a la fin
    private int TransBool(Boolean booleanIn){
        int tmpValeur = 0;
        if (booleanIn){
            tmpValeur = 1;
        }
        return  tmpValeur;
    }

    @FXML
    public void buttonActions()  throws IOException
    {
        Pane mainPane = FXMLLoader.load(getClass().getResource("/App/Scenes/Main.fxml"));
        idRootPane.getChildren().setAll(mainPane);
    }
}
