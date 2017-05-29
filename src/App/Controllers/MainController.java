package App.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{
    @FXML
    private Pane idRootPane;
    @FXML
    private Button idIavsIa;
    @FXML
    private Button idPlayerVsIa;
    @FXML
    private ChoiceBox idSize;
    @FXML
    private ChoiceBox idLevel;
    @FXML
    private ColorPicker idColor;


@FXML
    public void buttonActions(ActionEvent actionEvent)  throws IOException{

        if (actionEvent.getSource()== idPlayerVsIa)
        {
            System.out.println("player vs ia");
            try {
                AnchorPane gameAp = FXMLLoader.load(getClass().getResource("/App/Scenes/Game.fxml"));
                idRootPane.getChildren().setAll(gameAp);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }


        }
        else
        {
            System.out.print("IA vs IA");
            try {
                AnchorPane gameAp = FXMLLoader.load(getClass().getResource("/App/Scenes/Game.fxml"));
                idRootPane.getChildren().setAll(gameAp);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //default color
        idColor.setValue(Color.BLUE);
        //default size plate
        idSize.setItems(FXCollections.observableArrayList(
                        3, 4, 5)
        );
        idSize.setValue(4);
        //default level
        idLevel.setItems(FXCollections.observableArrayList(
                        "facile","medium","BLIBLIBLI")
        );
        idLevel.setValue("facile");

    }
}
