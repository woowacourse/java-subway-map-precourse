package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String MAGNAGE_STATION = "1";
    private static final String MAGNAGE_LINE = "2";
    private static final String MAGNAGE_INTERVAL = "3";
    private static final String PRINT_SUBWAY_MAP = "3";
    private static final String EXIT = "Q";

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        while (true) {
            showMainOptions();
            String command = getMainContolCommand(scanner);

            if (command.equals(EXIT)) {
                break;
            }

            initializeStationRepository();
            initializeLineRepository();
            execute(command);
        }
    }

    private static void showMainOptions() {
        System.out.println("## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("Q. 종료");
        System.out.println();
    }

    private static String getMainContolCommand(Scanner scanner) {
        List<String> commands = new ArrayList<>(Arrays.asList(MAGNAGE_STATION, MAGNAGE_LINE, MAGNAGE_INTERVAL, PRINT_SUBWAY_MAP, EXIT));
        while (true) {
            System.out.println("## 원하는 기능을 선택하세요.");
            String userInput = scanner.nextLine();
            System.out.println();
            if (commands.contains(userInput)) {
                return userInput;
            }
            System.out.println("[ERROR] 없는 기능입니다.\n");
        }
    }

    private static void initializeLineRepository() {
        Line temp = new Line("2호선");
        temp.addStation(new Station("교대역"));
        temp.addStation(new Station("강남역"));
        temp.addStation(new Station("역삼역"));
        LineRepository.addLine(temp);

        temp = new Line("3호선");
        temp.addStation(new Station("교대역"));
        temp.addStation(new Station("남부터미널역"));
        temp.addStation(new Station("양재역"));
        temp.addStation(new Station("매봉역"));

        temp = new Line("신분당선");
        temp.addStation(new Station("강남역"));
        temp.addStation(new Station("양재역"));
        temp.addStation(new Station("양재시민의숲역"));
        LineRepository.addLine(temp);
    }

    private static void initializeStationRepository() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));
    }

    private static void execute(String command) {
        if (command.equals(MAGNAGE_STATION)) {
            // StationManager.start();
        }
        if (command.equals(MAGNAGE_LINE)) {
            // LineManager.start();
        }
        if (command.equals(MAGNAGE_INTERVAL)) {
            // IntervalManager.start();
        }
        if (command.equals(PRINT_SUBWAY_MAP)) {
            // printSubwayMap();
        }
    }
}
