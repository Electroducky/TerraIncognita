package com.electroducky.terraincognita.world;

public enum Direction {
    UP("up", 0, 1),
    DOWN("down", 0, -1),
    LEFT("left", -1, 0),
    RIGHT("right", 1, 0);

    public static Direction fromString(String string) {
        for (Direction d : Direction.values())
            if (string.equals(d.name))
                return d;
        throw new IllegalArgumentException("Wrong string");
    }

    private String name;
    private int dx, dy;

    Direction(String name, int dx, int dy) {
        this.name = name;
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    @Override
    public String toString() {
        return name;
    }
}
