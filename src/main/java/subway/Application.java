package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static final String MAGNAGE_STATION = "1";
    private static final String MAGNAGE_LINE = "2";
    private static final String MAGNAGE_INTERVAL = "3";
    private static final String PRINT_SUBWAY_MAP = "4";
    private static final String EXIT = "Q";
    private static final String MAIN = "MAIN";

    public static void main(String[] args) {
        initializeRepositories();
        List<String> authorizedCommands = new ArrayList<>(Arrays.asList(MAGNAGE_STATION, MAGNAGE_LINE, MAGNAGE_INTERVAL, PRINT_SUBWAY_MAP, EXIT));
        while (true) {
            try {
                String command = UserConsole.getCommand(MAIN, authorizedCommands);
                if (command.equals(EXIT)) {
                    break;
                }
                execute(command);
            } catch (Exception exception) {
                continue;
            }
        }
    }

    private static void initializeRepositories() {
        initializeStationRepository();
        initializeLineRepository();
    }

    private static void initializeLineRepository() {
        Line line2 = new Line("2호선");
        line2.addStationNames(Arrays.asList("교대역", "강남역", "역삼역"));
        LineRepository.addLine(line2);
        Line line3 = new Line("3호선");
        line3.addStationNames(Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        LineRepository.addLine(line3);
        Line sinbundangLine = new Line("신분당선");
        sinbundangLine.addStationNames(Arrays.asList("강남역", "양재역", "양재시민의숲역"));
        LineRepository.addLine(sinbundangLine);
    }

    private static void initializeStationRepository() {
        List<String> stationNames = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        stationNames.forEach(stationName -> StationRepository.addStation(new Station(stationName)));
    }

    private static void execute(String command) {
        if (command.equals(MAGNAGE_STATION)) {
            StationManager.start();
        }
        if (command.equals(MAGNAGE_LINE)) {
            LineManager.start();
        }
        if (command.equals(MAGNAGE_INTERVAL)) {
            IntervalManager.start();
        }
        if (command.equals(PRINT_SUBWAY_MAP)) {
            printSubwayMap();
        }
    }

    private static void printSubwayMap() {
        if (LineRepository.isEmpty()) {
            System.out.println("[ERROR] 노선 목록이 비어 있다.\n");
        }
        List<Line> lines = LineRepository.lines();
        System.out.println("## 지하철 노선도");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
            System.out.println("[INRO] ---");
            List<String> stationNames = line.getStationNames();
            stationNames.forEach(stationName -> System.out.println("[INFO] " + stationName));
            System.out.println();
        }
    }
}
