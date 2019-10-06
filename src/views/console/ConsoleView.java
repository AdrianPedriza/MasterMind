package views.console;

import controllers.Controller;
import controllers.ProposeCombinationController;
import controllers.ResumeController;
import controllers.StartController;
import utils.YesNoDialog;
import views.View;
import views.console.menu.ResultsMenu;

public class ConsoleView extends View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
    }

    @Override
    public void visit(ProposeCombinationController proposeCombinationController) {
        proposeCombinationController.propose();
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME));
    }
}
