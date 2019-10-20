package model;

import types.Color;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int MAX_LONG = 10;

    private SecretCombination secretCombination;

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attempts;

    public Game() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<>();
        this.results = new ArrayList<>();
        this.attempts = 0;
    }

    int getWidth() {
        return Combination.getWidth();
    }

    public List<Result> getResults() {
        return this.results;
    }

    boolean isWinner() {
        if (this.attempts == 0) {
            return false;
        }
        return this.results.get(this.attempts - 1).isWinner();
    }

    public boolean isLooser() {
        return this.results.size() == MAX_LONG;
    }

    public void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public Integer getBlacks(int i) {
        return this.results.get(i).getBlacks();
    }

    public Integer getWhites(int i) {
        return this.results.get(i).getWhites();
    }

    public List<Color> getCombination(int i) {
        return this.proposedCombinations.get(i).getColors();
    }
}
