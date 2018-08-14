package com.electroducky.terraincognita;

import com.electroducky.terraincognita.world.Coordinate;

public class Player {
    private Coordinate position = new Coordinate(0, 0);
    private String name = "Bot";
    private int ID;
    static int IDCounter;

    public Player(String name) {
        this();
        this.name = name;
    }

    public Player() {
        ID = ++IDCounter;
    }

    public void moveTo(Coordinate coordinate) {
        position = coordinate;
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + "#" + ID;
    }
}
