package mastermind.views.console;

import java.util.List;

import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {

	public void interact(PlayController playController) {
		Error error;
		do {
			List<Color> colors = new ProposedCombinationView(playController).read();
			error = playController.addProposedCombination(colors);
			if (error != null) {
				new ErrorView(error).writeln();
			}
		} while (error != null);
	}

}
