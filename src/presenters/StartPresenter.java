package presenters;

import model.Session;
import views.SecretCombinationView;
import views.StartView;

public class StartPresenter extends Presenter{

    public StartPresenter(Session session){
        super(session);
    }

    public void control() {
        new StartView().write();
        new SecretCombinationView(this.getWidth()).write();
        this.session.next();
    }
}
