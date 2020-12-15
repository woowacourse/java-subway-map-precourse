package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
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
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static int inputMainFunction(Scanner kbd) {
        int input = kbd.nextInt();
        return input;
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
}
