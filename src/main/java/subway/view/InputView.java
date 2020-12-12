package subway.view;

import subway.view.selection.Selection;
import subway.view.selection.Selections;

import java.util.Scanner;

public class InputView {
    private static final String ERROR_NONE_INPUT_VALUE = "입력값이 없습니다.";
    private static final String MENU_SELECTION = "원하는 기능을 선택하세요.";

    private static Scanner scanner;

    public static void setScanner(Scanner scanner) {
        InputView.scanner = scanner;
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
        try{
            String input = getStringWithMessage(MENU_SELECTION);
            newLine();
            return selections.searchByValue(input);
        } catch (Exception e) {
            OutputView.showErrorMessage(e);
            return getSelection(selections);
        }
    }

    public static String getStringWithMessage(String requestMessage) {
        try {
            OutputView.printWithSharpPrefix(requestMessage);
            String string = deleteWhiteSpaces(scanner.nextLine());
            isNotEmptyStringOrThrowException(string);
            newLine();
            return string;
        }catch (Exception e) {
            OutputView.showErrorMessage(e);
            return getStringWithMessage(requestMessage);
        }
    }

    private static void newLine() {
        System.out.println();
    }
}
