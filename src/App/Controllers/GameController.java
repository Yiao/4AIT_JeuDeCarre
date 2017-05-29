package App.Controllers;

import App.Classes.Case;
import App.Classes.IA.IAClass;
import App.Classes.Plateau;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Window;


import java.io.IOException;
import java.net.URL;
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
    Plateau StartPlate = new Plateau();

    String colorPlayer ="#ffff4d";


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StartPlate.initPlateau();
        GridPane gridpane = new GridPane();

        gridpane.setAlignment(Pos.CENTER);
       // gridpane.setMinHeight(500);
       // gridpane.setMinSize(553,355);
        for (int i = 0; i < plateSize; i++) {

            for (int j = 0; j < plateSize; j++) {


                if (i==0 && j==0){
                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i+"_"+j);
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
                    tmpTopButton.setId("bt_top_"+i+"_"+j);
                    tmpTopButton.setText("");
                    tmpTopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new TopButtonEventHandler());
                    tmpTopButton.setMinSize(75, 25);
                    sousGrid.add(tmpTopButton,1,0);

                    //CASE
                    Rectangle tmpRectangle = new Rectangle();
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);

                    tmpRectangle.setFill(Color.web(StartPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle,1,1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_"+i+"_"+j);
                    tmpBotButton.setText("");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75,25);
                    sousGrid.add(tmpBotButton,1,2);

                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_"+i+"_"+j);
                    tmpRightButton.setText("");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25,75);
                    sousGrid.add(tmpRightButton,2,1);

                    //LEFT Button
                    Button tmpLeftButton = new Button();
                    tmpLeftButton.setId("bt_left_"+i+"_"+j);
                    tmpLeftButton.setText("");
                    tmpLeftButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new LeftButtonEventHandler());
                    tmpLeftButton.setMinSize(25,75);
                    sousGrid.add(tmpLeftButton,0,1);

                    gridpane.add(sousGrid,j,i);

                } else if (i==0 && j!=0) {
                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i+"_"+j);
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
                    tmpTopButton.setId("bt_top_"+i+"_"+j);
                    tmpTopButton.setText("");
                    tmpTopButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new TopButtonEventHandler());
                    tmpTopButton.setMinSize(75,25);
                    sousGrid.add(tmpTopButton,1,0);

                    //CASE
                    Rectangle tmpRectangle = new Rectangle();
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(StartPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle,1,1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_"+i+"_"+j);
                    tmpBotButton.setText("");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75,25);
                    sousGrid.add(tmpBotButton,1,2);


                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_"+i+"_"+j);
                    tmpRightButton.setText("");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25,75);
                    sousGrid.add(tmpRightButton,2,1);

                    gridpane.add(sousGrid,j,i);
                }else if (i!=0 && j==0){

                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i+"_"+j);
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
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(StartPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle,1,1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_"+i+"_"+j);
                    tmpBotButton.setText("");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75,25);
                    sousGrid.add(tmpBotButton,1,2);


                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_"+i+"_"+j);
                    tmpRightButton.setText("");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25,75);
                    sousGrid.add(tmpRightButton,2,1);


                    //LEFT Button
                    Button tmpLeftButton = new Button();
                    tmpLeftButton.setId("bt_left_"+i+"_"+j);
                    tmpLeftButton.setText("");
                    tmpLeftButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new LeftButtonEventHandler());
                    tmpLeftButton.setMinSize(25,75);
                    sousGrid.add(tmpLeftButton,0,1);

                    gridpane.add(sousGrid,j,i);
                }else if (i!=0 && j!=0){
                    GridPane sousGrid = new GridPane();
                    sousGrid.setId(i+"_"+j);
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
                    tmpRectangle.setHeight(75);
                    tmpRectangle.setWidth(75);
                    tmpRectangle.setFill(Color.web(StartPlate.getPlateau()[i][j].getColor()));
                    sousGrid.add(tmpRectangle,1,1);

                    //BOT Button
                    Button tmpBotButton = new Button();
                    tmpBotButton.setId("bt_bot_"+i+"_"+j);
                    tmpBotButton.setText("");
                    tmpBotButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new BotButtonEventHandler());
                    tmpBotButton.setMinSize(75,25);
                    sousGrid.add(tmpBotButton,1,2);

                    //RIGHT Button
                    Button tmpRightButton = new Button();
                    tmpRightButton.setId("bt_right_"+i+"_"+j);
                    tmpRightButton.setText("");
                    tmpRightButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new RightButtonEventHandler());
                    tmpRightButton.setMinSize(25,75);
                    sousGrid.add(tmpRightButton,2,1);

                    gridpane.add(sousGrid,j,i);
                }
            }

        }
        idGrid.getChildren().setAll(gridpane);


    }




    // 4 types de Button et leurs actions
    private class TopButtonEventHandler implements EventHandler<Event> {

        @Override
        public void handle(Event event) {
            //On change le coleur de Button

                ((Control) event.getSource()).setStyle("-fx-base: rgba(0, 0, 0, 1);");

                //Mise ax jour les valeurs de tableau
                //tableau position Tableau enregister le position de tableau, premier element est la position x , deuxieme element est la position y
                String[] positionPlayed = ((Control) event.getSource()).getParent().getId().split("_");

                int x = Integer.parseInt(positionPlayed[0]);
                int y = Integer.parseInt(positionPlayed[1]);
                System.out.println("position x " + x + "position y" + y);
                StartPlate.getPlateau()[x][y].getTraits().setHaut(true);
                StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));

                if (StartPlate.getPlateau()[x][y].getPoids() == 4) {
                    StartPlate.getPlateau()[x][y].setColor(colorPlayer);
                }

                RefreshPane(((Node) event.getTarget()).getScene().getWindow());
            //IA HERE
            IAClass.playEasyMode(StartPlate, event);
            RefreshPane(((Node) event.getTarget()).getScene().getWindow());
            etatPlateau();
            }
    }



    private class BotButtonEventHandler implements  EventHandler<Event>{

        @Override
        public void handle(Event event) {
            //On change le coleur de Button
            ((Control) event.getSource()).setStyle("-fx-base: rgba(0, 0, 0, 1);");

            //Mise � jour les valeurs de tableau
            //tableau position Tableau enregister le position de tableau, premier �l�ment est la position x , deuxi�me �l�ment est la position y
            String [] positionTableau = ((Control) event.getSource()).getParent().getId().split("_");
            int x = Integer.parseInt(positionTableau[0]);
            int y = Integer.parseInt(positionTableau[1]);
            System.out.println("position x " + x + "position y" + y);
            if (x != plateSize - 1){
                StartPlate.getPlateau()[x][y].getTraits().setBas(true);
                StartPlate.getPlateau()[x+1][y].getTraits().setHaut(true);
                StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));
                StartPlate.getPlateau()[x+1][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x+1][y]));

                if (StartPlate.getPlateau()[x][y].getPoids()==4){
                    StartPlate.getPlateau()[x][y].setColor(colorPlayer);
                }
                if (StartPlate.getPlateau()[x+1][y].getPoids()==4){
                    StartPlate.getPlateau()[x+1][y].setColor(colorPlayer);
                }

            }else{
                StartPlate.getPlateau()[x][y].getTraits().setBas(true);
                StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));

                if (StartPlate.getPlateau()[x][y].getPoids()==4){
                    StartPlate.getPlateau()[x][y].setColor(colorPlayer);
                }
            }

            IAClass.playEasyMode(StartPlate, event);
            RefreshPane(((Node) event.getTarget()).getScene().getWindow());
            etatPlateau();

        }
    }
    private class LeftButtonEventHandler implements  EventHandler<Event>{

        @Override
        public void handle(Event event) {
            //On change le coleur de Button
            ((Control) event.getSource()).setStyle("-fx-base: rgba(0, 0, 0, 1);");

            //Mise � jour les valeurs de tableau
            //tableau position Tableau enregister le position de tableau, premier �l�ment est la position x , deuxi�me �l�ment est la position y
            String [] positionTableau = ((Control) event.getSource()).getParent().getId().split("_");
            int x = Integer.parseInt(positionTableau[0]);
            int y = Integer.parseInt(positionTableau[1]);
            System.out.println("position x " + x + "position y" + y);
            StartPlate.getPlateau()[x][y].getTraits().setGauche(true);
            StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));
            if (StartPlate.getPlateau()[x][y].getPoids()==4){
                StartPlate.getPlateau()[x][y].setColor(colorPlayer);
            }

            IAClass.playEasyMode(StartPlate, event);
            RefreshPane(((Node) event.getTarget()).getScene().getWindow());
            etatPlateau();
        }
    }
    private class RightButtonEventHandler implements  EventHandler<Event>{

        @Override
        public void handle(Event event) {
            //On change le coleur de Button
            ((Control) event.getSource()).setStyle("-fx-base: rgba(0, 0, 0, 1);");

            //Mise � jour les valeurs de tableau
            //tableau position Tableau enregister le position de tableau, premier �l�ment est la position x , deuxi�me �l�ment est la position y
            String [] positionTableau = ((Control) event.getSource()).getParent().getId().split("_");


            int x = Integer.parseInt(positionTableau[0]);
            int y = Integer.parseInt(positionTableau[1]);
            System.out.println("position x " + x +"position y" + y );
            if (y != plateSize - 1){
                StartPlate.getPlateau()[x][y].getTraits().setDroite(true);
                StartPlate.getPlateau()[x][y+1].getTraits().setGauche(true);
                StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));
                StartPlate.getPlateau()[x][y+1].setPoids(CalculerPoids( StartPlate.getPlateau()[x][y+1]));

                if (StartPlate.getPlateau()[x][y].getPoids()==4){
                    StartPlate.getPlateau()[x][y].setColor(colorPlayer);
                }
                if (StartPlate.getPlateau()[x][y+1].getPoids()==4){
                    StartPlate.getPlateau()[x][y+1].setColor(colorPlayer);
                }
            } else {
                StartPlate.getPlateau()[x][y].getTraits().setDroite(true);
                StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));

                if (StartPlate.getPlateau()[x][y].getPoids()==4){
                    StartPlate.getPlateau()[x][y].setColor(colorPlayer);
                }
            }
            //(Rectangle)(getNodeFromGridPane((GridPane) ((Control) event.getSource()).getParent(),1,1)
            IAClass.playEasyMode(StartPlate, event);
            RefreshPane(((Node) event.getTarget()).getScene().getWindow());
            etatPlateau();
        }
    }
    // tableau [] []   pour afficher les etats de chaque côtés Haut-Bas-Droite-Gauche aprés chaque tours
    private  String [][] etatPlateau(){

        String [][] tableState= new String[plateSize][plateSize];
        System.out.println("");
        for (int i = 0; i < plateSize ; i++) {
            for (int j = 0; j < plateSize ; j++) {
               // System.out.print(TransBool(StartPlate.getPlateau()[i][j].getTraits().isHaut())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isBas())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isGauche())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isDroite()) + "  ");
                //System.out.print(plateau[i][j].getPoids()+" ");
                //System.out.print(plateau[i][j].getColor()+" ");
                tableState[i][j]=TransBool(StartPlate.getPlateau()[i][j].getTraits().isHaut())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isBas())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isGauche())+""+ TransBool(StartPlate.getPlateau()[i][j].getTraits().isDroite());
                System.out.print(tableState[i][j] + "  ");
            }
            System.out.println();

        }
        return tableState;
    }

    private int TransBool(Boolean booleanIn){
        int tmpValeur = 0;
        if (booleanIn){
            tmpValeur = 1;
        }
        return  tmpValeur;
    }

    private int CalculerPoids(Case caseIn){
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

   /* private void animation(GridPane paneIn){
        RotateTransition rt = new RotateTransition(Duration.millis(3000), paneIn);
        rt.setByAngle(180);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        SequentialTransition seqTransition = new SequentialTransition (
                new PauseTransition(Duration.millis(600)), // wait a second
                rt
        );
        seqTransition.play();
    }*/

    private void RefreshPane(Window window) {

        for (int i = 0; i<plateSize ; i++){
            for (int j = 0; j<plateSize ; j++){
                if (StartPlate.getPlateau()[i][j].getColor() != "#FFFFFF"){
                    GridPane sousGride = (GridPane) window.getScene().lookup("#"+i+"_"+j);
                    for (Node obs: sousGride.getChildren()){
                        if (obs instanceof Rectangle){
                            ((Rectangle) obs).setFill(Color.web(StartPlate.getPlateau()[i][j].getColor()));
                        }
                    }
                }
            }
        }
    }

    @FXML
    public void buttonActions()  throws IOException
    {
        Pane mainPane = FXMLLoader.load(getClass().getResource("/App/Scenes/Main.fxml"));
        idRootPane.getChildren().setAll(mainPane);
    }
}
