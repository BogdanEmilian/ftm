package com.example.ftm.entity;

import com.example.ftm.enumeration.Position;

public class Player {

    private int id;
    private String playerName;
    private Integer playerAge;
    private Position playerPosition;
    private Integer playerHeight;
    private Integer playerWeight;
    private Double playerValue;
    private Double playerSalary;
    private Integer playerGoals;
    private Integer playerFreeKicksShot;
    private Integer playerFreeKicksScored;
    private Boolean playerInjured;
    private Integer playerYCards;
    private Integer playerRCards;
    private Double playerPassAccuracy;
    private Double playerGoalAccuracy;
    private Integer playerFouls;

    public Player() {

    }

    public Player(String playerName, Integer playerAge, Position playerPosition, Integer playerHeight,
                  Integer playerWeight, Double playerValue, Double playerSalary, Integer playerGoals,
                  Integer playerFreeKicksShot, Integer playerFreeKicksScored, Boolean playerInjured,
                  Integer playerYCards, Integer playerRCards, Double playerPassAccuracy, Double playerGoalAccuracy,
                  Integer playerFouls)
    {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerPosition = playerPosition;
        this.playerHeight = playerHeight;
        this.playerWeight = playerWeight;
        this.playerValue = playerValue;
        this.playerSalary = playerSalary;
        this.playerGoals = playerGoals;
        this.playerFreeKicksShot = playerFreeKicksShot;
        this.playerFreeKicksScored = playerFreeKicksScored;
        this.playerInjured = playerInjured;
        this.playerYCards = playerYCards;
        this.playerRCards = playerRCards;
        this.playerPassAccuracy = playerPassAccuracy;
        this.playerGoalAccuracy = playerGoalAccuracy;
        this.playerFouls = playerFouls;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(Integer playerAge) {
        this.playerAge = playerAge;
    }

    public Position getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Integer getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(Integer playerHeight) {
        this.playerHeight = playerHeight;
    }

    public Integer getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(Integer playerWeight) {
        this.playerWeight = playerWeight;
    }

    public Double getPlayerValue() {
        return playerValue;
    }

    public void setPlayerValue(Double playerValue) {
        this.playerValue = playerValue;
    }

    public Double getPlayerSalary() {
        return playerSalary;
    }

    public void setPlayerSalary(Double playerSalary) {
        this.playerSalary = playerSalary;
    }

    public Integer getPlayerGoals() {
        return playerGoals;
    }

    public void setPlayerGoals(Integer playerGoals) {
        this.playerGoals = playerGoals;
    }

    public Integer getPlayerFreeKicksShot() {
        return playerFreeKicksShot;
    }

    public void setPlayerFreeKicksShot(Integer playerFreeKicksShot) {
        this.playerFreeKicksShot = playerFreeKicksShot;
    }

    public Integer getPlayerFreeKicksScored() {
        return playerFreeKicksScored;
    }

    public void setPlayerFreeKicksScored(Integer playerFreeKicksScored) {
        this.playerFreeKicksScored = playerFreeKicksScored;
    }

    public Boolean getPlayerInjured() {
        return playerInjured;
    }

    public void setPlayerInjured(Boolean playerInjured) {
        this.playerInjured = playerInjured;
    }

    public Integer getPlayerYCards() {
        return playerYCards;
    }

    public void setPlayerYCards(Integer playerYCards) {
        this.playerYCards = playerYCards;
    }

    public Integer getPlayerRCards() {
        return playerRCards;
    }

    public void setPlayerRCards(Integer playerRCards) {
        this.playerRCards = playerRCards;
    }

    public Double getPlayerPassAccuracy() {
        return playerPassAccuracy;
    }

    public void setPlayerPassAccuracy(Double playerPassAccuracy) {
        this.playerPassAccuracy = playerPassAccuracy;
    }

    public Double getPlayerGoalAccuracy() {
        return playerGoalAccuracy;
    }

    public void setPlayerGoalAccuracy(Double playerGoalAccuracy) {
        this.playerGoalAccuracy = playerGoalAccuracy;
    }

    public Integer getPlayerFouls() {
        return playerFouls;
    }

    public void setPlayerFouls(Integer playerFouls) {
        this.playerFouls = playerFouls;
    }
}