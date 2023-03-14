package com.example.ftm;

import com.example.ftm.database.PlayerActions;
import com.example.ftm.entity.Player;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PDFExportController implements Initializable {
    String path;

    @FXML
    private JFXButton dashboardTab;

    @FXML
    private JFXButton exportGraphsButton;

    @FXML
    private JFXButton exportRosterButton;

    @FXML
    private JFXButton exportTab;

    @FXML
    private JFXButton exportTablesButton;

    @FXML
    private JFXButton historyTab;

    @FXML
    private TextField pathToExport;

    @FXML
    private ImageView menu;

    @FXML
    private AnchorPane panel1;

    @FXML
    private AnchorPane panel2;

    @FXML
    private JFXButton performanceTab;

    @FXML
    private JFXButton playersTab;


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


    @FXML
    ChoiceBox<String> filterChoiceBox;

    @FXML
    public void exportTables()  {
        int tableCol;

        if(filterChoiceBox.getValue().equals("Player info")){
            tableCol = 7;
        } else {
            tableCol = 10;
        }

        try {
            path = pathToExport.getText();
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(path));


            //Opens the document writing method
            //Everything added here will be added to the PDF
            document.open();

            Paragraph paragraph = new Paragraph("Below you will find a table with the player data:");
            document.add(paragraph);

            if(tableCol == 7) {
                PdfPTable table = new PdfPTable(tableCol);

                //Adds the headers and creates each column
                PdfPCell c1 = new PdfPCell(new Phrase("Name"));
                table.addCell(c1);
                PdfPCell c2 = new PdfPCell(new Phrase("Age"));
                table.addCell(c2);
                PdfPCell c3 = new PdfPCell(new Phrase("Position"));
                table.addCell(c3);
                PdfPCell c4 = new PdfPCell(new Phrase("Height"));
                table.addCell(c4);
                PdfPCell c5 = new PdfPCell(new Phrase("Weight"));
                table.addCell(c5);
                PdfPCell c6 = new PdfPCell(new Phrase("Value"));
                table.addCell(c6);
                PdfPCell c7 = new PdfPCell(new Phrase("Salary"));
                table.addCell(c7);

                table.setHeaderRows(1);

                List<Player> playerList = new ArrayList<>(PlayerActions.getAll());

                //Populates table cells with data
                for (Player player : playerList) {
                    table.addCell(player.getPlayerName());
                    table.addCell(player.getPlayerAge().toString());
                    table.addCell(player.getPlayerPosition().toString());
                    table.addCell(player.getPlayerHeight().toString());
                    table.addCell(player.getPlayerWeight().toString());
                    table.addCell(player.getPlayerValue().toString());
                    table.addCell(player.getPlayerSalary().toString());
                }

                document.add(table);
            }else {
                PdfPTable table = new PdfPTable(tableCol);

                //Adds the headers and creates each column
                PdfPCell c1 = new PdfPCell(new Phrase("Name"));
                table.addCell(c1);
                PdfPCell c2 = new PdfPCell(new Phrase("Free kicks scored"));
                table.addCell(c2);
                PdfPCell c3 = new PdfPCell(new Phrase("Free kicks shot"));
                table.addCell(c3);
                PdfPCell c4 = new PdfPCell(new Phrase("Injured"));
                table.addCell(c4);
                PdfPCell c5 = new PdfPCell(new Phrase("Yellow cards"));
                table.addCell(c5);
                PdfPCell c6 = new PdfPCell(new Phrase("Red cards"));
                table.addCell(c6);
                PdfPCell c7 = new PdfPCell(new Phrase("Passing accuracy"));
                table.addCell(c7);
                PdfPCell c8 = new PdfPCell(new Phrase("Goal accuracy"));
                table.addCell(c8);
                PdfPCell c9 = new PdfPCell(new Phrase("No. of goals"));
                table.addCell(c9);
                PdfPCell c10 = new PdfPCell(new Phrase("Fouls committed"));
                table.addCell(c10);

                table.setHeaderRows(1);

                List<Player> playerList = new ArrayList<>(PlayerActions.getAll());

                //Populates table cells with data
                for (Player player : playerList) {
                    table.addCell(player.getPlayerName());
                    table.addCell(player.getPlayerFreeKicksScored().toString());
                    table.addCell(player.getPlayerFreeKicksShot().toString());
                    table.addCell(player.getPlayerInjured().toString());
                    table.addCell(player.getPlayerYCards().toString());
                    table.addCell(player.getPlayerRCards().toString());
                    table.addCell(player.getPlayerPassAccuracy().toString());
                    table.addCell(player.getPlayerPassAccuracy().toString());
                    table.addCell(player.getPlayerGoals().toString());
                    table.addCell(player.getPlayerFouls().toString());
                }

                document.add(table);
            }
            document.close();
            System.out.println(path);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void exportRoster() {
        try {
            List<Player> playerList = new ArrayList<>(PlayerActions.getAll());

            path = pathToExport.getText();
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(path));

            //Opens the document writing method
            //Everything added here will be added to the PDF
            document.open();

            Paragraph paragraph = new Paragraph("Below you will find a table with the player recommendations:");
            document.add(paragraph);

            PdfPTable table = new PdfPTable(7);

            //Adds the headers and creates each column
            PdfPCell c1 = new PdfPCell(new Phrase("Name"));
            table.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Age"));
            table.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Position"));
            table.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Height"));
            table.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase("Weight"));
            table.addCell(c5);
            PdfPCell c6 = new PdfPCell(new Phrase("Value"));
            table.addCell(c6);
            PdfPCell c7 = new PdfPCell(new Phrase("Salary"));
            table.addCell(c7);

            table.setHeaderRows(1);

            //Populates table cells with data
            for(Player player : getBestPlayerComp(playerList)){
                table.addCell(player.getPlayerName());
                table.addCell(player.getPlayerAge().toString());
                table.addCell(player.getPlayerPosition().toString());
                table.addCell(player.getPlayerHeight().toString());
                table.addCell(player.getPlayerWeight().toString());
                table.addCell(player.getPlayerValue().toString());
                table.addCell(player.getPlayerSalary().toString());
            }

            document.add(table);

            document.close();
            System.out.println(path);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Player> getBestPlayerComp(List<Player> allPlayers) {
        List<Player> resultList = new ArrayList<>();

        //Links the players to a value that is going to be used for sorting them in the list
        HashMap<Player, Double> valueMap = new HashMap<>();

        //Adds a weight to the performance data in order to create a value for ordering
        for (Player player : allPlayers) {
            double value = player.getPlayerGoals() * 2
                    + player.getPlayerFreeKicksScored() * 4
                    + player.getPlayerPassAccuracy() * 3
                    + player.getPlayerGoalAccuracy() * 7;

            valueMap.put(player, value);
        }

        //Convert the HashMap to a List of Map.Entry objects
        List<Map.Entry<Player, Double>> list = new ArrayList<>(valueMap.entrySet());

        //Sort the list based on the values of the entries
        Collections.sort(list, new Comparator<Map.Entry<Player, Double>>() {
            public int compare(Map.Entry<Player, Double> o1, Map.Entry<Player, Double> o2) {
                return o2.getValue().compareTo(o1.getValue()); // reverse order
            }
        });

        //Create a new List of Player objects with the sorted entries
        for (Map.Entry<Player, Double> entry : list) {
            resultList.add(entry.getKey());
        }

        return resultList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        MenuHandler menuHandler = new MenuHandler(panel1, panel2, menu);
        menuHandler.menuInteractionHandler();

        String[] filters = {"Player info", "Performance data"};
        filterChoiceBox.getItems().addAll(filters);
    }
}
