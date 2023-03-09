package com.example.ftm.controllers;

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

public class EditPlayerController implements Initializable {

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
    private ImageView editIcon;

    @FXML
    private TextField valueTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private Label status;

    @FXML
    private Label editPlayerName;

    public void initWindow(){
        positionChoiceBox.getItems().addAll(Arrays.asList(Position.values()));
        editPlayerName.setText("Edit player " + nameTextField.getText());

        //TODO: Add JPA entity data
    }

    public void handleSubmit(){

        //Ensure nothing
        editIcon.setOnMouseClicked(event ->{
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
                //TODO: edit DB entry
                status.setText("The player details have been edited!");
                status.setTextFill(Color.color(0, 1, 0));
            }
        });
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
