package com.example.ftm.enumeration;

public enum GUI {
    SIZE_OF_MAIN_X(700),
    SIZE_OF_MAIN_y(1200),
    SIZE_OF_DASHBOARD_X(400),
    SIZE_OF_DASHBOARD_Y(600),
    SIZE_OF_PLAYERS_X(400),
    SIZE_OF_PLAYERS_y(600),
    SIZE_OF_PLAYERS_ADD_X(500),
    SIZE_OF_PLAYERS_ADD_y(800),
    SIZE_OF_PLAYERS_EDIT_X(500),
    SIZE_OF_PLAYERS_EDIT_y(800),
    SIZE_OF_PERFORMANCE_X(400),
    SIZE_OF_PERFORMANCE_y(600),
    SIZE_OF_HISTORY_X(400),
    SIZE_OF_HISTORY_y(600),
    SIZE_OF_EXPORT_X(700),
    SIZE_OF_EXPORT_y(1200);

    private final int value;

    GUI(final int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
