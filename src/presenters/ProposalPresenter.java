package presenters;

import model.Session;
import types.Color;
import types.Error;
import views.*;

import java.util.List;

public class ProposalPresenter extends Presenter{

    public ProposalPresenter(Session session){
        super(session);
    }

    public void control() {
        new GameView().writeAttempts(this.session.getAttempts(), this.session.getWidth());
        new GameView().writeResults(this.session.getLastCombintions(), this.session.getLastResults());
        proposeCombination();
        if (this.session.isLooser()) {
            new ProposalView().write(MessageView.LOOSER.getMessage());
            this.session.next();
        }else if (this.session.isWinner()) {
            new ProposalView().write(MessageView.WINNER.getMessage());
            this.session.next();
        }
    }

    private void proposeCombination() {
        Error error;
        do {
            List<Color> colors = new ProposalView().read();
            error = addProposedCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
    }

    private Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != this.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i+1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        if (error == null){
            this.session.addProposedCombination(colors);
        }
        return error;
    }
}
