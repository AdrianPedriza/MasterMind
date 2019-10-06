package utils;

import models.Combination;
import models.SecretCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import models.Color;

public class GENERATOR {


    public static ArrayList<Color> random(int combinationSize) {
        ArrayList<Color> colors = new ArrayList<>();
        for(Color color : Color.values()){
            colors.add(color);
        }
        Random random = new Random(System.currentTimeMillis());
        final int erased = colors.size() - combinationSize;
        for (int i = 0; i < erased; i++) {
            colors.remove(random.nextInt(colors.size()));
        }
        Collections.shuffle(colors);
        return colors;
    }
}
