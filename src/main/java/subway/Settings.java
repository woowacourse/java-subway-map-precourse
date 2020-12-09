package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Settings {
    private static final List<String> INIT_STATIONS = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
    private static final String INIT_LINE1_NAME = "2호선";
    private static final String INIT_LINE2_NAME = "3호선";
    private static final String INIT_LINE3_NAME = "신분당선";
    private static final List<String> INIT_LINE1_STATIONS = Arrays.asList("교대역","강남역","역삼역");
    private static final List<String> INIT_LINE2_STATIONS = Arrays.asList("교대역","남부터미널역","양재역","매봉역");
    private static final List<String> INIT_LINE3_STATIONS = Arrays.asList("강남역","양재역","양재시민의숲역");

    public static void init() {
        initStations();
        initLines();
    }

    private static void initStations() {
        for (String stationName : INIT_STATIONS) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void initLines() {
        initLine(INIT_LINE1_NAME, INIT_LINE1_STATIONS);
        initLine(INIT_LINE2_NAME, INIT_LINE2_STATIONS);
        initLine(INIT_LINE3_NAME, INIT_LINE3_STATIONS);
    }

    private static void initLine(String lineName, List<String> stationNames) {
        LineRepository.addLine(new Line(lineName, stationNames.stream().map(StationRepository::getStation).toArray(Station[]::new)));
    }
}
