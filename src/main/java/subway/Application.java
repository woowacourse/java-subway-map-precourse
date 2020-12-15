package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static final int FUNCTION_INPUT_ERROR = 0;
    public static final int SAME_NAME_ERROR = 1;
    public static final int NAME_LENGTH_ERROR = 2;
    public static final int NO_SUCH_NAME_ERROR = 3;
    public static final int HAS_IN_LINE_ERROR = 4;
    public static final List<String> MAIN_FUNCTIONS = Arrays.asList("1", "2", "3", "4", "Q");
    public static final String STATION_MENU = "1";
    public static final String LINE_MENU = "2";
    public static final String SECTION_MENU = "3";
    public static final String PRINT_LINES = "4";
    public static final String FINISH_PROGRAM = "Q";
    public static final List<String> SUB_FUNCTIONS = Arrays.asList("1", "2", "3", "B");
    public static final String ADD_MENU = "1";
    public static final String DELETE_MENU = "2";
    public static final String SEARCH_MENU = "3";
    public static final String GO_BACK_MENU = "B";
    public static final List<String> SECTION_FUNCTIONS = Arrays.asList("1", "2", "B");

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initialize();
        startProgram(scanner);
    }

    public static void startProgram(Scanner kbd) {
        showMainMenu();
        String mainInput = inputFunction(kbd, MAIN_FUNCTIONS);
        goSubMenu(mainInput, kbd);
    }

    public static void initialize() {
        initializeStation();
        initializeLine();
    }

    public static void initializeStation() {
        List<String> names = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String name : names)
            StationRepository.addStation(new Station(name));
    }

    public static void initializeLine() {
        Line line2 = new Line("2호선");
        LineRepository.addLine(line2, Arrays.asList("교대역", "강남역", "역삼역"));
        Line line3 = new Line("3호선");
        LineRepository.addLine(line3, Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        Line lineSinbundang = new Line("신분당선");
        LineRepository.addLine(lineSinbundang, Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    public static void showMainMenu() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public static String inputFunction(Scanner kbd, List<String> functions) {
        String input = "0";
        boolean check = false;
        while(!check) {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            input = kbd.nextLine();
            check = checkInput(input, functions);
        }
        return input;
    }

    public static boolean checkInput(String input, List<String> functions) {
        boolean check = true;
        if (!functions.contains(input)) {
            displayErrorMessage(FUNCTION_INPUT_ERROR);
            check = false;
        }
        return check;
    }

    public static void goSubMenu(String input, Scanner kbd) {
        System.out.println();
        if (input.equals(STATION_MENU))
            manageStation(kbd);
        if (input.equals(LINE_MENU))
            manageLine(kbd);
        if (input.equals(SECTION_MENU))
            manageSection(kbd);
        if (input.equals(PRINT_LINES))
            displayAllLines();
        if (input.equals(FINISH_PROGRAM))
            finishProgram();
    }

    public static void manageStation(Scanner kbd) {
        showStationMenu();
        String input = inputFunction(kbd, SUB_FUNCTIONS);
        if (input.equals(ADD_MENU))
            addStation(kbd);
        if (input.equals(DELETE_MENU))
            deleteStation(kbd);
        if (input.equals(SEARCH_MENU))
            searchStation();
        if (input.equals(GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void manageLine(Scanner kbd) {
        showLineMenu();
        String input = inputFunction(kbd, SUB_FUNCTIONS);
        if (input.equals(ADD_MENU))
            addLine(kbd);
        if (input.equals(DELETE_MENU))
            deleteLine(kbd);
        if (input.equals(SEARCH_MENU))
            searchLine();
        if (input.equals(GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void manageSection(Scanner kbd) {
        showSectionMenu();
        String input = inputFunction(kbd, SECTION_FUNCTIONS);
//        if (input.equals(ADD_MENU))
//            addSection(kbd);
//        if (input.equals(DELETE_MENU))
//            deleteSection(kbd);
        if (input.equals(GO_BACK_MENU))
            startProgram(kbd);
    }

    public static void addStation(Scanner kbd) {
        try {
            System.out.println("\n## 등록할 역 이름을 입력하세요.");
            String stationName = kbd.nextLine();
            checkSameName(stationName);
            checkTextLength(stationName);
            StationRepository.addStation(new Station(stationName));
            System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void deleteStation(Scanner kbd) {
        try {
            System.out.println("\n## 삭제할 역 이름을 입력하세요.");
            String stationName = kbd.nextLine();
            checkExist(stationName);
            checkInLine(stationName);
            StationRepository.deleteStation(stationName);
            System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
            startProgram(kbd);
        } catch (Exception e) {
            startProgram(kbd);
        }
    }

    public static void searchStation() {
        System.out.println("\n## 역 목록");
        for (Station station : StationRepository.stations())
            System.out.println("[INFO] " + station.getName());
        System.out.println();
    }

    public static void addLine(Scanner kbd) {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        String lineName = kbd.nextLine();
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String firstStation = kbd.nextLine();
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String lastStation = kbd.nextLine();
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void deleteLine(Scanner kbd) {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        String stationName = kbd.nextLine();
        System.out.println("[INFO] 지하철 노선이 삭제되었습니다.");
    }

    public static void searchLine() {
        System.out.println("\n## 노선 목록");
        for (Line line : LineRepository.lines())
            System.out.println("[INFO] " + line.getName());
        System.out.println();
    }

    public static void checkSameName(String name) {
        if (StationRepository.isExist(name)) {
            displayErrorMessage(SAME_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkTextLength(String name) {
        if (name.length() < 2) {
            displayErrorMessage(NAME_LENGTH_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkExist(String name) {
        if (!StationRepository.isExist(name)) {
            displayErrorMessage(NO_SUCH_NAME_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public static void checkInLine(String name) {
        for (Line line : LineRepository.lines())
            if (line.hasStation(name)) {
                displayErrorMessage(HAS_IN_LINE_ERROR);
                throw new IllegalArgumentException();
            }
    }

    public static void showStationMenu() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public static void showLineMenu() {
        System.out.println("## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public static void showSectionMenu() {
        System.out.println("## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public static void displayAllLines() {
        System.out.println("## 지하철 노선도");
        for(Line line : LineRepository.lines()) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INFO] ---");
            line.displayLine();
        }
    }

    public static void finishProgram() {
        System.out.println("## 프로그램 종료");
    }

    public static void displayErrorMessage(int errorCase) {
        if (errorCase == FUNCTION_INPUT_ERROR)
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
        if (errorCase == SAME_NAME_ERROR)
            System.out.println("[ERROR] 이미 등록된 역 이름입니다.");
        if (errorCase == NAME_LENGTH_ERROR)
            System.out.println("[ERROR] 이름을 2글자 이상 입력해주세요.");
        if (errorCase == NO_SUCH_NAME_ERROR)
            System.out.println("[ERROR] 등록되지 않은 역 이름입니다.");
        if (errorCase == HAS_IN_LINE_ERROR)
            System.out.println("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
    }
}