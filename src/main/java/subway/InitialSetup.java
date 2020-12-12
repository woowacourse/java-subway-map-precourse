package subway;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class InitialSetup {
    private static final String[] STATIONS =
            {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final LinkedHashMap<String, List<String>> LINES =
            new LinkedHashMap<String, List<String>>();

    static {
        LINES.put("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        LINES.put("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        LINES.put("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    public static void apply() {
        applyStations();
        applyLines();
    }

    private static void applyStations() {
        for (String station : STATIONS) {
            StationRepository.addStation(station);
        }
    }

    private static void applyLines() {
        for (String lineName : LINES.keySet()) {
            List<String> stations = LINES.get(lineName);
            LineRepository.addLine(lineName, stations.get(0), stations.get(1));
            for (int stationIndex = 2; stationIndex < stations.size(); stationIndex++) {
                LineRepository.pushSectios(lineName, stations.get(stationIndex));
            }
        }
    }
}
