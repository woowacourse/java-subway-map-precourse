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
    public static final List<String> mainFunctions = Arrays.asList("1", "2", "3", "4", "Q");
    public static final String STATION_MENU = "1";
    public static final String LINE_MENU = "2";
    public static final String SECTION_MENU = "3";
    public static final String PRINT_LINES = "4";
    public static final String FINISH_PROGRAM = "Q";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initialize();
        showMainMenu();
        String input = inputMainFunction(scanner);
        goSubMenu(input);
    }

    public static void goSubMenu(String input) {
        System.out.println();
        if (input.equals(STATION_MENU))
            showStationMenu();
        if (input.equals(LINE_MENU))
            showLineMenu();
        if (input.equals(SECTION_MENU))
            showSectionMenu();
        if (input.equals(PRINT_LINES))
            showPrintLines();
        if (input.equals(FINISH_PROGRAM))
            finishProgram();
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

    public static void showPrintLines() {
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

    public static void showMainMenu() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }

    public static String inputMainFunction(Scanner kbd) {
        String input = "0";
        boolean check = false;
        while(!check) {
            System.out.println("\n## 원하는 기능을 선택하세요.");
            input = kbd.nextLine();
            check = checkMainInput(input);
        }
        return input;
    }

    public static boolean checkMainInput(String input) {
        boolean check = true;
        if (!mainFunctions.contains(input)) {
            displayErrorMessage(FUNCTION_INPUT_ERROR);
            check = false;
        }
        return check;
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

    public static void displayErrorMessage(int errorCase) {
        if (errorCase == FUNCTION_INPUT_ERROR)
            System.out.println("[ERROR] 선택할 수 없는 기능입니다.");
    }
}
