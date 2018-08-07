package com.electroducky.terraincognita.intents;

import java.util.Arrays;

public class IntentParser {
    public static Intent parse(String string) {
        String[] splitted = string.split(" ");
        if (splitted.length == 0)
            die(string);

        String intentKey = splitted[0];
        String intentCommand = String.join(" ", Arrays.copyOfRange(splitted, 1, splitted.length));

        switch (intentKey) {
            case MoveIntent.KEY:
                return MoveIntent.parse(intentCommand);
            case PassIntent.KEY:
                return new PassIntent();
            default:
                die(string);
        }

        //already returned or dead
        return null;
    }

    private static void die(String s) {
        throw new IllegalArgumentException("Intent parse error for " + s);
    }
}
