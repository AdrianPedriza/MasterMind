import controllers.Controller;
import controllers.Logic;
import views.console.ConsoleView;
import views.View;

public class Mastermind {

    private Logic logic;
    private View view;

    protected Mastermind() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    protected void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            this.view.interact(controller);
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }
}
