package subway.console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import subway.domain.LineRepository;

public class MainScreen implements SubwayScreen {
    private static final String MAIN_SCREEN_MENU = "\n## 메인 화면\n1. 역 관리\n2. 노선 관리\n3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료";
    private static final String[] MAIN_MENU_CHOICES = {"1", "2", "3", "4", "Q"};
    private static final String MAIN_SCREEN_SELECT_STATION_MANAGEMENT = MAIN_MENU_CHOICES[0];
    private static final String MAIN_SCREEN_SELECT_LINE_MANAGEMENT = MAIN_MENU_CHOICES[1];
    private static final String MAIN_SCREEN_SELECT_SECTION_MANAGEMENT = MAIN_MENU_CHOICES[2];
    private static final String MAIN_SCREEN_SELECT_PRINT_SUBWAY_MAP = MAIN_MENU_CHOICES[3];
    private static final String MAIN_SCREEN_SELECT_QUIT = MAIN_MENU_CHOICES[4];
    private static final String MAIN_SCREEN_PRINT_SUBWAY_MAP = "\n## 지하철 노선도";

    private static String mainScreenInput;

    @Override
    public void startProcess(Scanner scanner) {
        printScreen();
        mainScreenInput = getInput(scanner);
        transfer(scanner);
    }

    @Override
    public void transfer(Scanner scanner) {
        inputStationManagement(scanner);
        inputLineManagement(scanner);
        inputSectionManagement(scanner);
        inputPrintSubwayMap();
    }

    private void inputStationManagement(Scanner scanner) {
        if(mainScreenInput.equals(MAIN_SCREEN_SELECT_STATION_MANAGEMENT)) {
            StationScreen stationScreen = new StationScreen();
            stationScreen.startProcess(scanner);
        }
    }

    private void inputLineManagement(Scanner scanner) {
        if(mainScreenInput.equals(MAIN_SCREEN_SELECT_LINE_MANAGEMENT)) {
            LineScreen lineScreen = new LineScreen();
            lineScreen.startProcess(scanner);
        }
    }

    private void inputSectionManagement(Scanner scanner) {
        if(mainScreenInput.equals(MAIN_SCREEN_SELECT_SECTION_MANAGEMENT)) {
            SectionScreen sectionScreen = new SectionScreen();
            sectionScreen.startProcess(scanner);
        }
    }

    private void inputPrintSubwayMap() {
        if(mainScreenInput.equals(MAIN_SCREEN_SELECT_PRINT_SUBWAY_MAP)) {
            System.out.println(MAIN_SCREEN_PRINT_SUBWAY_MAP);
            LineRepository.printSubwayMap();
        }
    }

    public static boolean requestQuitMainScreen() {
        return mainScreenInput.equals(MAIN_SCREEN_SELECT_QUIT);
    }


    @Override
    public void printScreen() {
        System.out.println(MAIN_SCREEN_MENU);
        System.out.println(MESSAGE_MENU_SELECT);
    }

    @Override
    public String getInput(Scanner scanner) {
        String mainScreenInput;
        mainScreenInput = scanner.nextLine();
        validateInput(mainScreenInput);
        return mainScreenInput;
    }

    @Override
    public void validateInput(String input) {
        List<String> choices = Arrays.asList(MAIN_MENU_CHOICES);
        if(!choices.contains(input)) {
            throw new IllegalArgumentException(ERROR_MAIN_SCREEN_NOT_VALID_INPUT);
        }
    }
}
