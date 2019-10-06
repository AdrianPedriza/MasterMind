package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IO {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
            System.in));

    public static String readString(String title) {
        String input = null;
        boolean ok = false;
        do {
            write(title);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                writeFormatError("de cadena de caracteres");
            }
        } while (!ok);
        return input;
    }


    public static char readChar(String title) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = readString(title);
            if (input.length() != 1) {
                writeFormatError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while (!ok);
        return charValue;
    }

    public static void write(String string) {
        System.out.print(string);
    }

    public static void writeln(String string) {
        System.out.println(string);
    }

    public static void writeln() {
        System.out.println();
    }

    private static void writeFormatError(String formato) {
        System.out.println("ERROR DE FORMATO! "
                + "Introduzca un valor con formato " + formato + ".");
    }
}