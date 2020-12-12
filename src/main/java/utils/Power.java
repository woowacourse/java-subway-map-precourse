package utils;

public class Power {

    private static boolean power;

    public static boolean isOn() {
        return power;
    }

    public static void on() {
        power = true;
    }

    public static void off() {
        power = false;
    }
}
