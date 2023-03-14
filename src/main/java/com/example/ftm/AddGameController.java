package com.example.ftm;

import com.example.ftm.database.GameActions;
import com.example.ftm.entity.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class AddGameController implements Initializable {
    @FXML
    private Label status;

    @FXML
    private TextField corners;

    @FXML
    private TextField date;

    @FXML
    private TextField duration;

    @FXML
    private TextField freeKicks;

    @FXML
    private TextField goalsReceived;

    @FXML
    private TextField goalsScored;

    @FXML
    private TextField misses;

    @FXML
    private TextField opposingTeamName;

    @FXML
    private TextField penalties;

    @FXML
    private TextField possession;

    @FXML
    private ImageView submitIcon;

    public void handleSubmit() {

        //Verify each field has been filled in
        if (date.getText().isEmpty() ||
                opposingTeamName.getText().isEmpty() ||
                goalsScored.getText().isEmpty() ||
                goalsReceived.getText().isEmpty() ||
                possession.getText().isEmpty() ||
                corners.getText().isEmpty() ||
                freeKicks.getText().isEmpty() ||
                penalties.getText().isEmpty() ||
                misses.getText().isEmpty() ||
                duration.getText().isEmpty()
        ) {
            //Prompts the user with a warning
            status.setText("Please fill in all the fields!");
            status.setTextFill(Color.color(1, 0, 0));
        } else {
            Game game = new Game();

            //Create object in-memory to pass to the insert query
            game.setGameDate(date.getText());
            game.setOpposingTeamName(opposingTeamName.getText());
            game.setGoalsScored(Integer.parseInt(goalsScored.getText()));
            game.setGoalsReceived(Integer.parseInt(goalsReceived.getText()));
            game.setPossession(Double.parseDouble(possession.getText()));
            game.setCorners(Integer.parseInt(corners.getText()));
            game.setFreeKicks(Integer.parseInt(freeKicks.getText()));
            game.setPenalties(Integer.parseInt(penalties.getText()));
            game.setMisses(Integer.parseInt(misses.getText()));
            game.setGameTime(Integer.parseInt(duration.getText()));

            GameActions.insertGame(game);

            //Prompts the user with a confirmation
            status.setText("New player has been added successfully!");
            status.setTextFill(Color.color(0, 1, 0));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {

            //Wait for the submit icon to be clicked
            submitIcon.setOnMouseClicked(event -> {
                handleSubmit();
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
