package mastermind.views.console;

import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;
import mastermind.views.console.menu.StartMenu;

class StartView extends WithConsoleView {
	
	private SecretCombinationView secretCombinationView;
	
	void interact(StartController startController) {
		this.console.writeln(MessageView.TITLE.getMessage());
		new StartMenu(startController).execute();
		new AttemptsView(startController).writeln();
		this.secretCombinationView = new SecretCombinationView(startController);
		this.secretCombinationView.writeln();
		new GameView(startController).writeln();
		if (startController.isWinner()) {
			MessageView.WINNER.writeln();
		} else if (startController.isLooser()) {
			MessageView.LOOSER.writeln();
		}
	}

}
