package views;

import java.util.List;

public class ResultsView {

    void writeln(List<Integer> results) {
        MessageView.RESULT.writeln(results.get(0), results.get(1));
    }

}
