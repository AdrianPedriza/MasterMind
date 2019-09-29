package mastermind;

import utils.Color;

public class CodeMaker {


    private SecretCombination secretCombination;

    public CodeMaker(){
        this.secretCombination = new SecretCombination();
    }

    public String showSecretCombination(){
        return this.secretCombination.toString();
    }

    public boolean isValidAttempt(Attempt attempt){
        return (attempt.getBlacks() == this.secretCombination.getNumBalls());
    }

    public Attempt createAttempt(CodeBreaker codeBreaker){
        int blacks = 0;
        int whites = 0;
        ProposeCombination codeBreakerCombination = codeBreaker.getProposeCombination();
        for (int i = 0; i < codeBreakerCombination.getColors().length; i++) {
            Color nColorCodeMaker = this.secretCombination.getColors()[i];
            Color nColorCodeBreaker = codeBreakerCombination.getColors()[i];
            if (nColorCodeMaker.equals(nColorCodeBreaker)){
                blacks += 1;
            }else if(this.secretCombination.contains(nColorCodeBreaker)){
                whites += 1;
            }
        }
        return new Attempt(codeBreakerCombination, blacks, whites);
    }
}
