package models;

import utils.IO;
import views.console.Message;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int MAX_ATTEMPTS = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<ResultCombination> resultCombinations;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<>();
        this.resultCombinations = new ArrayList<>();
    }

    public List<ResultCombination> getResultCombinations() {
        return this.resultCombinations;
    }

    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }

    public boolean isFinished() {
        if (this.resultCombinations.get(this.getAttemps() - 1).isWinner()) {
            IO.writeln(Message.WINNER);
            return true;
        }
        if (this.getAttemps() == MAX_ATTEMPTS) {
            IO.writeln(Message.LOOSER);
            return true;
        }
        return false;
    }

    private int getAttemps() {
        return this.proposedCombinations.size();
    }

    public void addResult(ProposedCombination proposedCombination) {
        this.resultCombinations.add(this.secretCombination.getResult(proposedCombination));
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    public List<ProposedCombination> getProposedCombinations() {
        return this.proposedCombinations;
    }
}
