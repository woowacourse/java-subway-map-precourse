package utils;

public class ErrorUtils {
    private static final String FORMAT = "\n[ERROR] %s";

    public static void printError(Object arg) {
        System.out.println(String.format(FORMAT, arg));
    }

}
