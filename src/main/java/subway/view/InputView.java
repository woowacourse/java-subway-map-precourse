package subway.view;

import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.Scanner;

public class InputView {
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";
    private static final String SHARP_PREFIX = "## ";
    private static final String MENU_SELECTION = "원하는 기능을 선택하세요.";

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
    }

    public static void showSelectionMessage() {
        System.out.println(SHARP_PREFIX + MENU_SELECTION);
    }

    private static String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private static boolean isNotEmptyStringOrThrowException(String string) {
        if (string.equals("")) {
            throw new IllegalArgumentException(ERROR_NONE_INPUT_VALUE);
        }
        return true;
    }

    public static Selection getSelection(Selections selections) {
        showSelectionMessage();
        try {
            String string = deleteWhiteSpaces(scanner.nextLine());
            isNotEmptyStringOrThrowException(string);
            return selections.searchByValue(string);
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getSelection(selections);
        }
    }

    public static String getNameWithMessage(String requestMessage) {
        System.out.println(requestMessage);
        try {
            String name = deleteWhiteSpaces(scanner.nextLine());
            newLine();
            isNotEmptyStringOrThrowException(name);
            return name;
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e);
            return getNameWithMessage(requestMessage);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
