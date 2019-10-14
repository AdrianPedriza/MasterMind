package mastermind.models;

import mastermind.types.Color;
import mastermind.utils.Registry;

import java.util.List;

public interface Session {

    StateValue getValueState();

    int getWidth();
}

