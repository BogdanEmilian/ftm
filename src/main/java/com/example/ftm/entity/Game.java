package com.example.ftm.entity;

public class Game {
    private String opposingTeamName;
    private Integer goalsScored;
    private Integer goalsReceived;
    private String gameDate;
    private Double possession;
    private Integer corners;
    private Integer penalties;
    private Integer freeKicks;
    private Integer gameTime;
    private Integer misses;

    public Game(){

    }

    public Game(String opposingTeamName, Integer goalsScored, Integer goalsReceived, String gameDate, Double possession,
                Integer corners, Integer penalties, Integer freeKicks, Integer gameTime, Integer misses) {
        this.opposingTeamName = opposingTeamName;
        this.goalsScored = goalsScored;
        this.goalsReceived = goalsReceived;
        this.gameDate = gameDate;
        this.possession = possession;
        this.corners = corners;
        this.penalties = penalties;
        this.freeKicks = freeKicks;
        this.gameTime = gameTime;
        this.misses = misses;
    }

    public String getOpposingTeamName() {
        return opposingTeamName;
    }

    public void setOpposingTeamName(String opposingTeamName) {
        this.opposingTeamName = opposingTeamName;
    }

    public Integer getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Integer goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Integer getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(Integer goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public Double getPossession() {
        return possession;
    }

    public void setPossession(Double possession) {
        this.possession = possession;
    }

    public Integer getCorners() {
        return corners;
    }

    public void setCorners(Integer corners) {
        this.corners = corners;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public Integer getFreeKicks() {
        return freeKicks;
    }

    public void setFreeKicks(Integer freeKicks) {
        this.freeKicks = freeKicks;
    }

    public Integer getGameTime() {
        return gameTime;
    }

    public void setGameTime(Integer gameTime) {
        this.gameTime = gameTime;
    }

    public Integer getMisses() {
        return misses;
    }

    public void setMisses(Integer misses) {
        this.misses = misses;
    }
}
