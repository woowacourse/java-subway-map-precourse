package subway.view;

import subway.exception.NoneInputException;
import java.util.Scanner;

public class InputView {
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static String getStringWithMessage(String requestMessage) {
        try {
            OutputView.printWithSharpPrefix(requestMessage);
            String string = deleteWhiteSpaces(scanner.nextLine());
            isNotEmptyStringOrThrowException(string);
            OutputView.newLine();
            return string;
        }catch (RuntimeException e) {
            OutputView.printErrorMessage(e);
            return getStringWithMessage(requestMessage);
        }
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private static boolean isNotEmptyStringOrThrowException(String string) {
        if (string.equals("")) {
            throw new NoneInputException(ERROR_NONE_INPUT_VALUE);
        }
        return true;
    }

}
