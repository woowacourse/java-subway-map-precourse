package subway.screen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.LineRepository;
import subway.screenMessage.MainScreenMessage;

public class MainScreen implements SubwayScreen, MainScreenMessage {
    private String mainScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        do {
            printScreen();
            mainScreenInput = validateInput(scanner.nextLine());
            transfer(scanner);
        } while (!mainScreenInput.equals(QUIT));
    }

    @Override
    public void printScreen() {
        System.out.println(MAIN_SCREEN_MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String validateInput(String input) {
        List<String> choices = Arrays.asList(MENU_CHOICES);
        if (!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
        return input;
    }

    @Override
    public void transfer(Scanner scanner) {
        inputStationManagement(scanner);
        inputLineManagement(scanner);
        inputSectionManagement(scanner);
        inputPrintSubwayMap();
    }

    private void inputStationManagement(Scanner scanner) {
        if (mainScreenInput.equals(STATION_MANAGEMENT)) {
            display(new StationScreen(), scanner);
        }
    }

    private void inputLineManagement(Scanner scanner) {
        if (mainScreenInput.equals(LINE_MANAGEMENT)) {
            display(new LineScreen(), scanner);
        }
    }

    private void inputSectionManagement(Scanner scanner) {
        if (mainScreenInput.equals(SECTION_MANAGEMENT)) {
            display(new SectionScreen(), scanner);
        }
    }

    private void inputPrintSubwayMap() {
        if (mainScreenInput.equals(PRINT_SUBWAY_MAP)) {
            System.out.println(MAIN_SCREEN_PRINT_SUBWAY_MAP);
            LineRepository.printSubwayMap();
        }
    }

    public static void display(SubwayScreen subwayScreen, Scanner scanner) {
        subwayScreen.startProcess(scanner);
    }
}
