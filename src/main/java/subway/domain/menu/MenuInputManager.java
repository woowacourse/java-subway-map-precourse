package subway.domain.menu;

import java.util.Scanner;
import subway.common.ErrorMessage;

public class MenuInputManager {
    private static final String INPUT_NEEDED = " 중에서 입력해 주세요.";
    private final Scanner scanner;

    public MenuInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainInput() {
        MenuOutputManager.printWhichMenuGuide();
        String input = scanner.nextLine().toUpperCase().trim();
        try {
            checkMainSelection(input);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return input;
    }

    public String getStationInput() {
        MenuOutputManager.printWhichMenuGuide();
        String input = scanner.nextLine().toUpperCase().trim();
        try {
            checkStationSelection(input);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return input;

    }

    public String getLineInput() {
        MenuOutputManager.printWhichMenuGuide();
        String input = scanner.nextLine().toUpperCase().trim();
        try {
            checkLineSelection(input);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return input;
    }

    public String getPathInput() {
        MenuOutputManager.printWhichMenuGuide();
        String input = scanner.nextLine().toUpperCase().trim();
        try {
            checkPathSelection(input);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            return ErrorMessage.OUT;
        }
        return input;
    }

    private void checkMainSelection(String input) {
        if (!MenuItemsRepository.getMainSelections().contains(input)) {
            throw new ErrorMessage(
                MenuItemsRepository.getMainSelections().toString() + INPUT_NEEDED);
        }
    }

    private void checkStationSelection(String input) {
        if (!MenuItemsRepository.getStationSelections().contains(input)) {
            throw new ErrorMessage(
                MenuItemsRepository.getStationSelections().toString() + INPUT_NEEDED);
        }
    }

    private void checkLineSelection(String input) {
        if (!MenuItemsRepository.getLineSelections().contains(input)) {
            throw new ErrorMessage(
                MenuItemsRepository.getLineSelections().toString() + INPUT_NEEDED);
        }
    }

    private void checkPathSelection(String input) {
        if (!MenuItemsRepository.getPathSelections().contains(input)) {
            throw new ErrorMessage(
                MenuItemsRepository.getPathSelections().toString() + INPUT_NEEDED);
        }
    }


}
