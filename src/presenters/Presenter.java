package presenters;

import model.Session;

public abstract class Presenter {

    protected Session session;

    public Presenter(Session session) {
        this.session = session;
    }

    public int getWidth() {
        return this.session.getWidth();
    }

    public abstract void control();
}
