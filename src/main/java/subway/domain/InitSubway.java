package subway.domain;

import java.util.*;

public class InitSubway {
    public static void initSubway() {
        initStation();
        initLine();
    }

    private static void initStation() {
        List<String> stationStringList = new ArrayList<>(Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
        for (String stationName : stationStringList) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void initLine() {
        Map<String, List<String>> lineMap = new HashMap<>();
        lineMap.put("2호선", Arrays.asList("교대역", "강남역", "역삼역"));
        lineMap.put("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역"));
        lineMap.put("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

        for (String lineName : lineMap.keySet()) {
            List<String> stationNames = lineMap.get(lineName);
            List<Station> stationsList = getLineStations(stationNames);
            LineRepository.addLine(new Line(lineName, stationsList));
        }
    }

    private static List<Station> getLineStations(List<String> stationNames) {
        List<Station> stations = new ArrayList<>();
        for (String stationName : stationNames) {
            stations.add(new Station(stationName));
        }
        return stations;
    }
}
