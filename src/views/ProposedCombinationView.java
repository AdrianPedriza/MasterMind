package views;

import types.Color;
import utils.IO;

import java.util.List;

public class ProposedCombinationView {

    void write(List<Color> colors) {
        for (Color color: colors) {
            new ColorView(color).write();
        }
    }

}
