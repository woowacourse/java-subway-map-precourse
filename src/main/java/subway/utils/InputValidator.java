package subway.utils;

public class InputValidator {

    private static final String MENU_SELECTION_ERROR = "[ERROR] 선택할 수 없는 기능입나다.";

    private InputValidator() {}

    public static void validateMenuInput(String input, int range) {
        validateIntegerAndInRange(input, range);
    }

    private static void validateIntegerAndInRange(String input, int range) {
        try {
            int integerInput = Integer.parseInt(input);
            if (integerInput <= 0 || integerInput > range) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(MENU_SELECTION_ERROR);
        }
    }
}
