package models;

import utils.GENERATOR;
import views.console.Message;

public class SecretCombination extends Combination{


    public SecretCombination() {
        this.colors = GENERATOR.random(getWidth());
    }

    public String toString() {
        String encryptedCombination = "";
        for (int i = 0; i < this.colors.size(); i++) {
            encryptedCombination += Message.SECRET;
        }
        return encryptedCombination;
    }

    public ResultCombination getResult(ProposedCombination proposedCombination) {
        int blacks = 0;
        for (int i=0; i<this.colors.size(); i++) {
            if (proposedCombination.contains(this.colors.get(i), i)) {
                blacks++;
            }
        }
        int whites = 0;
        for (Color color : this.colors) {
            if (proposedCombination.contains(color)) {
                whites++;
            }
        }
        return new ResultCombination(blacks, whites - blacks);
    }
}
