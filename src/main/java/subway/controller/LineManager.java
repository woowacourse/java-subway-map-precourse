package subway.controller;

import subway.InputView;
import subway.domain.Line;
import subway.domain.LineRepository;

import java.util.Scanner;

public class LineManager {
    public static final String KEY_LINE_MANAGER = "lineManager";
    public static final String MENU_INT_ADD_LINE = "1";
    public static final String MENU_INT_DELETE_LINE = "2";
    public static final String MENU_INT_PRINT_LINE = "3";
    public static final String MSG_INPUT_LINE_TO_REGISTER = "\n## 등록할 노선 이름을 입력하세요.";
    public static final String MSG_INPUT_FIRST_STATION_TO_REGISTER_TO_SECTION = "\n##등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String MSG_INPUT_LAST_STATION_TO_REGISTER_TO_SECTION = "\n##등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String MSG_INPUT_LINE_TO_DELETE = "\n## 삭제할 노선 이름을 입력하세요.";
    public static final String MSG_OUTPUT_LINE_REGISTERING_COMPLETE = "\n[INFO] 노선이 등록되었습니다.";
    public static final String ERROR_MSG_NON_EXISTING_LINE = "\n[ERROR] 존재하지 않는 노선입니다.";
    public static final String ERROR_MSG_DUPLICATE_LINE = "\n[ERROR] 이미 등록된 노선입니다.";
    public static final String ERROR_MSG_LINE_NAME_SHOULD_OVER_2_CHARACTERS = "\n[ERROR] 노선 이름은 2글자 이상이어야 합니다.";
    public static final int INT_MINIMUM_CHARACTERS = 2;
    private final Scanner scanner;

    public LineManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner, KEY_LINE_MANAGER);
        String menuNumber = inputView.nextMenu();
        selectMenu(menuNumber);
    }

    public void initializeLine() {
        Line line2 = new Line("2호선");
        line2.initializeSection("교대역", "역삼역");
        line2.addStationToSection(1, "강남역");
        LineRepository.addLine(line2);
        Line line3 = new Line("3호선");
        line3.initializeSection("교대역", "매봉역");
        line3.addStationToSection(1, "남부터미널역");
        line3.addStationToSection(2, "양재역");
        LineRepository.addLine(line3);
        Line lineSinbundang = new Line("신분당선");
        lineSinbundang.initializeSection("강남역", "양재시민의숲역");
        lineSinbundang.addStationToSection(1, "양재역");
        LineRepository.addLine(lineSinbundang);
    }


    private void selectMenu(String menuNumber) {
        if (menuNumber.equals(MENU_INT_ADD_LINE)) {
            addLine();
        } else if (menuNumber.equals(MENU_INT_DELETE_LINE)) {
            deleteLine();
        } else if (menuNumber.equals(MENU_INT_PRINT_LINE)) {
            printLine();
        }
    }

    private void addLine() {
        try {
            String line = askLineAndValidate();
            Line newLine = new Line(line);
            askStartEndStationAndRegister(newLine);
            LineRepository.addLine(newLine);
            System.out.println(MSG_OUTPUT_LINE_REGISTERING_COMPLETE);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private String askLineAndValidate() throws IllegalArgumentException {
        String line = InputView.askName(scanner, MSG_INPUT_LINE_TO_REGISTER);
        validateOverTwoChracters(line);
        validateNotExistingLine(line);
        return line;
    }

    private void askStartEndStationAndRegister(Line newLine) {
        String startStation = InputView.askName(scanner, MSG_INPUT_FIRST_STATION_TO_REGISTER_TO_SECTION);
        String endStation = InputView.askName(scanner, MSG_INPUT_LAST_STATION_TO_REGISTER_TO_SECTION);
        newLine.initializeSection(startStation, endStation);
    }

    private void validateNotExistingLine(String line) {
        if (LineRepository.hasLine(line)){
            throw new IllegalArgumentException(ERROR_MSG_DUPLICATE_LINE);
        }
    }

    private void validateOverTwoChracters(String line) {
        if (line.length() < INT_MINIMUM_CHARACTERS) {
            throw new IllegalArgumentException(ERROR_MSG_LINE_NAME_SHOULD_OVER_2_CHARACTERS);
        }
    }

    private void deleteLine() {
        String station = InputView.askName(scanner, MSG_INPUT_LINE_TO_DELETE);
        try {
            if (!LineRepository.deleteLineByName(station)) {
                throw new IllegalArgumentException(ERROR_MSG_NON_EXISTING_LINE);
            }
        } catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
            run();
        }
    }

    private void printLine() {
        LineRepository.printLineList();
    }


}
