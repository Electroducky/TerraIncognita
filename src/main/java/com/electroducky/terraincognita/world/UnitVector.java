package com.electroducky.terraincognita.world;

public class UnitVector {
    private Coordinate coordinate;
    private Direction direction;

    public UnitVector(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate start() {
        return coordinate;
    }

    public Coordinate end() {
        return coordinate.directionTo(direction);
    }

    public int dx() {
        return end().getX() - start().getX();
    }

    public int dy() {
        return end().getY() - start().getY();
    }
}
