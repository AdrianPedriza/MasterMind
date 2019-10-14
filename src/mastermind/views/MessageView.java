package mastermind.views;

import mastermind.utils.Console;

public enum MessageView {
	RESULT(" --> #blacks blacks and #whites whites"),
	ATTEMPTS("#attempts attempt(s): "),
	SECRET("*"),
	RESUME("Do you want to continue"),
//	PROPOSED_COMBINATION("Propose a combination: "),
	TITLE("--------- MASTERMIND --------"),
	WINNER("You've won!!! ;-)"),
	LOOSER("You've lost!!! :-("),
	PROPOSE_COMMAND("Propose Combination"),
	NEWGAME_COMMAND("Start a new game"),
	FILE_EXITS_ALREADY("Choose another game"),
	SAVE("Do you want to save the game?"),
	EXIT_COMMAND("Exit game"),
	OPENGAME_COMMAND("Open a saved game"),
	NAME("Name: ");

	private String message;

	private Console console;

	private MessageView(String message) {
		this.message = message;
		this.console = new Console();
	}

	public void writeln(int attempts) {
		this.console.writeln(this.message.replaceAll("#attempts", ""+attempts));
	}

	public void writeln() {
		this.console.writeln(this.message);
	}

	public void writeln(int blacks, int whites){
		this.console.writeln(this.message.replaceAll("#blacks", ""+blacks).replaceAll("#whites", ""+whites));
	}
	
	public String getMessage() {
		return this.message;
	}

}
