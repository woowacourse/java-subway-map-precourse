package subway.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import jdk.nashorn.internal.runtime.ECMAException;
import subway.menu.StationMenu;

public class StationScreen implements SubwayScreen {
    private static String stationScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            validateInput(scanner);
            selectProcess(scanner, stationScreenInput);

        } while (!stationScreenInput.equals(StationMenu.BACK.getSymbol()));
    }

    public void selectProcess(Scanner scanner, String stationScreenInput) {
        try {
            StationMenu.executeMenuByInput(scanner, stationScreenInput);
        } catch (Exception e) {
            System.out.println(NEW_LINE + e.getMessage());
        }
    }

    @Override
    public void printScreen() {
        System.out.println(StationMenu.getScreen());
    }

    @Override
    public void validateInput(Scanner scanner) {
        List<String> choices = Arrays.stream(StationMenu.values())
            .map(StationMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        do {
            System.out.println(MESSAGE_MENU_SELECT);
            stationScreenInput = scanner.nextLine();
        } while (!IsInputOnTheMenuList(stationScreenInput, choices));
    }

    private boolean IsInputOnTheMenuList(String input, List<String> choices) {
        if (!choices.contains(input)) {
            System.out.println(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
            return false;
        }
        return true;
    }
}
