package com.example.ftm;

import com.example.ftm.database.GameActions;
import com.example.ftm.entity.Game;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
    private void addNewGame(ActionEvent event){
        try {
            //Load the adding scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/addGame.fxml"));
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

    public void initWindow(){
        enemyTeam1.setText("");
        score1.setText("");
        date1.setText("");
        possession1.setText("");
        time1.setText("");
        penalties1.setText("");
        freeKicks1.setText("");
        misses1.setText("");

        enemyTeam2.setText("");
        score2.setText("");
        date2.setText("");
        possession2.setText("");
        time2.setText("");
        penalties2.setText("");
        freeKicks2.setText("");
        misses2.setText("");

        enemyTeam3.setText("");
        score3.setText("");
        date3.setText("");
        possession3.setText("");
        time3.setText("");
        penalties3.setText("");
        freeKicks3.setText("");
        misses3.setText("");

        enemyTeam4.setText("");
        score4.setText("");
        date4.setText("");
        possession4.setText("");
        time4.setText("");
        penalties4.setText("");
        freeKicks4.setText("");
        misses4.setText("");

        enemyTeam5.setText("");
        score5.setText("");
        date5.setText("");
        possession5.setText("");
        time5.setText("");
        penalties5.setText("");
        freeKicks5.setText("");
        misses5.setText("");

        enemyTeam6.setText("");
        score6.setText("");
        date6.setText("");
        possession6.setText("");
        time6.setText("");
        penalties6.setText("");
        freeKicks6.setText("");
        misses6.setText("");

        enemyTeam7.setText("");
        score7.setText("");
        date7.setText("");
        possession7.setText("");
        time7.setText("");
        penalties7.setText("");
        freeKicks7.setText("");
        misses7.setText("");

        enemyTeam8.setText("");
        score8.setText("");
        date8.setText("");
        possession8.setText("");
        time8.setText("");
        penalties8.setText("");
        freeKicks8.setText("");
        misses8.setText("");

        enemyTeam9.setText("");
        score9.setText("");
        date9.setText("");
        possession9.setText("");
        time9.setText("");
        penalties9.setText("");
        freeKicks9.setText("");
        misses9.setText("");
    }

    public void fetchData() throws SQLException {
        List<Game> gameList = GameActions.getGames(9);

        try {
            enemyTeam1.setText(gameList.get(0).getOpposingTeamName());
            score1.setText(gameList.get(0).getGoalsScored() + " - " + gameList.get(0).getGoalsReceived());
            date1.setText(gameList.get(0).getGameDate());
            possession1.setText(gameList.get(0).getPossession().toString() + "%");
            time1.setText(gameList.get(0).getGameTime().toString() + "''");
            penalties1.setText(gameList.get(0).getPenalties().toString());
            freeKicks1.setText(gameList.get(0).getFreeKicks().toString());
            misses1.setText(gameList.get(0).getMisses().toString());

            enemyTeam2.setText(gameList.get(1).getOpposingTeamName());
            score2.setText(gameList.get(1).getGoalsScored() + " - " + gameList.get(1).getGoalsReceived());
            date2.setText(gameList.get(1).getGameDate());
            possession2.setText(gameList.get(1).getPossession().toString() + "%");
            time2.setText(gameList.get(1).getGameTime().toString() + "''");
            penalties2.setText(gameList.get(1).getPenalties().toString());
            freeKicks2.setText(gameList.get(1).getFreeKicks().toString());
            misses2.setText(gameList.get(1).getMisses().toString());

            enemyTeam3.setText(gameList.get(2).getOpposingTeamName());
            score3.setText(gameList.get(2).getGoalsScored() + " - " + gameList.get(2).getGoalsReceived());
            date3.setText(gameList.get(2).getGameDate());
            possession3.setText(gameList.get(2).getPossession().toString() + "%");
            time3.setText(gameList.get(2).getGameTime().toString() + "''");
            penalties3.setText(gameList.get(2).getPenalties().toString());
            freeKicks3.setText(gameList.get(2).getFreeKicks().toString());
            misses3.setText(gameList.get(2).getMisses().toString());

            enemyTeam4.setText(gameList.get(3).getOpposingTeamName());
            score4.setText(gameList.get(3).getGoalsScored() + " - " + gameList.get(3).getGoalsReceived());
            date4.setText(gameList.get(3).getGameDate());
            possession4.setText(gameList.get(3).getPossession().toString() + "%");
            time4.setText(gameList.get(3).getGameTime().toString() + "''");
            penalties4.setText(gameList.get(3).getPenalties().toString());
            freeKicks4.setText(gameList.get(3).getFreeKicks().toString());
            misses4.setText(gameList.get(3).getMisses().toString());

            enemyTeam5.setText(gameList.get(4).getOpposingTeamName());
            score5.setText(gameList.get(4).getGoalsScored() + " - " + gameList.get(4).getGoalsReceived());
            date5.setText(gameList.get(4).getGameDate());
            possession5.setText(gameList.get(4).getPossession().toString() + "%");
            time5.setText(gameList.get(4).getGameTime().toString() + "''");
            penalties5.setText(gameList.get(4).getPenalties().toString());
            freeKicks5.setText(gameList.get(4).getFreeKicks().toString());
            misses5.setText(gameList.get(4).getMisses().toString());

            enemyTeam6.setText(gameList.get(5).getOpposingTeamName());
            score6.setText(gameList.get(5).getGoalsScored() + " - " + gameList.get(5).getGoalsReceived());
            date6.setText(gameList.get(5).getGameDate());
            possession6.setText(gameList.get(5).getPossession().toString() + "%");
            time6.setText(gameList.get(5).getGameTime().toString() + "''");
            penalties6.setText(gameList.get(5).getPenalties().toString());
            freeKicks6.setText(gameList.get(5).getFreeKicks().toString());
            misses6.setText(gameList.get(5).getMisses().toString());

            enemyTeam7.setText(gameList.get(6).getOpposingTeamName());
            score7.setText(gameList.get(6).getGoalsScored() + " - " + gameList.get(6).getGoalsReceived());
            date7.setText(gameList.get(6).getGameDate());
            possession7.setText(gameList.get(6).getPossession().toString() + "%");
            time7.setText(gameList.get(6).getGameTime().toString() + "''");
            penalties7.setText(gameList.get(6).getPenalties().toString());
            freeKicks7.setText(gameList.get(6).getFreeKicks().toString());
            misses7.setText(gameList.get(6).getMisses().toString());

            enemyTeam8.setText(gameList.get(7).getOpposingTeamName());
            score8.setText(gameList.get(7).getGoalsScored() + " - " + gameList.get(7).getGoalsReceived());
            date8.setText(gameList.get(7).getGameDate());
            possession8.setText(gameList.get(7).getPossession().toString() + "%");
            time8.setText(gameList.get(7).getGameTime().toString() + "''");
            penalties8.setText(gameList.get(7).getPenalties().toString());
            freeKicks8.setText(gameList.get(7).getFreeKicks().toString());
            misses8.setText(gameList.get(7).getMisses().toString());

            enemyTeam9.setText(gameList.get(8).getOpposingTeamName());
            score9.setText(gameList.get(8).getGoalsScored() + " - " + gameList.get(8).getGoalsReceived());
            date9.setText(gameList.get(8).getGameDate());
            possession9.setText(gameList.get(8).getPossession().toString() + "%");
            time9.setText(gameList.get(8).getGameTime().toString() + "''");
            penalties9.setText(gameList.get(8).getPenalties().toString());
            freeKicks9.setText(gameList.get(8).getFreeKicks().toString());
            misses9.setText(gameList.get(8).getMisses().toString());

        } catch (Exception e){
            System.out.println("Insufficient data!");
        }

        double ally = gameList.stream()
                .mapToDouble(Game::getPossession)
                .sum();
        double meanPossession = ally/gameList.size();

        ObservableList<PieChart.Data> possessionPieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Opponent", 100-meanPossession),
                new PieChart.Data("Ally", meanPossession)
        );

        possessionPieChart.getData().addAll(possessionPieChartData);

        double allyScore = gameList.stream()
                .mapToDouble(Game::getGoalsScored)
                .sum();
        double opponentScore = gameList.stream()
                .mapToDouble(Game::getGoalsReceived)
                .sum();
        double meanAllyScore = allyScore / gameList.size();
        double meanOpponentScore = opponentScore / gameList.size();

        ObservableList<PieChart.Data> scorePieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Ally", meanAllyScore),
                new PieChart.Data("Opponent", meanOpponentScore)
        );

        scorePieChart.getData().addAll(scorePieChartData);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        initWindow();

        try {
            fetchData();

            MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
            menuHandler.menuInteractionHandler();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
