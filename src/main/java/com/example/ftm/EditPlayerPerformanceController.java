package com.example.ftm;

import com.example.ftm.database.PlayerActions;
import com.example.ftm.entity.Player;
import com.example.ftm.enumeration.Position;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class EditPlayerPerformanceController implements Initializable {
    Player player = new Player();

    @FXML
    private ImageView editIcon;

    @FXML
    private TextField foulsField;

    @FXML
    private TextField freeKicksScoredField;

    @FXML
    private TextField freeKicksShotField;

    @FXML
    private TextField goalAccuracyField;

    @FXML
    private TextField goalsField;

    @FXML
    private TextField passingAccuracyField;

    @FXML
    private CheckBox playerInjuredCheckbox;

    @FXML
    private TextField rcardsField;

    @FXML
    private TextField ycardsField;

    @FXML
    private Label status;

    public void initData(Player player1){
        player = player1;

        //Fill in with data from DB
        freeKicksScoredField.setText(player.getPlayerFreeKicksScored().toString());
        freeKicksShotField.setText(player.getPlayerFreeKicksShot().toString());
        playerInjuredCheckbox.setIndeterminate(player.getPlayerInjured());
        ycardsField.setText(player.getPlayerYCards().toString());
        rcardsField.setText(player.getPlayerRCards().toString());
        passingAccuracyField.setText(player.getPlayerPassAccuracy().toString());
        goalAccuracyField.setText(player.getPlayerGoalAccuracy().toString());
        goalsField.setText(player.getPlayerGoals().toString());
        foulsField.setText(player.getPlayerFouls().toString());
    }

    public void handleSubmit(){

        //Ensure no field is empty
        editIcon.setOnMouseClicked(event -> {
            if( freeKicksScoredField.getText().isEmpty() ||
                    freeKicksShotField.getText().isEmpty() ||
                    ycardsField.getText().isEmpty() ||
                    rcardsField.getText().isEmpty() ||
                    passingAccuracyField.getText().isEmpty() ||
                    goalAccuracyField.getText().isEmpty() ||
                    goalsField.getText().isEmpty() ||
                    foulsField.getText().isEmpty()
            ) {

                //Prompts the user with a warning
                status.setText("Please fill in all the fields!");
                status.setTextFill(Color.color(1, 0, 0));
            } else {

                //Fetch new data from text fields
                player.setPlayerFreeKicksScored(Integer.parseInt(freeKicksScoredField.getText()));
                player.setPlayerFreeKicksShot(Integer.parseInt(freeKicksShotField.getText()));
                player.setPlayerYCards(Integer.parseInt(ycardsField.getText()));
                player.setPlayerRCards(Integer.parseInt(rcardsField.getText()));
                player.setPlayerPassAccuracy(Double.parseDouble(passingAccuracyField.getText()));
                player.setPlayerGoalAccuracy(Double.parseDouble(goalAccuracyField.getText()));
                player.setPlayerGoals(Integer.parseInt(goalsField.getText()));
                player.setPlayerFouls(Integer.parseInt(foulsField.getText()));

                //Prompts the user with a confirmation of modifications
                PlayerActions.editPlayerPerformance(player, player.getPlayerName());
                status.setText("The player details have been edited!");
                status.setTextFill(Color.color(0, 1, 0));
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            handleSubmit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
