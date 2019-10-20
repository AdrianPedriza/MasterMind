package views;

public class AttemptsView {

    private int currentAttempts;

    public AttemptsView(int currentAttempts) {
        this.currentAttempts = currentAttempts;
    }

    void writeln() {
        MessageView.ATTEMPTS.writeln(this.currentAttempts);
    }
}
