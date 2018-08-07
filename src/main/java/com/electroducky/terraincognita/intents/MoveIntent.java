package com.electroducky.terraincognita.intents;

import com.electroducky.terraincognita.world.Direction;

public class MoveIntent implements Intent {
    public static final String KEY = "move";
    private Direction direction;

    public static MoveIntent parse(String s) {
        return new MoveIntent(Direction.fromString(s));
    }

    public MoveIntent(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
