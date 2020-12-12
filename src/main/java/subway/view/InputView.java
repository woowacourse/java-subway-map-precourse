package subway.view;

import java.util.Scanner;

import subway.validator.StationNameValidator;
import subway.validator.Validator;
import subway.validator.ValidatorPool;

public class InputView {

    public static final String VIEW_PREFIX = "##";

    public static final String STATION_NAME_QUESTION = "등록할 역 이름을 입력하세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputStationName() {
        return input(STATION_NAME_QUESTION, StationNameValidator.class);
    }

    private String input(String message, Class<? extends Validator> validatorClass) {
        printQuestionAddedPrefix(message);

        String input = scanner.nextLine();

        while (!isValid(input, validatorClass)) {
            input = scanner.nextLine();
        }

        return input;
    }

    private boolean isValid(String input, Class<? extends Validator> validatorClass) {
        Validator validator = ValidatorPool.getValidator(validatorClass);

        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void printQuestionAddedPrefix(String message) {
        System.out.printf("%s %s", VIEW_PREFIX, message);
    }
}
