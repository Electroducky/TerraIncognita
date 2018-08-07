package com.electroducky.terraincognita;

import com.electroducky.terraincognita.world.Coordinate;

public class Player {
    private Coordinate position = new Coordinate(0, 0);
    private String name = "Bot";

    public Player(String name) {
        this();
        this.name = name;
    }

    public Player() {
    }

    public void moveTo(Coordinate coordinate) {
        position = coordinate;
    }

    public Coordinate getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + "#" + Integer.toHexString(hashCode() >> 16);
    }
}
