package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class Controller {
    String[] unitsString = {"тонны", "килограммы", "граммы"};
    ObservableList<String> options = FXCollections.observableArrayList(unitsString);



    @FXML
    private TextField enterTextField;

    @FXML
    private ChoiceBox<String> unitChoiceBox;

    @FXML
    private Label tonUnitsLabel;

    @FXML
    private Label kiloUnitsLabel;

    @FXML
    private Label grammUnitsLabel;


    @FXML
    private Button btn_go;

    String unuts = "";
    @FXML
    void initialize() {
        createUnitChoiceBox();
        btn_go.setOnAction(event ->{
            unitsCount();
        });

    }

    void createUnitChoiceBox(){
        unitChoiceBox.setValue(unitsString[0]);
        unitChoiceBox.setItems(options);
    }

   public void unitsCount(){
        if(!enterTextField.getText().equals("")) {
            unuts = unitChoiceBox.getValue();

            float temp = 0;
            if (unuts.equals("тонны")) {
                temp = Float.parseFloat(enterTextField.getText());
                tonUnitsLabel.setText("" + temp);
                ;
                kiloUnitsLabel.setText("" + (temp * 1000));
                grammUnitsLabel.setText("" + (temp * 1000 * 1000));
            } else if (unuts.equals("килограммы")) {
                temp = Float.parseFloat(enterTextField.getText());
                tonUnitsLabel.setText("" + (temp / 1000));
                ;
                kiloUnitsLabel.setText("" + (temp));
                grammUnitsLabel.setText("" + (temp * 1000));

            } else {
                temp = Float.parseFloat(enterTextField.getText());
                tonUnitsLabel.setText("" + temp / 1000000);
                ;
                kiloUnitsLabel.setText("" + (temp / 1000));
                grammUnitsLabel.setText("" + (temp));
            }
        }else {
            enterTextField.setText("0");
        }

   }
}
