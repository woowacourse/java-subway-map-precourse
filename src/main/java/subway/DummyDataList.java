package subway;

import java.util.*;

public enum DummyDataList {
    LINE_2("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
    LINE_3("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
    LINE_NEW("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

    private String lineName;
    private List<String> stations;

    DummyDataList(String lineName, List<String> stations) {
        this.lineName = lineName;
        this.stations = stations;
    }

    public static Set<String> getStationNames(){
        Set<String> stationNames = new HashSet<>();
        for (DummyDataList value : values()) {
            stationNames.addAll(value.stations);
        }
        return stationNames;
    }

    public static Map<String, List<String>> getLineGroup(){
        Map<String, List<String>> lines = new HashMap<>();
        for (DummyDataList value : values()) {
            lines.put(value.lineName, value.stations);
        }
        return lines;
    }
}
