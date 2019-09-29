package mastermind;

public class Attempt {

    private ProposeCombination proposeCombination;
    private int blacks;
    private int whites;

    public Attempt(ProposeCombination proposeCombination, int blacks, int whites){
        this.proposeCombination = proposeCombination;
        this.blacks = blacks;
        this.whites = whites;
    }

    public String toString(){
        String combination = this.proposeCombination.toString().toLowerCase();
        String numBlacks = String.valueOf(this.blacks);
        String numWhites = String.valueOf(this.whites);
        return combination+ " --> " + numBlacks + " blacks and " + numWhites + " whites";
    }

    public int getBlacks(){
        return this.blacks;
    }
}
