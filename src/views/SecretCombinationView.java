package views;

import utils.IO;

public class SecretCombinationView {

    private int secretCombinationWidth;

    public SecretCombinationView(int secretCombinationWidth){
        this.secretCombinationWidth = secretCombinationWidth;
    }

    public void write() {
        for (int i = 0; i < this.secretCombinationWidth; i++) {
            IO.write(MessageView.SECRET.getMessage());
        }
        IO.writeln(MessageView.NEW_LINE.getMessage());

    }
}
