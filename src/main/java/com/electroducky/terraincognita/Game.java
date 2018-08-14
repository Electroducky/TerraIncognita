package com.electroducky.terraincognita;

import com.electroducky.terraincognita.intents.Intent;
import com.electroducky.terraincognita.intents.MoveIntent;
import com.electroducky.terraincognita.intents.PassIntent;
import com.electroducky.terraincognita.world.Coordinate;
import com.electroducky.terraincognita.world.Labyrinth;
import com.electroducky.terraincognita.world.UnitVector;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Labyrinth labyrinth;
    private int currentPlayerIndex = 0;
    private int playerAmount;

    public Game(Settings settings) {
        this.labyrinth = Labyrinth.generate(settings.getLabyrinthSize());
        playerAmount = settings.getPlayerAmount();
        populatePlayers(settings.getNames());
    }

    private void populatePlayers(String[] names) {
        for (int i = 0; i < playerAmount; i++) {
            if (names == null || names[i] == null)
                players.add(new Player());
            else players.add(new Player(names[i]));
        }
    }

    public TurnResult start() {
        return new TurnResult().setNextPlayer(players.get(currentPlayerIndex).toString());
    }

    public TurnResult turn(Intent intent) {
        TurnResult result = currentResult();
        if (intent instanceof MoveIntent)
            result.setMessage(move((MoveIntent) intent));
        else if (intent instanceof PassIntent)
            pass((PassIntent) intent);
        else
            result.setWasSuccessful(false);

        currentPlayerIndex++;
        currentPlayerIndex %= playerAmount;
        return result;
    }

    private String move(MoveIntent move) {
        UnitVector uv = new UnitVector(currentPlayer().getPosition(), move.getDirection());
        if (labyrinth.isWall(uv))
            return "The wall is here, my dear";
        else {
            currentPlayer().moveTo(uv.end());
            return "You are in " + currentPlayer().getPosition();
        }
    }

    private void pass(PassIntent pass) {
    }

    private TurnResult currentResult() {
        return new TurnResult().setCurrentPlayer(currentPlayer().toString()).setNextPlayer(players.get((currentPlayerIndex + 1) % playerAmount).toString());
    }

    private Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }
}
