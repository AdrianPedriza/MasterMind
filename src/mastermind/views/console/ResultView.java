package mastermind.views.console;

import mastermind.controllers.GameController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.views.MessageView;
import mastermind.utils.WithConsoleView;

class ResultView extends WithConsoleView {

	private GameController gameController;

	ResultView(GameController gameController){
		this.gameController = gameController;
	}

	void writeln(int position) {
		MessageView.RESULT.writeln(this.gameController.getBlacks(position), this.gameController.getWhites(position));
	}

}
