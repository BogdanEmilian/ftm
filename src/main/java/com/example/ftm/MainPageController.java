package com.example.ftm;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private JFXButton dashboardTab;

    @FXML
    private JFXButton playersTab;

    @FXML
    private JFXButton performanceTab;

    @FXML
    private JFXButton historyTab;

    @FXML
    private JFXButton exportTab;

    @FXML
    private ImageView menu;

    @FXML
    private AnchorPane panel1, panel2;

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
    public void switchToPlayers(ActionEvent event) throws IOException{

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/playerList.fxml"));

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
    public void switchToExport(ActionEvent event) throws IOException{

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/pdfexport.fxml"));

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
    public void initialize(URL location, ResourceBundle resources){
        MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
        menuHandler.menuInteractionHandler();
    }
}
