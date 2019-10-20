package views;

import utils.IO;

public enum MessageView {
    NEW_LINE(""),
    SECRET("*"),
    RESUME("Do you want to continue"),
    RESULT(" --> #blacks blacks and #whites whites"),
    PROPOSE("Propose Combination: "),
    ATTEMPTS("#attempts attempt(s): "),
    LOOSER("You've lost!!! :-("),
    WINNER("You've won!!! ;-)"),
    TITLE("--------- MASTERMIND --------");

    private String message;

    MessageView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    void writeln(int attempts) {
        IO.writeln(this.message.replaceAll("#attempts", ""+attempts));
    }

    void writeln(int blacks, int whites) {
        IO.writeln(this.message.replaceAll("#blacks", ""+blacks).replaceAll("#whites", ""+whites));
    }

}
