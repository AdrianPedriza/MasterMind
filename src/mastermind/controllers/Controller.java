package mastermind.controllers;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.models.StateValue;

public abstract class Controller {

	protected Session session;

	Controller(Session session) {
		this.session = session;
	}

	public int getWidth() {
		return Combination.getWidth();
	}

	public StateValue getValueState() {
        return this.session.getValueState();
    }
}
