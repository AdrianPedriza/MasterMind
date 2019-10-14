package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;

public class ExitCommand extends Command{

    protected ExitCommand(PlayController playController) {
        super(MessageView.EXIT_COMMAND.getMessage(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).next();
    }

    @Override
    protected boolean isActive() {
        return true;
    }
}
