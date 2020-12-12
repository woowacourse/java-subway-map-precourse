package subway;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class InitialSetup {
    private static final String[] stations =
            {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    private static final LinkedHashMap<String, List<String>> lines =
            new LinkedHashMap<String, List<String>>();

    static {
        lines.put("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        lines.put("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        lines.put("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));
    }

    public static void apply() {
        applyStations();
        applyLines();
    }

    private static void applyStations() {
        for (String station : stations) {
            StationRepository.addStation(station);
        }
    }

    private static void applyLines() {
        for (String lineName : lines.keySet()) {
            List<String> stations = lines.get(lineName);
            LineRepository.addLine(lineName, stations.get(0), stations.get(1));
            for (int stationIndex = 2; stationIndex < stations.size(); stationIndex++) {
                LineRepository.pushSectios(lineName, stations.get(stationIndex));
            }
        }
    }
}
