package com.example.ftm;

import com.example.ftm.database.GameActions;
import com.example.ftm.entity.Game;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private JFXButton playersTab;

    @FXML
    private JFXButton performanceTab;

    @FXML
    private JFXButton historyTab;

    @FXML
    private JFXButton exportTab;

    @FXML
    private LineChart<String, Integer> scoreLeadsGraph;

    @FXML
    private LineChart<String, Double> possessionGraph;

    @FXML
    private LineChart<String, Double> goalAccuracyGraph;

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
    public void switchToHistory(ActionEvent event) throws IOException {

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

    public void scoreGraphHandler() throws SQLException {
        List<Game> gameList = GameActions.getGames(lastGamesChoice.getValue().intValue());

        XYChart.Series<String, Integer> scoreChart = new XYChart.Series<>();
        for (int i = 0; i < gameList.size(); i++) {
            int scoreLead = Math.abs(gameList.get(i).getGoalsScored() - gameList.get(i).getGoalsReceived());
            scoreChart.getData().add(new XYChart.Data<>(String.valueOf(i + 1), scoreLead));
        }

        scoreLeadsGraph.getData().add(scoreChart);
    }

    public void possessionGraphHandler() throws SQLException {
        List<Game> gameList = GameActions.getGames(lastGamesChoice.getValue().intValue());

        XYChart.Series<String, Double> possessionChart = new XYChart.Series<>();
        for (int i = 0; i < gameList.size(); i++) {
            double possession = gameList.get(i).getPossession();
            possessionChart.getData().add(new XYChart.Data<>(String.valueOf(i + 1), possession));
        }

        possessionGraph.getData().add(possessionChart);
    }

    public void goalAccuracyGraphHandler() throws SQLException {
        List<Game> gameList = GameActions.getGames(lastGamesChoice.getValue().intValue());

        XYChart.Series<String, Double> goalAccuracyChart = new XYChart.Series<>();
        for (int i = 0; i < gameList.size(); i++) {
            Game game = gameList.get(i);
            double accuracy = Double.parseDouble(game.getGoalsScored().toString()) / (Double.parseDouble(game.getGoalsScored().toString()) + Double.parseDouble(game.getMisses().toString())) * 100.0;
            goalAccuracyChart.getData().add(new XYChart.Data<>(String.valueOf(i + 1), accuracy));
        }

        goalAccuracyGraph.getData().add(goalAccuracyChart);
    }

    public void initWindow() throws SQLException {
        //initialize choice box values with the options 10, 20, 30
        lastGamesChoice.getItems().addAll(choices);

        //Set default value to 10
        lastGamesChoice.setValue(10);

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

        //Fetch last 10 games
        try {
            List<Game> gameList = GameActions.getGames(10);

            gameLabel1.setText(gameList.get(0).getOpposingTeamName() + "\n" + gameList.get(0).getGoalsScored() + " - " + gameList.get(0).getGoalsReceived());
            gameLabel2.setText(gameList.get(1).getOpposingTeamName() + "\n" + gameList.get(1).getGoalsScored() + " - " + gameList.get(1).getGoalsReceived());
            gameLabel3.setText(gameList.get(2).getOpposingTeamName() + "\n" + gameList.get(2).getGoalsScored() + " - " + gameList.get(2).getGoalsReceived());
            gameLabel4.setText(gameList.get(3).getOpposingTeamName() + "\n" + gameList.get(3).getGoalsScored() + " - " + gameList.get(3).getGoalsReceived());
            gameLabel5.setText(gameList.get(4).getOpposingTeamName() + "\n" + gameList.get(4).getGoalsScored() + " - " + gameList.get(4).getGoalsReceived());
            gameLabel6.setText(gameList.get(5).getOpposingTeamName() + "\n" + gameList.get(5).getGoalsScored() + " - " + gameList.get(5).getGoalsReceived());
            gameLabel7.setText(gameList.get(6).getOpposingTeamName() + "\n" + gameList.get(6).getGoalsScored() + " - " + gameList.get(6).getGoalsReceived());
            gameLabel8.setText(gameList.get(7).getOpposingTeamName() + "\n" + gameList.get(7).getGoalsScored() + " - " + gameList.get(7).getGoalsReceived());
            gameLabel9.setText(gameList.get(8).getOpposingTeamName() + "\n" + gameList.get(8).getGoalsScored() + " - " + gameList.get(8).getGoalsReceived());
            gameLabel10.setText(gameList.get(9).getOpposingTeamName() + "\n" + gameList.get(9).getGoalsScored() + " - " + gameList.get(9).getGoalsReceived());

        }catch(Exception e){
            System.out.println("Insufficient data!");
        }

        //Init graphs
        scoreLeadsGraph.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        possessionGraph.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
        goalAccuracyGraph.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){

    try{
        initWindow();
        scoreGraphHandler();
        possessionGraphHandler();
        goalAccuracyGraphHandler();

        MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
        menuHandler.menuInteractionHandler();

        //Refreshes the data after changing the option
        lastGamesChoice.setOnAction(event -> {

            try {
                scoreGraphHandler();
                possessionGraphHandler();
                goalAccuracyGraphHandler();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        } catch (Exception e){
        e.printStackTrace();
        }
    }
}
