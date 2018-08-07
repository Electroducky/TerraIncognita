package com.electroducky.terraincognita.world;

import java.util.Arrays;
import java.util.Random;

public class Labyrinth {
    public static Labyrinth generate(int size) {
        Labyrinth result = new Labyrinth(size);
        fillMatrixRandomly(result.horizontalWalls);
        fillMatrixRandomly(result.verticalWalls);
        return result;
    }

    private static void fillMatrixRandomly(boolean[][] array) {
        Random r = new Random();
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (r.nextDouble() < 0.2)
                    array[i][j] = true;
    }

    private boolean[][] verticalWalls;
    private boolean[][] horizontalWalls;
    private int size;

    private Labyrinth(int size) {
        this.size = size;
        verticalWalls = new boolean[size][size - 1];
        horizontalWalls = new boolean[size - 1][size];
    }

    public boolean isWall(UnitVector uv) {
        int dx = uv.dx();
        int dy = uv.dy();

        int nx = uv.start().getX() * 2 + dx;
        int ny = uv.start().getY() * 2 + dy;

        return nx < 0 || ny < 0 || nx >= size * 2 - 1 || ny >= size * 2 - 1 ||
                (dx != 0 && verticalWalls[ny / 2][nx / 2]) ||
                (dy != 0 && horizontalWalls[ny / 2][nx / 2]);
    }
}
