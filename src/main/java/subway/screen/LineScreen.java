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

    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            lineScreenInput = validateInput(scanner.nextLine());
            LineMenu.executeMenuByInput(scanner, lineScreenInput);
        } while (!lineScreenInput.equals(LineMenu.BACK.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(LineMenu.getScreen());
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = Arrays.stream(LineMenu.values())
            .map(LineMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        if (!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }
}
