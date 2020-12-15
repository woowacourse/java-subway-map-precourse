package subway.view;

import java.util.Scanner;
import subway.util.FeatureGroup;

public class InputView {
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.\n";
    private static final String INVALID_LENGTH = "[ERROR] 이름은 2글자 이상이어야 합니다.\n";
    private static final String NEGATIVE_NUMBER_ERROR = "[ERROR] 순서는 자연수여야 합니다.\n";
    private static final String BLANK_ERROR = "[ERROR] 빈 칸을 포함하면 안됩니다.\n";
    private static final String INTEGER_ERROR = "[ERROR] 정수를 입력해주세요.\n";
    private static final String NEW_LINE = "";
    private static final String BLANK = " ";
    private static final int LENGTH = 2;
    private static final int ZERO = 0;


    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getScreenCommand(String screen, String message) {
        try {
            OutputView.print(message);
            String command = scanner.nextLine();
            OutputView.print(NEW_LINE);
            validateScreenCommand(screen, command);
            return command;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getScreenCommand(screen, message);
        }
    }

    public String getName(String message) {
        try {
            OutputView.print(message);
            String name = scanner.nextLine();
            OutputView.print(NEW_LINE);
            validateLength(name);
            validateBlank(name);
            return name;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getName(message);
        }
    }

    private void validateBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }

    public int getSequence(String message) {
        try {
            OutputView.print(message);
            String stringNumber = scanner.nextLine();
            OutputView.print(NEW_LINE);
            int number = convertToInt(stringNumber);
            validateNonPositiveNumber(number);
            return number;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getSequence(message);
        }
    }

    private int convertToInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e){
            throw new NumberFormatException(INTEGER_ERROR);
        }
    }

    private void validateScreenCommand(String screen, String command) {
        FeatureGroup specificScreen = FeatureGroup.valueOf(screen);
        if (!specificScreen.hasFeature(command)) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void validateLength(String name) {
        if (name.length() < LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH);
        }
    }

    private void validateNonPositiveNumber(int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }
}
