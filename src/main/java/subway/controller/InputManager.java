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
            if (!checkMainSelection(input)) {
                continue;
            }
            return input;
        }
    }

    public String getStationInput() {
        while (true) {
            Menu.printWhatMenu();
            String input = scanner.nextLine().toUpperCase().trim();
            if (!checkStationSelection(input)) {
                continue;
            }
            return input;
        }
    }

    public String getLineInput() {
        while (true) {
            Menu.printWhatMenu();
            String input = scanner.nextLine().toUpperCase().trim();
            if (!checkLineSelection(input)) {
                continue;
            }
            return input;
        }
    }

    private boolean checkLineSelection(String input) {
        if (!MenuItemsRepository.getLineSelections().contains(input)) {
            ErrorMessage.printError(
                MenuItemsRepository.getLineSelections().toString());
            return false;
        }
        return true;
    }

    private boolean checkStationSelection(String input) {
        if (!MenuItemsRepository.getStationSelections().contains(input)) {
            ErrorMessage.printError(
                MenuItemsRepository.getStationSelections().toString());
            return false;
        }
        return true;
    }

    private boolean checkMainSelection(String input) {
        if (!MenuItemsRepository.getMainSelections().contains(input)) {
            ErrorMessage.printError(
                MenuItemsRepository.getMainSelections().toString());
            return false;
        }
        return true;
    }

}
