package subway.view;

import java.util.Scanner;
import java.util.zip.ZipError;
import subway.util.FeatureGroup;

public class InputView {
    private static final String INVALID_INPUT = "[ERROR] 선택할 수 없는 기능입니다.\n";
    private static final String INVALID_LENGTH = "[ERROR] 이름은 2글자 이상이어야 한다.\n";
    private static final String NEGATIVE_NUMBER_ERROR = "[ERROR] 순서는 음수가 될 수 없습니다.\n";
    private static final String NEW_LINE = "";
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
            return name;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getName(message);
        }
    }

    public int getSequence(String message) {
        try {
            OutputView.print(message);
            int number = scanner.nextInt();
            scanner.nextLine();
            OutputView.print(NEW_LINE);
            validateNegativeNumber(number);
            return number;
        } catch (Exception e) {
            OutputView.print(e.getMessage());
            return getSequence(message);
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

    private void validateNegativeNumber(int number) {
        if (number > ZERO) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
    }
}
