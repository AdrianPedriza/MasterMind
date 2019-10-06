package views.console;

import controllers.Controller;
import utils.IO;

public class GameView {

    private final Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void writeln() {
        IO.writeln();
        IO.writeln(Message.GAME_TITLE);
    }


}
