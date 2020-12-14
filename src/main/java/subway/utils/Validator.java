package subway.utils;

public class Validator {
    private static final int NAME_MINIMUM_LENGTH = 2;
    public static boolean isValidName(String name){
        return name.length() >= NAME_MINIMUM_LENGTH;
    }
}
