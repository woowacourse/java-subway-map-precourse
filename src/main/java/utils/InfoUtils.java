package utils;

public class InfoUtils {
    private static final String FORMAT = "[INFO] %s";

    public static void printInfo(Object arg) {
        System.out.println(String.format(FORMAT, arg));
    }
}
