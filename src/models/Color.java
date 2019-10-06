package models;

public enum Color {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    ORANGE('o'),
    PURPLE('p');

    private char initial;

    Color(char initial) {
        this.initial = initial;
    }

    public static String allInitials() {
        String result = "";
        for(Color color: Color.values()) {
            result += color.initial;
        }
        return result;
    }

    static Color getInstance(int code) {
        assert 0 <= code && code < Color.length();
        return Color.values()[code];
    }

    static Color getInstance(char character) {
        for (Color color : Color.values()) {
            if (color.initial == character) {
                return color;
            }
        }
        return null;
    }

    public String toString() {
        return String.valueOf(this.initial);
    }
    static int length() {
        return Color.values().length;
    }
}