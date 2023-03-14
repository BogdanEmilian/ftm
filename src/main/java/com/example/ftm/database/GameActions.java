package com.example.ftm.database;

import com.example.ftm.entity.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameActions {
    private static final String ADD_QUERY = "insert into games (opposingTeamName, goalsScored, goalsReceived, gameDate, possession, corners, penalties, freeKicks, gameTime, misses) values(?,?,?,?,?,?,?,?,?,?);";
    private static final String GET_QUERY = "select * from games order by id desc limit ?;";

    public static void insertGame(Game game){
        try{
            Connection conn = DBConnect.connect();
            PreparedStatement st = conn.prepareStatement(ADD_QUERY);

            //Prepare the query with given data
            st.setString(1, game.getOpposingTeamName());
            st.setInt(2, game.getGoalsScored());
            st.setInt(3, game.getGoalsReceived());
            st.setString(4, game.getGameDate());
            st.setDouble(5, game.getPossession());
            st.setInt(6, game.getCorners());
            st.setInt(7, game.getPenalties());
            st.setInt(8, game.getFreeKicks());
            st.setInt(9, game.getGameTime());
            st.setInt(10, game.getMisses());

            st.executeUpdate();
            System.out.println("adding new game against: " + game.getOpposingTeamName());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static List<Game> getGames(Integer num) throws SQLException {
        List<Game> gameList = new ArrayList<>();

        Connection conn = DBConnect.connect();
        PreparedStatement st = conn.prepareStatement(GET_QUERY);

        st.setInt(1, num);

        ResultSet rs = st.executeQuery();

        //Parse the result set from the database and populate the in-memory list
        while (rs.next()){
            Game game = new Game(rs.getString("opposingTeamName"),
                    rs.getInt("goalsScored"),
                    rs.getInt("goalsReceived"),
                    rs.getString("gameDate"),
                    rs.getDouble("possession"),
                    rs.getInt("corners"),
                    rs.getInt("penalties"),
                    rs.getInt("freeKicks"),
                    rs.getInt("gameTime"),
                    rs.getInt("misses")
            );

            gameList.add(game);
        }
        return gameList;
    }
}
