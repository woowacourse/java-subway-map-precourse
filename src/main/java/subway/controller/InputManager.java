package subway.controller;

import java.util.Scanner;
import subway.domain.MenuItemsRepository;
import subway.view.ErrorMessage;
import subway.view.Menu;

public class InputManager {

    private Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getMainInput() {
        while (true) {
            Menu.printWhatMenu();
            String input = scanner.nextLine().toUpperCase().trim();
            if (!checkMainValidSelection(input)) {
                continue;
            }
            return input;
        }
    }

    private boolean checkMainValidSelection(String input) {
        if (!MenuItemsRepository.getMainSelections().contains(input)) {
            ErrorMessage.printError(
                MenuItemsRepository.getMainSelections().toString() + " 중에서 입력해 주세요.");
            return false;
        }
        return true;
    }

}
