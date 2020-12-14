package subway.screen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainScreen implements SubwayScreen {
    private String mainScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            mainScreenInput = validateInput(scanner.nextLine());
            findNextStep(scanner);
        } while (!mainScreenInput.equals(MainMenu.QUIT.getSymbol()));
    }

    private void findNextStep(Scanner scanner) {
        MainMenu.executeMenuByInput(mainScreenInput, scanner);
    }

    @Override
    public void printScreen() {
        System.out.println(MainMenu.getScreen());
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = new ArrayList<>();
        for (MainMenu mainMenu : MainMenu.values()) {
            choices.add(mainMenu.getSymbol());
        }
        if (!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }
}
