package com.example.ftm;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerListController implements Initializable {

    @FXML
    private JFXButton dashboardTab;

    @FXML
    private JFXButton performanceTab;

    @FXML
    private JFXButton historyTab;

    @FXML
    private JFXButton exportTab;

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

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/dashboard.fxml"));

            Parent root = (Parent) loader.load();

            //set the root on the new scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //display new stage
            stage.setScene(scene);
            stage.show();

            //close old stage
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void switchToPerformance(ActionEvent event) throws IOException{

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/playerPerformance.fxml"));

            Parent root = (Parent) loader.load();

            //set the root on the new scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //display new stage
            stage.setScene(scene);
            stage.show();

            //close old stage
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void switchToHistory(ActionEvent event) throws IOException{

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/matchHistory.fxml"));

            Parent root = (Parent) loader.load();

            //set the root on the new scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //display new stage
            stage.setScene(scene);
            stage.show();

            //close old stage
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void switchToExport(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/mainMenu.fxml"));

            Parent root = (Parent) loader.load();

            //set the root on the new scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //display new stage
            stage.setScene(scene);
            stage.show();

            //close old stage
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
            menuHandler.menuInteractionHandler();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
