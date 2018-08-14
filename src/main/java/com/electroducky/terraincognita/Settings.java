package com.electroducky.terraincognita;

public class Settings {
    private int playerAmount;
    private String[] names;
    private int labyrinthSize;

    public static Settings createSettings() {
        return new Settings();
    }

    public static Settings parse(String playerAmount, String names, String size) {
        Settings s = createSettings();
        if (playerAmount.equals(""))
            s.playerAmount = 1;
        else s.playerAmount = Integer.parseInt(playerAmount);

        if (names.equals(""))
            s.names = null;
        else s.names = names.split(",");

        if (size.equals(""))
            s.labyrinthSize = 25;
        else s.labyrinthSize = Integer.parseInt(size);

        return s;
    }


    public int getPlayerAmount() {
        return playerAmount;
    }

    public String[] getNames() {
        return names;
    }

    public int getLabyrinthSize() {
        return labyrinthSize;
    }
}


