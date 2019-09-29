package mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterMind {

    private boolean isWinner;
    private List<Attempt> attempts;
    private CodeMaker codeMaker;
    private CodeBreaker codeBreaker;

    public MasterMind(){
        this.isWinner = false;
        this.attempts = new ArrayList<>();
        this.codeMaker = new CodeMaker();
        this.codeBreaker = new CodeBreaker();
    }

    public void play(){
        System.out.println("---- MASTERMIND ----");
        do{
            manageGame();
        }while(!isFinished() && !this.isWinner);
        if (repeatAnotherGame()){
            play();
        }
    }

    private void manageGame(){
        displayCurrentGameInformation();
        checkLastAttempt();
        if (!this.isWinner){
            this.codeBreaker.proposeCombination();
            addResult();
        }
    }

    private boolean isFinished(){
        boolean isFinished = false;
        int maxAttempts = 10;
        if (this.attempts.size() > maxAttempts) {
            isFinished = true;
        }
        return isFinished;
    }

    private boolean repeatAnotherGame(){
        boolean repeatPlay = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to continue? (s/n): ");
        if (sc.nextLine().equals("s")) {
            this.isWinner = false;
            this.codeMaker = new CodeMaker();
            this.attempts = new ArrayList<>();
            repeatPlay = true;
        }
        return repeatPlay;
    }

    private void addResult(){
        Attempt attempt = this.codeMaker.createAttempt(this.codeBreaker);
        this.attempts.add(attempt);
    }

    private void displayCurrentGameInformation(){
        if (this.attempts.isEmpty()) {
            System.out.println(this.codeMaker.showSecretCombination());
        }else{
            String numCurrentAttempt = String.valueOf(this.attempts.size());
            System.out.println(numCurrentAttempt + " attempt(s):");
            System.out.println(this.codeMaker.showSecretCombination());
            for (Attempt attempt: this.attempts){
                System.out.println(attempt);
            }
        }
    }

    private void checkLastAttempt(){
        Attempt lastAttempt = getLastAttempt();
        if(lastAttempt!= null && this.codeMaker.isValidAttempt(lastAttempt)){
            System.out.println("You've won!!! ;-)");
            this.isWinner = true;
        }
    }

    private Attempt getLastAttempt(){
        Attempt lastAttempt;
        if (this.attempts.size() != 0){
            lastAttempt = this.attempts.get(this.attempts.size()-1);
        }else{
            lastAttempt = null;
        }
        return lastAttempt;
    }
}
