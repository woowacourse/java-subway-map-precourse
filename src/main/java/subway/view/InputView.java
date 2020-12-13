package subway.view;

import java.util.Scanner;

import subway.validator.IndexValidator;
import subway.validator.LineNameValidator;
import subway.validator.StationNameValidator;
import subway.validator.Validator;
import subway.validator.ValidatorPool;

public class InputView {

    public static final String VIEW_PREFIX = "##";

    private static final String FUNCTION_IDENTIFIER_QUESTION = "원하는 기능을 선택하세요.";

    public static final String STATION_NAME_QUESTION = "등록할 역 이름을 입력하세요.";

    private static final String LINE_NAME_QUESTION = "등록할 노선 이름을 입력하세요.";

    private static final String STATION_QUESTION = "순서를 입력하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String inputFunctionIdentifier() {
        return input(FUNCTION_IDENTIFIER_QUESTION, Validator.class);
    }

    public static String inputStationName() {
        String stationName = input(STATION_NAME_QUESTION, StationNameValidator.class);

        if (!stationName.endsWith(StationNameValidator.STATION_SUFFIX)) {
            stationName += StationNameValidator.STATION_SUFFIX;
        }

        return stationName;
    }

    public static String inputLineName() {
        String lineName = input(LINE_NAME_QUESTION, LineNameValidator.class);

        if (!lineName.endsWith(LineNameValidator.LINE_SUFFIX)) {
            lineName += LineNameValidator.LINE_SUFFIX;
        }

        return lineName;
    }

    public static int inputIndex() {
        return Integer.parseInt(input(STATION_QUESTION, IndexValidator.class));
    }

    private static String input(String message, Class<? extends Validator> validatorClass) {
        printQuestionAddedPrefix(message);

        String input = scanner.nextLine();

        while (!isValid(input, validatorClass)) {
            input = scanner.nextLine();
        }

        return input;
    }

    private static boolean isValid(String input, Class<? extends Validator> validatorClass) {
        Validator validator = ValidatorPool.getValidator(validatorClass);

        try {
            validator.validate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private static void printQuestionAddedPrefix(String message) {
        System.out.printf("%s %s", VIEW_PREFIX, message);
    }
}
