package com.example.ftm.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MatchHistoryController implements Initializable {

    @FXML
    private Label date1;

    @FXML
    private Label date2;

    @FXML
    private Label date3;

    @FXML
    private Label date4;

    @FXML
    private Label date5;

    @FXML
    private Label date6;

    @FXML
    private Label date7;

    @FXML
    private Label date8;

    @FXML
    private Label date9;

    @FXML
    private Label enemyTeam1;

    @FXML
    private Label enemyTeam2;

    @FXML
    private Label enemyTeam3;

    @FXML
    private Label enemyTeam4;

    @FXML
    private Label enemyTeam5;

    @FXML
    private Label enemyTeam6;

    @FXML
    private Label enemyTeam7;

    @FXML
    private Label enemyTeam8;

    @FXML
    private Label enemyTeam9;

    @FXML
    private Label freeKicks1;

    @FXML
    private Label freeKicks2;

    @FXML
    private Label freeKicks3;

    @FXML
    private Label freeKicks4;

    @FXML
    private Label freeKicks5;

    @FXML
    private Label freeKicks6;

    @FXML
    private Label freeKicks7;

    @FXML
    private Label freeKicks8;

    @FXML
    private Label freeKicks9;

    @FXML
    private ImageView menu;

    @FXML
    private Label misses1;

    @FXML
    private Label misses2;

    @FXML
    private Label misses3;

    @FXML
    private Label misses4;

    @FXML
    private Label misses5;

    @FXML
    private Label misses6;

    @FXML
    private Label misses7;

    @FXML
    private Label misses8;

    @FXML
    private Label misses9;

    @FXML
    private AnchorPane panel1;

    @FXML
    private AnchorPane panel2;

    @FXML
    private Label penalties1;

    @FXML
    private Label penalties2;

    @FXML
    private Label penalties3;

    @FXML
    private Label penalties4;

    @FXML
    private Label penalties5;

    @FXML
    private Label penalties6;

    @FXML
    private Label penalties7;

    @FXML
    private Label penalties8;

    @FXML
    private Label penalties9;

    @FXML
    private Label possession1;

    @FXML
    private Label possession2;

    @FXML
    private Label possession3;

    @FXML
    private Label possession4;

    @FXML
    private Label possession5;

    @FXML
    private Label possession6;

    @FXML
    private Label possession7;

    @FXML
    private Label possession8;

    @FXML
    private Label possession9;

    @FXML
    private PieChart possessionPieChart;

    @FXML
    private Label score1;

    @FXML
    private Label score2;

    @FXML
    private Label score3;

    @FXML
    private Label score4;

    @FXML
    private Label score5;

    @FXML
    private Label score6;

    @FXML
    private Label score7;

    @FXML
    private Label score8;

    @FXML
    private Label score9;

    @FXML
    private PieChart scorePieChart;

    @FXML
    private Label time1;

    @FXML
    private Label time2;

    @FXML
    private Label time3;

    @FXML
    private Label time4;

    @FXML
    private Label time5;

    @FXML
    private Label time6;

    @FXML
    private Label time7;

    @FXML
    private Label time8;

    @FXML
    private Label time9;

    public void menuHandler(){
        panel1.setVisible(false);

        double fadeDuration = 0.25;

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(fadeDuration), panel1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(fadeDuration), panel2);
        translateTransition.setByX(-700);
        translateTransition.play();

        menu.setOnMouseClicked(mouseEvent -> {
            panel1.setVisible(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(fadeDuration), panel1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.45);
            fadeTransition1.play();

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(fadeDuration), panel2);
            translateTransition1.setByX(+700);
            translateTransition1.play();
        });

        panel1.setOnMouseClicked(event -> {
            panel1.setVisible(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(fadeDuration), panel1);
            fadeTransition1.setFromValue(0.45);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                panel1.setVisible(false);
            });

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(fadeDuration), panel2);
            translateTransition1.setByX(-700);
            translateTransition1.play();
        });
    }
    @Override
    public void initialize(URL location, ResourceBundle resources){

        menuHandler();
    }
}
