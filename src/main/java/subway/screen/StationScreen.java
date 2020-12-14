package subway.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.menu.StationMenu;

public class StationScreen implements SubwayScreen {
    private static String stationScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            stationScreenInput = validateInput(scanner.nextLine());
            StationMenu.executeMenuByInput(scanner, stationScreenInput);
        } while (!stationScreenInput.equals(StationMenu.BACK.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(StationMenu.getScreen());
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = Arrays.stream(StationMenu.values())
            .map(StationMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        if (!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }
}
