package subway.migration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import subway.UtilityFunctions;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Migration {

    private static final String[] STATION_NAMES = {
        "교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
    };

    private static final Map<String, List<String>> LINE_MAP = new HashMap<>();

    static {
        LINE_MAP.put("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        LINE_MAP.put("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        LINE_MAP.put("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    private Migration() {
    }

    private static void migrateStations() throws IllegalArgumentException {
        List<Station> stations = new ArrayList<>();
        for (String stationName : STATION_NAMES) {
            stations.add(new Station(stationName));
        }
        stations.forEach(StationRepository::addStation);
    }

    private static void migrateLines() throws IllegalArgumentException {
        List<Line> lines = new ArrayList<>();
        for (Map.Entry<String, List<String>> item : LINE_MAP.entrySet()) {
            List<Station> stations = new ArrayList<>();
            for (String station : item.getValue()) {
                stations.add(UtilityFunctions.getStationByNameFromRepository(station));
            }
            lines.add(new Line(item.getKey(), stations));
        }
        lines.forEach(LineRepository::addLine);
    }

    public static void run() {
        migrateStations();
        migrateLines();
    }
}
