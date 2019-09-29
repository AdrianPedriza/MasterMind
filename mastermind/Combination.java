package mastermind;

import utils.Color;

import java.util.Arrays;

public class Combination {

    protected static final int NUM_COLORS = 4;
    protected Color[] colors;
    protected String validColors;

    public Combination(){
        this.validColors = Color.getAvailableBalls();
        this.colors = new Color[NUM_COLORS];
    }

    public Color[] getColors(){
        return this.colors;
    }

    public boolean contains(Color externalColor){
        Color[] colors = this.getColors();
        return isContained(externalColor, colors);
    }

    public boolean equals(Object o){
        boolean areEquals = true;
        if (this.getClass() != o.getClass())
            return false;
        Combination combination = (Combination) o;
        for (int i = 0; i < NUM_COLORS; i++) {
            if(!Arrays.equals(this.colors, combination.colors)){
                areEquals = false;
                break;
            }
        }
        return areEquals;
    }

    public boolean isContained(Color color, Color[] colors){
        boolean isContained = false;
        for (Color c: colors){
            if (c!=null && c.equals(color)){
                isContained = true;
                break;
            }
        }
        return isContained;
    }

}
