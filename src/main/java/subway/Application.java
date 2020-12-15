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
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        initialize();
        showMainMenu();
        System.out.println(inputMainFunction(scanner));
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
