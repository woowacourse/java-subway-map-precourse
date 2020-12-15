package subway.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.menu.LineMenu;
import subway.message.LineMessage;

public class LineScreen implements SubwayScreen, LineMessage {
    private String lineScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            validateInput(scanner);
            selectProcess(scanner, lineScreenInput);
        } while (!lineScreenInput.equals(LineMenu.BACK.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(LineMenu.getScreen());
    }

    @Override
    public void validateInput(Scanner scanner) {
        List<String> choices = Arrays.stream(LineMenu.values())
            .map(LineMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        do {
            System.out.println(MESSAGE_MENU_SELECT);
            lineScreenInput = scanner.nextLine();
        } while (!IsInputOnTheMenuList(lineScreenInput, choices));
    }

    public void selectProcess(Scanner scanner, String lineScreenInput) {
        try {
            LineMenu.executeMenuByInput(scanner, lineScreenInput);
        } catch (Exception e) {
            System.out.println(NEW_LINE + e.getMessage());
        }
    }

    private boolean IsInputOnTheMenuList(String input, List<String> choices) {
        if (!choices.contains(input)) {
            System.out.println(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
            return false;
        }
        return true;
    }
}
