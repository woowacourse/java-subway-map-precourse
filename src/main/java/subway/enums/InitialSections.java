package subway.enums;

import java.util.Arrays;
import java.util.List;

public enum InitialSections {
    LINE_2("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
    LINE_3("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
    LINE_SINBUNDANG("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

    private String line;
    private List<String> stations;

    InitialSections(String line, List<String> stations) {
        this.line = line;
        this.stations = stations;
    }

    public String getLine() {
        return line;
    }

    public List<String> getStations() {
        return stations;
    }
}
