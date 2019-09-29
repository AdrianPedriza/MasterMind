package mastermind;

import utils.Color;

import java.util.Random;

public class SecretCombination extends Combination{

    private Color[] colors;

    public SecretCombination(){
        this.colors = generateSecretCombination();
    }

    public int getNumBalls(){
        return NUM_COLORS;
    }

    public Color[] getColors(){
        return this.colors;
    }

    public String toString(){
        StringBuilder encriptedCombination = new StringBuilder();
        for (int i = 0; i < this.colors.length; i++) {
            encriptedCombination.append("*");
        }
        return encriptedCombination.toString();
    }

    private Color[] generateSecretCombination(){
        Color[] secretCombination = new Color[NUM_COLORS];
        for (int i = 0; i < NUM_COLORS; i++) {
            Color color = generateRandomColor(secretCombination);
            secretCombination[i] = color;
        }
        return secretCombination;
    }

    private Color generateRandomColor(Color[] colors){
        Random rnd = new Random();
        String validBalls = this.validColors.toUpperCase();
        Color color;
        do{
            char c = validBalls.charAt(rnd.nextInt(validBalls.length()));
            color = Color.valueOf(String.valueOf(c));
        }while(isContained(color, colors));
        return color;
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
