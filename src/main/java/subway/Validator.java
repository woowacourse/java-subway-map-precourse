package subway;

public class Validator {
    private static final int MINIMUM_LEGNTH = 2;

    public static boolean isAppropriateLength(String name) {
        if (name.length() < MINIMUM_LEGNTH) {
            System.out.println("[ERROR] 이름은 2글자 이상이여야 한다.\n");
            return false;
        }
        return true;
    }
}
