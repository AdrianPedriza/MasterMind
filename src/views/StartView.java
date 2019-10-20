package views;

import utils.IO;

public class StartView {

    public StartView(){}

    public void write() {
        IO.writeln(MessageView.TITLE.getMessage());
    }
}
