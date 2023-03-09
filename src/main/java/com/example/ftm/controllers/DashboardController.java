package com.example.ftm.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private LineChart<Integer, Integer> scoreLeadsGraph;

    @FXML
    private LineChart<Integer, Double> possessionGraph;

    @FXML
    private LineChart<Integer, Double> goalAccuracyGraph;

    @FXML
    private Label gameLabel1;

    @FXML
    private Label gameLabel2;

    @FXML
    private Label gameLabel3;

    @FXML
    private Label gameLabel4;

    @FXML
    private Label gameLabel5;

    @FXML
    private Label gameLabel6;

    @FXML
    private Label gameLabel7;

    @FXML
    private Label gameLabel8;

    @FXML
    private Label gameLabel9;

    @FXML
    private Label gameLabel10;

    @FXML
    private AnchorPane panel1, panel2;

    @FXML
    ImageView menu;

    @FXML
    private ChoiceBox<Integer> lastGamesChoice;

    private final Integer[] choices={10, 20, 30};

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

    public void interfaceInit(){
        //initialize choice box values with the options 10, 20, 30
        lastGamesChoice.getItems().addAll(choices);

        //last 10 games text fields init
        gameLabel1.setText("");
        gameLabel2.setText("");
        gameLabel3.setText("");
        gameLabel4.setText("");
        gameLabel5.setText("");
        gameLabel6.setText("");
        gameLabel7.setText("");
        gameLabel8.setText("");
        gameLabel9.setText("");
        gameLabel10.setText("");

        //init graphs
        scoreLeadsGraph.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        possessionGraph.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        goalAccuracyGraph.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        interfaceInit();
        menuHandler();
    }
}
