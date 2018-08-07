package com.electroducky.terraincognita;

public class TurnResult {
    private boolean wasSuccessful = true;
    private String message = "";
    private String currentPlayer;
    private String nextPlayer;

    public TurnResult() {
    }

    public TurnResult setWasSuccessful(boolean wasSuccessful) {
        this.wasSuccessful = wasSuccessful;
        return this;
    }

    public TurnResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public TurnResult setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
        return this;
    }

    public TurnResult setNextPlayer(String nextPlayer) {
        this.nextPlayer = nextPlayer;
        return this;
    }

    public boolean wasSuccessful() {
        return wasSuccessful;
    }

    public String getMessage() {
        return message;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public String getNextPlayer() {
        return nextPlayer;
    }

    @Override
    public String toString() {
        return message + (wasSuccessful ? "\nYour turn, " + nextPlayer : "\nTry again, " + currentPlayer);
    }
}
