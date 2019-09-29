package utils;

public enum Color {
    R,B,Y,G,O,P;

    public static String getAvailableBalls(){
        String availableBalls = "";
        for (Color ball: Color.values()){
            availableBalls += ball.toString().toLowerCase();
        }
        return availableBalls;
    }
}
