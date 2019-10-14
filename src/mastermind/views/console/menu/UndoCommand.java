package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.GameView;

public class UndoCommand extends Command {

    public UndoCommand(PlayController playController) {
        super(CommandTitle.UNDO_COMMAND.getTitle(), playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).undo();
    }

    @Override
    protected boolean isActive() {
        return ((PlayController) this.acceptorController).undoable();
    }
}
