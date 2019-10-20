package views;

import model.Result;
import types.Color;
import utils.IO;

import java.util.List;

public class GameView {

    public void writeAttempts(int currentAttempts, int combinationWidth) {
        if (currentAttempts > 0) {
            new AttemptsView(currentAttempts).writeln();
            new SecretCombinationView(combinationWidth).write();
        }
    }

    public void writeResults(List<List<Color>> allColors, List<List<Integer>> allResults) {
        for (int i = 0; i < allColors.size(); i++) {
            new ProposedCombinationView().write(allColors.get(i));
            new ResultsView().writeln(allResults.get(i));
        }
    }



}
