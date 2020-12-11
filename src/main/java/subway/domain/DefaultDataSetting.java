package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class DefaultDataSetting {
    public static final List<String> defaultStations = new ArrayList<String>(Arrays.asList("교대역", "강남역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"));
    public static final List<String> defaultLines = new ArrayList<String>(Arrays.asList("2호선", "3호선", "신분당선"));

    public static List<String> defaultStations() {
        return Collections.unmodifiableList(defaultStations);
    }

    public static List<String> defaultLines() {
        return Collections.unmodifiableList(defaultLines);
    }

    public static void addDefaultData() {

    }

    static void addDefaultStationData() {

    }

    static void addDefaultLineData() {

    }
}
