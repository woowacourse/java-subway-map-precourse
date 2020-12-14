package subway;

import subway.domain.*;

import java.util.*;

public class DefaultSetter {
    private static final List<String> STATION_NAME_LIST = Collections.unmodifiableList(
            Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "매봉역"));
    private static final List<String> LINE_NAME_LIST =
            Collections.unmodifiableList(Arrays.asList("2호선", "3호선", "신분당선"));
    private static final Map<String, List<String>> TO_ADD_SECTION_MAP =
            Collections.unmodifiableMap(
                    new LinkedHashMap<>() {
                        {
                            put("2호선", Arrays.asList("교대역", "역삼역"));
                            put("3호선", Arrays.asList("교대역", "매봉역"));
                            put("신분당선", Arrays.asList("강남역", "양재시민의숲역"));
                        }
                    }
            );
    private static final Map<String, List<String>> TO_INSERT_SECTION_MAP =
            Collections.unmodifiableMap(
                    new LinkedHashMap<>() {
                        {
                            put("2호선", Arrays.asList("강남역"));
                            put("3호선", Arrays.asList("남부터미널역", "양재역"));
                            put("신분당선", Arrays.asList("양재역"));
                        }
                    }
            );
    private static final int INSERT_INDEX = 1;

    private DefaultSetter() {
    }

    public static void setupDefaultInfo() {
        setupStation();
        setupLine();
        setUpSection();
    }

    private static void setupStation() {
        for (String stationName : STATION_NAME_LIST) {
            Station station = new Station(stationName);
            StationRepository.addStation(station);
        }
    }

    private static void setupLine() {
        for (String lineName : LINE_NAME_LIST) {
            Line line = new Line(lineName);
            LineRepository.addLine(line);
            SectionRepository.addSection(
                    lineName,
                    TO_ADD_SECTION_MAP.get(lineName).get(0),
                    TO_ADD_SECTION_MAP.get(lineName).get(1));
        }
    }

    private static void setUpSection() {
        for (String key : TO_INSERT_SECTION_MAP.keySet()) {
            for (String station : TO_INSERT_SECTION_MAP.get(key)) {
                SectionRepository.insertSection(key, station, INSERT_INDEX);
            }
        }
    }
}
