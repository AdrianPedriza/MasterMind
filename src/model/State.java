package model;

public class State {

    private StateValue stateValue;

    public State() {
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getStateValue() {
        return this.stateValue;
    }

    public void next() {
        this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
    }
}