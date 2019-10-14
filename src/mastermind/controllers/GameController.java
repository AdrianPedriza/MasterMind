package mastermind.controllers;

import mastermind.models.Session;
import mastermind.types.Color;

import java.util.List;

public abstract class GameController extends AcceptorController{

    GameController(Session session) {
        super(session);
    }

    public abstract int getAttempts();

    public abstract List<Color> getColors(int position);

    public abstract int getBlacks(int position);

    public abstract int getWhites(int position);

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    @Override
    public abstract void accept(ControllersVisitor controllersVisitor);
}