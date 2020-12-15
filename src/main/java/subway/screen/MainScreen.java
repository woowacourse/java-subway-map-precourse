package subway.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.menu.MainMenu;

public class MainScreen implements SubwayScreen {
    private String mainScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            validateInput(scanner);
            selectProcess(scanner, mainScreenInput);
        } while (!mainScreenInput.equals(MainMenu.QUIT.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(MainMenu.getScreen());
    }

    @Override
    public void validateInput(Scanner scanner) {
        List<String> choices = Arrays.stream(MainMenu.values())
            .map(MainMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        do {
            System.out.println(MESSAGE_MENU_SELECT);
            mainScreenInput = scanner.nextLine();
        } while (!IsInputOnTheMenuList(mainScreenInput, choices));
    }

    @Override
    public void selectProcess(Scanner scanner, String input) {
        MainMenu.executeMenuByInput(mainScreenInput, scanner);
    }

    private boolean IsInputOnTheMenuList(String input, List<String> choices) {
        if (!choices.contains(input)) {
            System.out.println(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
            return false;
        }
        return true;
    }
}
