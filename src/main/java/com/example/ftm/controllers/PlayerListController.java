package com.example.ftm.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerListController implements Initializable {

    @FXML
    private JFXButton addButton;

    @FXML
    private JFXButton editButton;

    @FXML
    private ImageView menu;

    @FXML
    private AnchorPane panel1, panel2;

    //TODO: refactor after JPA implementation
    @FXML
    private TableView<?> playerTable;

    @FXML
    private JFXButton removeButton;

    @FXML
    private TextField searchTextField;

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
    public void initialize(URL location, ResourceBundle resources) {

        try{
            menuHandler();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
