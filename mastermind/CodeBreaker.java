package mastermind;

import exception.RepeatedColors;
import exception.WrongCombinationColors;
import exception.WrongCombinationLength;

import java.util.Scanner;

public class CodeBreaker {

    private ProposeCombination proposeCombination;

    public CodeBreaker(){
        this.proposeCombination = new ProposeCombination();
    }

    public void proposeCombination(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Propose a combination: ");
            String possibleCombination = sc.nextLine();
            validateCombination(possibleCombination);
            this.proposeCombination = new ProposeCombination(possibleCombination);
        }catch (WrongCombinationLength | WrongCombinationColors | RepeatedColors ex){
            System.out.println(ex.getLocalizedMessage());
            proposeCombination();
        }
    }


    public ProposeCombination getProposeCombination(){
        return this.proposeCombination;
    }

    public void validateCombination(String possibleCombination) throws WrongCombinationColors, WrongCombinationLength, RepeatedColors {
        if (possibleCombination.length() != this.proposeCombination.NUM_COLORS){
            throw new WrongCombinationLength("Wrong proposed combination length");
        }else if (hasWrongColors(possibleCombination)){
            throw new WrongCombinationColors("Wrong colors, they must be: "+this.proposeCombination.getValidColors());
        }else if (containsRepeatedColors(possibleCombination)){
            throw new RepeatedColors("Repeated colors");
        }
    }

    public boolean containsRepeatedColors(String colorsCombination){
        boolean repeated = false;
        for (char c : colorsCombination.toCharArray()){
            if (isLetterRepeated(c, colorsCombination)){
                repeated = true;
                break;
            }
        }
        return repeated;
    }

    public boolean isLetterRepeated(char letter, String text){
        return text.replaceFirst(String.valueOf(letter),"").indexOf(letter) != -1;
    }

    public boolean hasWrongColors(String colorsCombination){
        boolean wrongColors = false;
        for(char letter: colorsCombination.toCharArray()){
            if (this.proposeCombination.getValidColors().indexOf(letter) == -1){
                wrongColors = true;
                break;
            }
        }
        return wrongColors;
    }

}
