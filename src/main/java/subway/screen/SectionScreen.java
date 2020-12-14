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
            sectionScreenInput = validateInput(scanner.nextLine());
            SectionMenu.executeMenuByInput(scanner, sectionScreenInput);
        } while (!sectionScreenInput.equals(SectionMenu.BACK.getSymbol()));
    }

    @Override
    public void printScreen() {
        System.out.println(SectionMenu.getScreen());
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = Arrays.stream(SectionMenu.values())
            .map(SectionMenu::getSymbol)
            .collect(Collectors.toCollection(ArrayList::new));
        if (!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }
}
