package mastermind.views.console.menu;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.PlayController;

public abstract class Command extends mastermind.utils.Command {
    protected AcceptorController acceptorController;

    protected Command(String title, AcceptorController acceptorController) {
        super(title);
        this.acceptorController = acceptorController;
    }
}
