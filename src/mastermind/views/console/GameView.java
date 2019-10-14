package mastermind.views.console;

import mastermind.controllers.GameController;

public class GameView {


    GameController gameController;

    public GameView(GameController gameController) {
        this.gameController = gameController;
    }

    public void writeln() {
        for (int i = 0; i < this.gameController.getAttempts(); i++) {
            new ProposedCombinationView(this.gameController).write(i);
            new ResultView(this.gameController).writeln(i);
        }
    }

}
