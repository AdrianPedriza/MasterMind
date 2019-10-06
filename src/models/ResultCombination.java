package models;

public class ResultCombination {

    private int blacks = 0;

    private int whites = 0;

    ResultCombination(int blacks, int whites) {
        assert blacks >= 0;
        assert whites >= 0;
        this.blacks = blacks;
        this.whites = whites;
    }

    boolean isWinner() {
        return this.blacks == Combination.getWidth();
    }

    public String toString(){
        return String.valueOf(this.blacks)+" blacks "+String.valueOf(this.whites)+" whites";
    }
}
