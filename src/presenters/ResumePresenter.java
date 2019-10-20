package presenters;

import model.Session;
import views.ResumeView;

public class ResumePresenter extends Presenter{

    public ResumePresenter(Session session){
        super(session);
    }

    public void control() {
        boolean resetGame = new ResumeView().write();
        if (resetGame) {
            this.session.resetGame();
        } else {
            this.session.next();
        }
    }
}
