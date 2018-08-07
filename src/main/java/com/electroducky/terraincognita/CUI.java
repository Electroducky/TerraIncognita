package com.electroducky.terraincognita;

import com.electroducky.terraincognita.intents.IntentParser;
import com.electroducky.terraincognita.world.Labyrinth;

import java.util.Random;
import java.util.Scanner;

public class CUI {
    private Scanner scanner = new Scanner(System.in);
    private boolean loop;
    private Game game;

    public void start() {
        game = new Game(Labyrinth.generate(3), 1);
        loop = true;
        System.out.println(game.start());
        while (loop) {
            handleInput(scanner.nextLine());
        }
    }

    private void handleInput(String line) {
        if (line.equals("end"))
            stop();
        else try {
            System.out.println(game.turn(IntentParser.parse(line)));
        } catch (IllegalArgumentException e) {
            blame();
        }
    }

    private void stop() {
        System.out.println("Bye");
        loop = false;
    }

    private void blame() {
        String answer = "";
        switch (new Random().nextInt(5)) {
            case 0:
                answer = "Moron! That's wrong words!!!";
                break;
            case 1:
                answer = "❤❤❤ You are my sweet down ❤❤❤";
                break;
            case 2:
                answer = "Holly dolly he doesn't know how to use keyboard!";
                break;
            case 3:
                answer = "Really nigga?";
                break;
            case 4:
                answer = "It's time to stop, okay? Just enter right words and don't drive me mad :/";
                break;
        }
        System.out.println(answer);
    }
}
