package mastermind.models;

import java.util.ArrayList;
import java.util.List;

import mastermind.types.Color;
import mastermind.utils.Originator;

public class Game implements Originator {


    public static final int MAX_LONG = 10;

    private SecretCombination secretCombination;

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attempts;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
        this.attempts = 0;
    }

    public void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination(colors);
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
    }

    boolean isWinner() {
        if (this.attempts == 0) {
            return false;
        }
        return this.results.get(this.attempts - 1).isWinner();
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void addResult(Result result) {
        this.results.add(result);
    }

    public Result getResult(int position) {
        return this.results.get(position);
    }

    public int getAttempts() {
        return this.attempts;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public List<ProposedCombination> getProposedCombinations() {
        return this.proposedCombinations;
    }

    public SecretCombination getSecretCombination() {
        return this.secretCombination;
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.proposedCombinations.get(position);
    }

    @Override
    public void restore(Memento memento) {
        this.attempts = memento.getAttempts();
        this.proposedCombinations = memento.getProposedCombinations();
        this.results = memento.getResults();
    }

    @Override
    public Memento createMemento() {
        Memento memento = new Memento(this.attempts);
        for (int i = 0; i < this.proposedCombinations.size(); i++) {
            memento.add(this.proposedCombinations.get(i).copy(), this.results.get(i).copy());
        }
        return memento;
    }

}
