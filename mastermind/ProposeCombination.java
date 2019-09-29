package mastermind;

import utils.Color;

public class ProposeCombination extends Combination{


    public ProposeCombination(){
        super();
    }

    public ProposeCombination(String combination){
        super();
        for (int i = 0; i < combination.length(); i++) {
            this.colors[i] = Color.valueOf(combination.substring(i,i+1).toUpperCase());
        }
    }

    public Color[] getColors(){
        return this.colors;
    }

    public String toString(){
        String displayCombination = "";
        for (Color color: this.colors){
            displayCombination += String.valueOf(color);
        }
        return displayCombination;
    }

    public String getValidColors(){
        return this.validColors;
    }
}
