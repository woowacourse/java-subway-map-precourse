package subway.controller.initialization;

import java.util.Arrays;
import java.util.List;

public enum InitialSection {
    LINE_NUMBER_2("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
    LINE_NUMBER_3("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
    SHINBUNDANG_LINE("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

    private String lineName;
    private List<String> stationNames;

    InitialSection(String lineName, List<String> stationNames) {
        this.lineName = lineName;
        this.stationNames = stationNames;
    }

    public String getLineName() {
        return lineName;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
