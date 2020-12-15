package subway.domain.menu;

import java.util.Scanner;
import subway.common.ErrorMessage;
import subway.common.ErrorMessageException;

public class MenuInputManager {
    private static final String INPUT_NEEDED = " 중에서 입력해 주세요.";
    private final Scanner scanner;

    public MenuInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainInput() {
        MenuOutputManager.printWhichMenuGuide();
        String inputKey = scanner.nextLine().toUpperCase().trim();
        try {
            checkMainSelection(inputKey);
        } catch (ErrorMessageException error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return inputKey;
    }

    public String getStationInput() {
        MenuOutputManager.printWhichMenuGuide();
        String inputKey = scanner.nextLine().toUpperCase().trim();
        try {
            checkStationSelection(inputKey);
        } catch (ErrorMessageException error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return inputKey;
    }

    public String getLineInput() {
        MenuOutputManager.printWhichMenuGuide();
        String inputKey = scanner.nextLine().toUpperCase().trim();
        try {
            checkLineSelection(inputKey);
        } catch (ErrorMessageException error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return inputKey;
    }

    public String getPathInput() {
        MenuOutputManager.printWhichMenuGuide();
        String inputKey = scanner.nextLine().toUpperCase().trim();
        try {
            checkPathSelection(inputKey);
        } catch (ErrorMessageException error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return inputKey;
    }

    private void checkMainSelection(String input) {
        if (!Menu.MAIN.containsKey(input)) {
            throw new ErrorMessageException(Menu.MAIN.getStringMenuKeys() + INPUT_NEEDED);
        }
    }

    private void checkStationSelection(String input) {
        if (!Menu.STATION.containsKey(input)) {
            throw new ErrorMessageException(Menu.STATION.getStringMenuKeys() + INPUT_NEEDED);
        }
    }

    private void checkLineSelection(String input) {
        if (!Menu.LINE.containsKey(input)) {
            throw new ErrorMessageException(Menu.LINE.getStringMenuKeys() + INPUT_NEEDED);
        }
    }

    private void checkPathSelection(String input) {
        if (!Menu.PATH.containsKey(input)) {
            throw new ErrorMessageException(Menu.PATH.getStringMenuKeys() + INPUT_NEEDED);
        }
    }

}
