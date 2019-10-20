import model.Session;
import model.StateValue;
import presenters.Presenter;
import presenters.ProposalPresenter;
import presenters.ResumePresenter;
import presenters.StartPresenter;

import java.util.HashMap;
import java.util.Map;

public class Mastermind {

    private Session session;
    private Map<StateValue, Presenter> presenter;

    public Mastermind() {
        this.session = new Session();
        this.presenter = new HashMap<>();
        this.presenter.put(StateValue.INITIAL, new StartPresenter(this.session));
        this.presenter.put(StateValue.IN_GAME, new ProposalPresenter(this.session));
        this.presenter.put(StateValue.FINAL, new ResumePresenter(this.session));
        this.presenter.put(StateValue.EXIT, null);
    }

    public void play() {
        Presenter presenter;
        do {
            presenter  = this.presenter.get(this.session.getValue());
            if (presenter != null) {
                presenter.control();
            }
        } while(presenter != null);
    }

    public static void main(String[] args){
        new Mastermind().play();
    }

}
