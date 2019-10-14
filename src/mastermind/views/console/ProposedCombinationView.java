package mastermind.views.console;

import java.util.ArrayList;
import java.util.List;

import mastermind.controllers.GameController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.types.Color;
import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;
import mastermind.views.console.menu.CommandTitle;

public class ProposedCombinationView extends WithConsoleView {

	private GameController gameController;

	public ProposedCombinationView(GameController gameController) {
		this.gameController = gameController;
	}
	
	void write(int position) {
		for (Color color : this.gameController.getColors(position)) {
			new ColorView(color).write();
		}
	}

	public List<Color> read() {
		String characters = this.console.readString(CommandTitle.PROPOSE_COMMAND.getTitle());
		List<Color> colors = new ArrayList();
		for (int i=0; i<characters.length(); i++) {
			colors.add(ColorView.getInstance(characters.charAt(i)));
		}
		return colors;
	}
	
}
