package subway.view;

import static subway.domain.SectionRepository.sections;

import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class OutputView {

    private final String PREFIX = "[INFO] ";
    private final String DELIMITER = "---";
    private final String ERROR = "[ERROR] ";
    private final String STATION_LIST = "## 역 목록";
    private final String LINE_LIST = "## 노선 목록";
    private final String SUBWAY_MAP_LIST = "## 지하철 노선도";


    public void printMenu(List<String> menu) {
        for (String element : menu) {
            System.out.println(element);
        }
    }

    public void printStationList() {
        System.out.println(STATION_LIST);
        for (Station station : StationRepository.stations()) {
            System.out.println(PREFIX + station);
        }
    }

    public void printSelectFunction(String selectFunction) {
        System.out.println(selectFunction);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(ERROR + e.getMessage());
    }

    public void printLineList() {
        System.out.println(LINE_LIST);
        for (Line line : LineRepository.lines()) {
            System.out.println(PREFIX + line);
        }
    }

    public void printNotificationMessage(String message) {
        System.out.println(PREFIX + message);
    }

    public void printSubwayMap() {
        System.out.println(SUBWAY_MAP_LIST);
        for (Map.Entry<Line, List<Station>> subwayMap : sections().entrySet()) {
            System.out.println(PREFIX + subwayMap.getKey());
            System.out.println(PREFIX + DELIMITER);
            subwayMap.getValue().forEach(s -> System.out.println(PREFIX + s));
            System.out.println();
        }
    }
}
