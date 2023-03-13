package com.example.ftm.database;

import com.example.ftm.entity.Player;
import com.example.ftm.enumeration.Position;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerActions {
    private static final String ADD_QUERY = "insert into player (playerName, playerAge, playerPosition, playerHeight, playerWeight, playerValue, playerSalary, playerGoals, playerFreeKicksShot, playerFreeKicksScored, playerInjured, playerYCards, playerRCards, playerPassAccuracy, playerGoalAccuracy, playerFouls) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_QUERY = "delete from player where playerName=? and playerPosition=?;";
    private static final String GET_QUERY = "select * from player where playerName=? and playerPosition=?;";
    private static final String GET_ALL_QUERY = "select * from player;";
    private static final String EDIT_INFO_QUERY = "update player set playerName=?, playerAge=?, playerPosition=?, playerHeight=?, playerWeight=?, playerValue=?, playerSalary=? where playerName=?;";
    private static final String EDIT_PERFORMANCE_QUERY = "update player set playerGoals=?, playerFreeKicksShot=?, playerFreeKicksScored=?, playerInjured=?, playerYCards=?, playerRCards=?, playerPassAccuracy=?, playerGoalAccuracy=?, playerFouls=? where playerName=? AND playerPosition=?;";
    private static final String KEYWORD_INFO_QUERY = "select * from player where playerName like ? or playerAge like ? or playerPosition like ? or playerHeight like ? or playerWeight like ? or playerValue like ? or playerSalary like ?";

    public static void insertPlayer(Player player){
        try{
            Connection conn = DBConnect.connect();
            PreparedStatement st = conn.prepareStatement(ADD_QUERY);

            st.setString(1, player.getPlayerName());
            st.setInt(2, player.getPlayerAge());
            st.setString(3, player.getPlayerPosition().toString());
            st.setInt(4, player.getPlayerHeight());
            st.setInt(5, player.getPlayerWeight());
            st.setDouble(6, player.getPlayerValue());
            st.setDouble(7, player.getPlayerSalary());
            st.setInt(8, player.getPlayerGoals());
            st.setInt(9, player.getPlayerFreeKicksShot());
            st.setInt(10, player.getPlayerFreeKicksScored());
            st.setBoolean(11, player.getPlayerInjured());
            st.setInt(12, player.getPlayerYCards());
            st.setInt(13, player.getPlayerRCards());
            st.setDouble(14, player.getPlayerPassAccuracy());
            st.setDouble(15, player.getPlayerGoalAccuracy());
            st.setInt(16, player.getPlayerFouls());

            st.executeUpdate();
            System.out.println("adding player with name " + player.getPlayerName());

        }catch (Exception e){
            System.out.println("Error inserting player with name: " + player.getPlayerName());
            e.printStackTrace();
        }
    }

    public static void editPlayerInfo(Player player, String playerName) {
        try {
            Connection conn = DBConnect.connect();
            PreparedStatement st = conn.prepareStatement(EDIT_INFO_QUERY);

            st.setString(1, player.getPlayerName());
            st.setInt(2, player.getPlayerAge());
            st.setString(3, player.getPlayerPosition().toString());
            st.setInt(4, player.getPlayerHeight());
            st.setInt(5, player.getPlayerWeight());
            st.setDouble(6, player.getPlayerValue());
            st.setDouble(7, player.getPlayerSalary());

            st.setString(8, playerName);

            st.executeUpdate();
            System.out.println("Player edited");

        } catch (SQLException e) {
            System.out.println("Error updating the player with name " + player.getPlayerName());
            e.printStackTrace();
        }
    }

    public static void editPlayerPerformance(Player player, String playerName, Position playerPosition){
        try {
            Connection conn = DBConnect.connect();
            PreparedStatement st = conn.prepareStatement(EDIT_PERFORMANCE_QUERY);

            st.setInt(1, player.getPlayerGoals());
            st.setInt(2, player.getPlayerFreeKicksShot());
            st.setInt(3, player.getPlayerFreeKicksScored());
            st.setBoolean(4, player.getPlayerInjured());
            st.setInt(5, player.getPlayerYCards());
            st.setInt(6, player.getPlayerRCards());
            st.setDouble(7, player.getPlayerPassAccuracy());
            st.setDouble(8, player.getPlayerGoalAccuracy());
            st.setInt(9, player.getPlayerFouls());

            st.setString(10, playerName);
            st.setString(11, playerPosition.toString());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating the player with name " + player.getPlayerName());
            e.printStackTrace();
        }
    }

    public static void deletePlayer(String name, Position position) throws SQLException {
        try {
            Connection conn = DBConnect.connect();
            PreparedStatement st = conn.prepareStatement(DELETE_QUERY);

            st.setString(1, name);
            st.setString(2, position.toString());

            st.executeUpdate();
        }catch (Exception e){
            System.out.println("Error deleting the player with name " + name);
            e.printStackTrace();
        }

    }

    public static Player getPlayer(String playerName, Position playerPosition) throws SQLException {
        Connection conn = DBConnect.connect();
        PreparedStatement st = conn.prepareStatement(GET_QUERY);

        st.setString(1, "John Doe");

        ResultSet rs = st.executeQuery();
        Player player = new Player();

        if (rs.next()) {

            player.setPlayerName(rs.getString("playerName"));
            player.setPlayerAge(rs.getInt("playerAge"));
            player.setPlayerPosition(Position.valueOf(rs.getString("playerPosition")));
            player.setPlayerHeight(rs.getInt("playerHeight"));
            player.setPlayerWeight(rs.getInt("playerWeight"));
            player.setPlayerValue(rs.getDouble("playerValue"));
            player.setPlayerSalary(rs.getDouble("playerSalary"));
            player.setPlayerGoals(rs.getInt("playerGoals"));
            player.setPlayerFreeKicksShot(rs.getInt("playerFreeKicksShot"));
            player.setPlayerFreeKicksScored(rs.getInt("playerFreeKicksScored"));
            player.setPlayerInjured(rs.getBoolean("playerInjured"));
            player.setPlayerYCards(rs.getInt("playerYCards"));
            player.setPlayerRCards(rs.getInt("playerRCards"));
            player.setPlayerPassAccuracy(rs.getDouble("playerPassAccuracy"));
            player.setPlayerGoalAccuracy(rs.getDouble("playerGoalAccuracy"));
            player.setPlayerFouls(rs.getInt("playerFouls"));

        } else {
            rs.close();
            st.close();
        }

        return player;
    }

    public static ObservableList<Player> getAll() throws SQLException {
        List<Player> players = new ArrayList<>();

        Connection conn = DBConnect.connect();
        PreparedStatement st = conn.prepareStatement(GET_ALL_QUERY);

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            Player newPlayer = new Player(
                    rs.getString("playerName"),
                    rs.getInt("playerAge"),
                    Position.valueOf(rs.getString("playerPosition")),
                    rs.getInt("playerHeight"),
                    rs.getInt("playerWeight"),
                    rs.getDouble("playerValue"),
                    rs.getDouble("playerSalary"),
                    rs.getInt("playerGoals"),
                    rs.getInt("playerFreeKicksShot"),
                    rs.getInt("playerFreeKicksScored"),
                    rs.getBoolean("playerInjured"),
                    rs.getInt("playerYCards"),
                    rs.getInt("playerRCards"),
                    rs.getDouble("playerPassAccuracy"),
                    rs.getDouble("playerGoalAccuracy"),
                    rs.getInt("playerFouls")
            );

            players.add(newPlayer);
        }
        return FXCollections.observableArrayList(players);
    }

    public static ObservableList<Player> getAllMatchingInfo(String keyword) throws SQLException {
        List<Player> players = new ArrayList<>();

        Connection conn = DBConnect.connect();
        PreparedStatement st = conn.prepareStatement(KEYWORD_INFO_QUERY);

        for (int i = 1; i <= 7; i++) {
            st.setString(i, "%" + keyword + "%");
        }

        ResultSet rs = st.executeQuery();
        Player player = new Player();

        while (rs.next()) {

            Player newPlayer = new Player(
                    rs.getString("playerName"),
                    rs.getInt("playerAge"),
                    Position.valueOf(rs.getString("playerPosition")),
                    rs.getInt("playerHeight"),
                    rs.getInt("playerWeight"),
                    rs.getDouble("playerValue"),
                    rs.getDouble("playerSalary"),
                    rs.getInt("playerGoals"),
                    rs.getInt("playerFreeKicksShot"),
                    rs.getInt("playerFreeKicksScored"),
                    rs.getBoolean("playerInjured"),
                    rs.getInt("playerYCards"),
                    rs.getInt("playerRCards"),
                    rs.getDouble("playerPassAccuracy"),
                    rs.getDouble("playerGoalAccuracy"),
                    rs.getInt("playerFouls")
            );
            players.add(newPlayer);
        }

        return FXCollections.observableArrayList(players);
    }

}
