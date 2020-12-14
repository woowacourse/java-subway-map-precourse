package subway.view;

import java.util.Scanner;

import subway.validator.Validator;
import subway.validator.ValidatorPool;

public final class InputView {

    public static final String VIEW_PREFIX = "##";

    private static final String FUNCTION_IDENTIFIER_QUESTION = "원하는 기능을 선택하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String inputFunctionIdentifier() {
        return input(FUNCTION_IDENTIFIER_QUESTION, Validator.class);
    }

    public static String inputStation() {
        return InputStationView.inputStation();
    }

    public static String inputStartStation() {
        return InputStationView.inputStartStation();
    }

    public static String inputFinalStation() {
        return InputStationView.inputFinalStation();
    }

    public static String inputRemoveStation() {
        return InputStationView.inputRemoveStation();
    }

    public static String inputStationOfSectionToRemove() {
        return InputStationView.inputStationOfSectionToRemove();
    }

    public static String inputLineName() {
        return InputLineView.inputLineName();
    }

    public static String inputRemoveLineName() {
        return InputLineView.inputRemoveLineName();
    }

    public static String inputLineNameOfSectionToRemove() {
        return InputLineView.inputLineNameOfSectionToRemove();
    }


    public static int inputIndex() {
        return InputIndexView.inputIndex();
    }

    public static String input(final String message,
                               final Class<? extends Validator> validatorClass) {
        printQuestionAddedPrefix(message);

        String input = scanner.nextLine();
        System.out.println();

        while (!isValid(input, validatorClass)) {
            input = scanner.nextLine();
            System.out.println();
        }

        return input;
    }

    public static boolean isValid(final String input,
                                  final Class<? extends Validator> validatorClass) {
        final Validator validator = ValidatorPool.getValidator(validatorClass);

        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private static void printQuestionAddedPrefix(final String message) {
        System.out.printf(ViewFormat.MESSAGE_FORMAT, VIEW_PREFIX, message);
    }
}
