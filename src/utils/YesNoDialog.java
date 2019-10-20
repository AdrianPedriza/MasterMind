package utils;

public class YesNoDialog {
    private static final char AFIRMATIVE = 'y';

    private static final char NEGATIVE = 'n';

    private static final String QUESTION = "? ("+YesNoDialog.AFIRMATIVE+"/"+YesNoDialog.NEGATIVE+"): ";

    private static final String MESSAGE = "El valor debe ser '" + YesNoDialog.AFIRMATIVE + "' ó '"
            + YesNoDialog.NEGATIVE + "'";

    public boolean read(String title) {
        assert title != null;
        char answer;
        boolean ok;
        do {
            answer = IO.readChar(title + YesNoDialog.QUESTION);
            ok = YesNoDialog.isAfirmative(answer) || YesNoDialog.isNegative(answer);
            if (!ok) {
                IO.writeln(YesNoDialog.MESSAGE);
            }
        } while (!ok);
        return YesNoDialog.isAfirmative(answer);
    }

    private static boolean isAfirmative(char answer) {
        return Character.toLowerCase(answer) == YesNoDialog.AFIRMATIVE;
    }

    private static boolean isNegative(char answer) {
        return Character.toLowerCase(answer) == YesNoDialog.NEGATIVE;
    }
}
