package com.example.ftm;

import com.example.ftm.enumeration.Position;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class AddPlayerController implements Initializable {

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private ChoiceBox<Position> positionChoiceBox;

    @FXML
    private TextField salaryTextField;

    @FXML
    private ImageView submitIcon;

    @FXML
    private TextField valueTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private Label status;

    public void addDataFromFields(){

    }

    public void handleSubmit(){

        //Verify each field has been filled in
        submitIcon.setOnMouseClicked(event ->{
            if( nameTextField.getText().isEmpty() ||
                ageTextField.getText().isEmpty() ||
                positionChoiceBox.getSelectionModel().isEmpty() ||
                heightTextField.getText().isEmpty() ||
                weightTextField.getText().isEmpty() ||
                valueTextField.getText().isEmpty() ||
                salaryTextField.getText().isEmpty()
            ) {
                //Prompts the user with a warning
                status.setText("Please fill in all the fields!");
                status.setTextFill(Color.color(1, 0, 0));
            } else {
                //Prompts the user with a confirmation
                //TODO: add DB new entry
                status.setText("New player has been added successfully!");
                status.setTextFill(Color.color(0, 1, 0));
            }
        });
    }

    public void initWindow(){
        positionChoiceBox.getItems().addAll(Arrays.asList(Position.values()));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            initWindow();
            handleSubmit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
