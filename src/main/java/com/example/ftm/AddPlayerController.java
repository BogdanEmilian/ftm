package com.example.ftm;

import com.example.ftm.database.PlayerActions;
import com.example.ftm.entity.Player;
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
        Player player = new Player();

        player.setPlayerName(nameTextField.getText());
        player.setPlayerAge(Integer.parseInt(ageTextField.getText()));
        player.setPlayerPosition(positionChoiceBox.getValue());
        player.setPlayerHeight(Integer.parseInt(heightTextField.getText()));
        player.setPlayerWeight(Integer.parseInt(weightTextField.getText()));
        player.setPlayerValue(Double.parseDouble(valueTextField.getText()));
        player.setPlayerSalary(Double.parseDouble(salaryTextField.getText()));

        //dummy data for performance
        player.setPlayerGoals(0);
        player.setPlayerFreeKicksShot(0);
        player.setPlayerFreeKicksScored(0);
        player.setPlayerInjured(false);
        player.setPlayerYCards(0);
        player.setPlayerRCards(0);
        player.setPlayerPassAccuracy(0.0);
        player.setPlayerGoalAccuracy(0.0);
        player.setPlayerFouls(0);

        handleSubmit(player);

        status.setText("New player has been added successfully!");
        status.setTextFill(Color.color(0, 1, 0));
    }

    public void handleSubmit(Player player){

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
                PlayerActions.insertPlayer(player);

                //Prompts the user with a confirmation
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
            submitIcon.setOnMouseClicked(event -> {
                addDataFromFields();
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
