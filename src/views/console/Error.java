package views.console;

import models.Color;

public class Error {
    public static final String DUPLICATED = "Repeated colors";
    public static final String WRONG_CHARACTERS = "Wrong colors, they must be: " + Color.allInitials();
    public static final String WRONG_LENGTH = "Wrong proposed combination length";

    private String message;

    private Error(String message) {
        this.message = message;
    }
}
