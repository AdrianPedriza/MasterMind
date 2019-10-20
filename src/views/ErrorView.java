package views;

import types.Error;
import utils.IO;

public class ErrorView {

    public static final String[] MESSAGES = {
            "Repeated colors",
            "Wrong colors, they must be: " + ColorView.allInitials(),
            "Wrong proposed combination length" };

    private Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public void writeln() {
        IO.writeln(ErrorView.MESSAGES[this.error.ordinal()]);
    }
}
