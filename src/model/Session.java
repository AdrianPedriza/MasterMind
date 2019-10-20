package model;

import types.Color;

import java.util.ArrayList;
import java.util.List;

public class Session {

    private State state;

    private Game game;

    public Session() {
        resetGame();
    }

    public StateValue getValue() {
        return this.state.getStateValue();
    }

    public void next() {
        this.state.next();
    }

    public int getWidth() {
        return this.game.getWidth();
    }

    public void resetGame() {
        this.state = new State();
        this.game = new Game();
    }

    public boolean isLooser() {
        return this.game.isLooser();
    }

    public boolean isWinner() {
        return this.game.isWinner();
    }

    public int getAttempts() {
        return this.game.getResults().size();
    }

    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
    }

    public List<List<Color>> getLastCombintions() {
        List<List<Color>> lastCombination = new ArrayList<>();
        for(int i=0; i<this.game.getAttempts(); i++) {
            lastCombination.add(this.game.getCombination(i));
        }
        return lastCombination;
    }

    public List<List<Integer>> getLastResults() {
        List<List<Integer>> lastResults = new ArrayList<>();
        for(int i=0; i<this.game.getAttempts(); i++) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(this.game.getBlacks(i));
            result.add(this.game.getWhites(i));
            lastResults.add(result);
        }
        return lastResults;
    }
}
