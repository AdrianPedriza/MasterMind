package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.SessionImplementation;

public abstract class StartController extends GameController {

    public StartController(Session session) {
        super(session);
    }

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public void start() {
        ((SessionImplementation) this.session).next();
	}

	public abstract void start(String title);

	public abstract String[] getGamesNames();

}
