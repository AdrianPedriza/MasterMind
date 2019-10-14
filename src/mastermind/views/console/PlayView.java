package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;
import mastermind.views.console.menu.PlayMenu;

public class PlayView extends WithConsoleView {

    void interact(PlayController playController) {
        new PlayMenu(playController).execute();
        new AttemptsView(playController).writeln();
        new SecretCombinationView(playController).writeln();
        new GameView(playController).writeln();
        if (playController.isWinner()) {
            MessageView.WINNER.writeln();
        } else if (playController.isLooser()) {
            MessageView.LOOSER.writeln();
        }
    }
}
