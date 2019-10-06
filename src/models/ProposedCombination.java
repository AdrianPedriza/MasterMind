package models;

import utils.IO;
import views.console.Error;
import views.console.Message;

public class ProposedCombination extends Combination{

    public ProposedCombination(String characters) {
        for (int i = 0; i < characters.length() ; i++) {
            Color color = Color.getInstance(characters.charAt(i));
            this.colors.add(color);
        }
    }

    public ProposedCombination() {
        super();
    }

    public String toString() {
        String result = "";
        for (Color color : this.colors) {
            result += color.toString();
        }
        return result;
    }

    public boolean contains(Color color, int position) {
        return this.colors.get(position) == color;
    }

    boolean contains(Color color) {
        for (int i = 0; i < this.colors.size(); i++) {
            if (this.colors.get(i) == color) {
                return true;
            }
        }
        return false;
    }

    public boolean isCorrect(String characters) {
        if (characters.length() != Combination.getWidth()) {
            IO.writeln(Error.WRONG_LENGTH);
            return false;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Color color = Color.getInstance(characters.charAt(i));
                if (color == null) {
                    IO.writeln(Error.WRONG_CHARACTERS);
                    return false;
                } else {
                    for(int j=0; j< this.colors.size(); j++){
                        if (color == this.colors.get(j)){
                            IO.writeln(Error.DUPLICATED);
                            return false;
                        }
                    }
                    this.colors.add(color);
                }
            }
        }
        return true;
    }
}
