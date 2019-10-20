package model;

import types.Color;

import java.util.List;

public class ProposedCombination extends Combination{

    public ProposedCombination(List<Color> colors) {
        this.colors = colors;
    }

    boolean contains(Color color) {
        for (int i = 0; i < this.colors.size(); i++) {
            if (this.colors.get(i) == color) {
                return true;
            }
        }
        return false;
    }

    boolean contains(Color color, int position) {
        return this.colors.get(position) == color;
    }

    public List<Color> getColors() {
        return this.colors;
    }

}
