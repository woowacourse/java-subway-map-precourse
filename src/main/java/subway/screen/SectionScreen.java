package subway.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.menu.SectionMenu;
import subway.message.SectionMessage;

public class SectionScreen implements SubwayScreen, SectionMessage {
    private static String sectionScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            validateInput(scanner);
            selectProcess(scanner, sectionScreenInput);
        } while (!sectionScreenInput.equals(SectionMenu.BACK.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(SectionMenu.getScreen());
    }

    @Override
    public void validateInput(Scanner scanner) {
        List<String> choices = Arrays.stream(SectionMenu.values())
            .map(SectionMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        do {
            System.out.println(MESSAGE_MENU_SELECT);
            sectionScreenInput = scanner.nextLine();
        } while (!IsInputOnTheMenuList(sectionScreenInput, choices));
    }

    public void selectProcess(Scanner scanner, String sectionScreenInput) {
        try {
            SectionMenu.executeMenuByInput(scanner, sectionScreenInput);
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
