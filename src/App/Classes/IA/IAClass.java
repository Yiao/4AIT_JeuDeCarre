package App.Classes.IA;

import App.Classes.Case;
import App.Classes.Plateau;
import App.Classes.Traits;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;


/**
 * Created by User on 25/05/2017.
 */
public  class IAClass {
    public   void playEasyMode(Plateau StartPlate,Event event) {
        for (int i = 0; i < StartPlate.getTailleDePlateau(); i++) {
            for (int j = 0; j < StartPlate.getTailleDePlateau(); j++) {

                if (StartPlate.getPlateau()[i][j].getPoids() == 3) {

                    //C'est le top bouton qu'on a besoin de cliquer
                    if (!StartPlate.getPlateau()[i][j].getTraits().isHaut()) {

                        if (i == 0) {
                            //    Button
                            //B            B
                            //o     C      o
                            //u     A      u
                            //t     S      t
                            //o     E      o
                            //n            n
                            //    Button
                            ((Node) event.getTarget()).getScene().lookup("#bt_top_" + i + "_" + j).setStyle("-fx-base: rgb(0, 246, 40);");
                            StartPlate.getPlateau()[i][j].getTraits().setHaut(true);
                            StartPlate.getPlateau()[i][j].setColor("#2c3e50");
                        } else if (i != 0) {
                            //B            B
                            //o     C      o
                            //u     A      u
                            //t     S      t
                            //o     E      o
                            //n            n
                            //    Button
                            ((Node) event.getTarget()).getScene().getWindow().getScene().lookup("#bt_bot_" + (i - 1) + "_" + j).setStyle("-fx-base: rgb(0, 246, 40);");
                            StartPlate.getPlateau()[i - 1][j].getTraits().setBas(true);
                            StartPlate.getPlateau()[i - 1][j].setColor("#2c3e50");
                        }
                        //check  top  0
                    } else if (!StartPlate.getPlateau()[i][j].getTraits().isBas()) {
                        //check  bot  0


                    } else if (!StartPlate.getPlateau()[i][j].getTraits().isGauche()) {
                        //check left  0

                    } else {
                        //check right 0

                    }

                }
            }
        }
    }}

    
        /*
        ((Control) event.getSource()).setStyle("-fx-base: rgb(0, 246, 40);");
       // String [] positionTableau = ((Control) event.getSource()).getParent().getId().split("_");
        int x = Integer.parseInt(easyPlay(tableState)[0]);
        int y = Integer.parseInt(easyPlay(tableState)[1]);
        switch (easyPlay(tableState)[2])
        {
            case "top" :
            System.out.println("top");
                StartPlate.getPlateau()[x][y].getTraits().setHaut(true);
                StartPlate.getPlateau()[x][y].setPoids(CalculerPoids(StartPlate.getPlateau()[x][y]));

                if (StartPlate.getPlateau()[x][y].getPoids()==4){
                    StartPlate.getPlateau()[x][y].setColor("00F628");
                }

            break;
            case "bot":
            break;
            case "right":
                break;
            case "left":
                break;

        }


    }

    protected  String[] easyPlay(String[][]tableState  )
    {
        String [] buttonTypePlayed =null;
        for (int i =0 ;i< tableState.length;i++)
        {
            for (int j =0 ; j<tableState.length;j++)
            {
                System.out.print(tableState[i][j] + "  ");
                if (tableState[i][j].equals("0111"))
            {
                tableState[i][j]="1111";
                buttonTypePlayed[0]=String.valueOf(i);
                buttonTypePlayed[1]= String.valueOf(j);
                break;
            }
                else if (tableState[i][j].equals("0000") )
                {
                    tableState[i][j]="1000";
                    buttonTypePlayed[0]=String.valueOf(i);
                    buttonTypePlayed[1]= String.valueOf(j);
                    break;
                }
            }
        }
        buttonTypePlayed[2] ="top";

        return buttonTypePlayed;
    }

    public   void playMediumMode(){}
    public    void playHardMode(){}


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
        */

