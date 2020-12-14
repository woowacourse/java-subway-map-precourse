package subway.views;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;

public class OutPutSubwayMap implements OutputView{
    private static final String SUBWAY_MAP_PAGE = "\n## 지하철 노선도";
    private static final String SEPARATOR = "---";

    public static void printAllSubwayMap() {
        System.out.println(SUBWAY_MAP_PAGE);
        for (Line line : LineRepository.lines()) {
            System.out.println(INFO_PREFIX + line.getName());
            System.out.println(INFO_PREFIX + SEPARATOR);
            line.getStations().stream()
                .map(Station::getName)
                .forEach(stationName -> System.out.println(INFO_PREFIX + stationName));
            System.out.println();
        }
    }
}
