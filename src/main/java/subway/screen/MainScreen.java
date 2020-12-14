package subway.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.menu.MainMenu;

public class MainScreen implements SubwayScreen {
    private String mainScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            mainScreenInput = validateInput(scanner.nextLine());
            MainMenu.executeMenuByInput(mainScreenInput, scanner);
        } while (!mainScreenInput.equals(MainMenu.QUIT.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(MainMenu.getScreen());
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = Arrays.stream(MainMenu.values())
            .map(MainMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        if (!choices.contains(input)) {
            throw new NoSuchElementException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }
}
