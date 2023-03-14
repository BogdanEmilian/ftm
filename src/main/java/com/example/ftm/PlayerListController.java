package com.example.ftm;

import com.example.ftm.database.PlayerActions;
import com.example.ftm.entity.Player;
import com.example.ftm.enumeration.Position;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

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

    @FXML
    private TableView<Player> playerTable;

    @FXML
    private JFXButton removeButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<Player, Integer> playerAge;

    @FXML
    private TableColumn<Player, Integer> playerHeight;

    @FXML
    private TableColumn<Player, String> playerName;

    @FXML
    private TableColumn<Player, Position> playerPosition;

    @FXML
    private TableColumn<Player, Double> playerSalary;

    @FXML
    private TableColumn<Player, Double> playerValue;

    @FXML
    private TableColumn<Player, Integer> playerWeight;


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
    void addNewPlayer(ActionEvent event) {
        try {
            //Load the adding scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/addPlayer.fxml"));
            Parent root = (Parent) loader.load();

            //set the root on the new scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //display new stage
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void editSelectedPlayer(ActionEvent event) {
        Player player = playerTable.getSelectionModel().getSelectedItem();

        try {
            //Load the edit scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/editPlayer.fxml"));
            Parent root = (Parent) loader.load();

            //Load the edit window with currently selected data for the object
            EditPlayerController editPlayerController = loader.getController();
            editPlayerController.initData(player);

            //set the root on the new scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            //display new stage
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void removeSelectedPlayer(ActionEvent event) throws SQLException {
        try{
            Player player = playerTable.getSelectionModel().getSelectedItem();
            PlayerActions.deletePlayer(player.getPlayerName(), player.getPlayerPosition());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //On Enter, search for given keyword in the text field
    @FXML
    void searchPlayer(ActionEvent event) throws SQLException {
        String keyword = searchTextField.getText();

        ObservableList<Player> resultArray = FXCollections.observableArrayList(PlayerActions.getAllMatchingInfo(keyword));

        playerTable.setItems(resultArray);
    }

    public void tableInit() throws SQLException {
        ObservableList<Player> resultArray = FXCollections.observableArrayList();

        //Automatically calls the getters o the specific attributes given as strings
        playerName.setCellValueFactory(new PropertyValueFactory<Player, String>("playerName"));
        playerAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerAge"));
        playerPosition.setCellValueFactory(new PropertyValueFactory<Player, Position>("playerPosition"));
        playerHeight.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerHeight"));
        playerWeight.setCellValueFactory(new PropertyValueFactory<Player, Integer>("playerWeight"));
        playerValue.setCellValueFactory(new PropertyValueFactory<Player, Double>("playerValue"));
        playerSalary.setCellValueFactory(new PropertyValueFactory<Player, Double>("playerSalary"));

        resultArray = PlayerActions.getAll();

        playerTable.setItems(resultArray);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            tableInit();

            MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
            menuHandler.menuInteractionHandler();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
