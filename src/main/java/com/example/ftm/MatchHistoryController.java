package com.example.ftm;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MatchHistoryController implements Initializable {

    @FXML
    private JFXButton dashboardTab;

    @FXML
    private JFXButton playersTab;

    @FXML
    private JFXButton performanceTab;

    @FXML
    private JFXButton exportTab;

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
    public void initialize(URL location, ResourceBundle resources){

        MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
        menuHandler.menuInteractionHandler();
    }
}
