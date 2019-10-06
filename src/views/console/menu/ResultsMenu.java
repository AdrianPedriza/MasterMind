package views.console.menu;

import models.ProposedCombination;
import models.ResultCombination;
import models.SecretCombination;
import utils.IO;
import views.console.Message;

import java.util.List;

public class ResultsMenu {

    private List<ProposedCombination> proposedCombinations;
    private List<ResultCombination> results;
    private SecretCombination secretCombination;

    public ResultsMenu(List<ProposedCombination> proposedCombinations, List<ResultCombination> results, SecretCombination secretCombination) {
        this.proposedCombinations = proposedCombinations;
        this.results = results;
        this.secretCombination = secretCombination;
    }

    public void execute() {
        int numResults = this.results.size();
        if (numResults > 0){
            IO.writeln(String.valueOf(numResults) + " attempts(s): ");
        }
        IO.writeln(secretCombination.toString());
        for (int i = 0; i < proposedCombinations.size(); i++) {
            IO.write(proposedCombinations.get(i).toString());
            IO.write(Message.ARROW);
            IO.writeln(results.get(i).toString());
        }
    }
}
