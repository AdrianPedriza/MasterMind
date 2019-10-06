package controllers;

import models.*;
import utils.IO;
import views.console.Message;
import views.console.menu.ResultsMenu;

import java.util.List;

public class ProposeCombinationController extends Controller{

    public ProposeCombinationController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

    public void propose() {
        new ResultsMenu(this.game.getProposedCombinations(), this.game.getResultCombinations(),this.game.getSecretCombination()).execute();
        boolean correctPropose;
        String characters;
        ProposedCombination proposedCombination = new ProposedCombination();
        do {
            characters = IO.readString(Message.PROPOSED_COMBINATION);
            correctPropose = proposedCombination.isCorrect(characters);
            if (correctPropose) {
                proposedCombination = new ProposedCombination(characters);
                this.game.addProposedCombination(proposedCombination);
                this.game.addResult(proposedCombination);
            }
        }while (!correctPropose);
        if (this.game.isFinished()) {
            this.state.next();
        }
    }



    public SecretCombination secretCombination() {
        return this.game.getSecretCombination();
    }

    public List<ResultCombination> currentResults() {
        return this.game.getResultCombinations();
    }
}
