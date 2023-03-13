package com.example.ftm;

import com.example.ftm.database.PlayerActions;
import com.example.ftm.entity.Player;
import com.example.ftm.enumeration.Position;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PlayerPerformanceController implements Initializable {

    @FXML
    private JFXButton dashboardTab;

    @FXML
    private JFXButton playersTab;

    @FXML
    private JFXButton historyTab;

    @FXML
    private JFXButton exportTab;

    @FXML
    private ImageView menu;

    @FXML
    private AnchorPane panel1;

    @FXML
    private AnchorPane panel2;

    @FXML
    private TableView<Player> playerTable;

    @FXML
    private TextField searchTextField;

    @FXML
    void searchResult(ActionEvent event) throws SQLException {
        searchTextField.getText();

        tableInit();
    }

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

    @FXML
    private TableColumn<Player, Integer> playerFouls;

    @FXML
    private TableColumn<Player, Integer> playerFreeKicksScored;

    @FXML
    private TableColumn<Player, Integer> playerFreeKicksShot;

    @FXML
    private TableColumn<Player, Double> playerGoalAccuracy;

    @FXML
    private TableColumn<Player, Integer> playerGoals;

    @FXML
    private TableColumn<Player, Boolean> playerInjured;

    @FXML
    private TableColumn<Player, String> playerName;

    @FXML
    private TableColumn<Player, Double> playerPassAccuracy;

    @FXML
    private TableColumn<Player, Integer> playerRCards;

    @FXML
    private TableColumn<Player, Integer> playerYCards;

    public void tableInit() throws SQLException {
        ObservableList<Player> resultArray = FXCollections.observableArrayList();

        //Automatically calls the getters o the specific attributes given as strings
        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("playerName"));
        playerFreeKicksScored.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerFreeKicksScored"));
        playerFreeKicksShot.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerFreeKicksShot"));
        playerInjured.setCellValueFactory(new PropertyValueFactory<Player, Boolean>("playerInjured"));
        playerYCards.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerYCards"));
        playerRCards.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerRCards"));
        playerPassAccuracy.setCellValueFactory(new PropertyValueFactory<Player, Double>("playerPassAccuracy"));
        playerGoalAccuracy.setCellValueFactory(new PropertyValueFactory<Player, Double>("playerGoalAccuracy"));
        playerGoals.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerGoals"));
        playerFouls.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerFouls"));

        resultArray = PlayerActions.getAll();

        playerTable.setItems(resultArray);
    }

    @FXML
    public void editSelectedPlayer(ActionEvent actionEvent) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            tableInit();

            MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
            menuHandler.menuInteractionHandler();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
