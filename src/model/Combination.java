package model;

import types.Color;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private static final int WIDTH = 4;

    protected List<Color> colors;

    protected Combination (){
        this.colors = new ArrayList<>();
    }

    public static int getWidth() {
        return Combination.WIDTH;
    }
}
