package views;

import types.Color;
import utils.IO;

import java.util.ArrayList;
import java.util.List;

public class ProposalView {

    public void write(String gameMessage) {
        IO.writeln(gameMessage);
    }

    public List<Color> read() {
        String characters = IO.readString(MessageView.PROPOSE.getMessage());
        List<Color> colors = new ArrayList<>();
        for (int i=0; i<characters.length(); i++) {
            colors.add(ColorView.getInstance(characters.charAt(i)));
        }
        return colors;
    }
}
