package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Initializer {
    private static final int ORDER_CONSTANT = 1;

    private static final String station1 = "교대역";
    private static final String station2 = "강남역";
    private static final String station3 = "역삼역";
    private static final String station4 = "남부터미널역";
    private static final String station5 = "양재역";
    private static final String station6 = "양재시민의숲역";
    private static final String station7 = "매봉역";

    private static final String line1 = "2호선";
    private static final String line2 = "3호선";
    private static final String line3 = "신분당선";

    private static final List<String> initStations = Arrays.asList(station1, station2, station3, station4, station5, station6, station7);
    private static final List<String> line1Stations = Arrays.asList(station1, station2, station3);
    private static final List<String> line2Stations = Arrays.asList(station1, station4, station5, station7);
    private static final List<String> line3Stations = Arrays.asList(station2, station5, station6);

    private static final HashMap<String, List<String>> initLines = new HashMap<String, List<String>>() {{
        put(line1, line1Stations);
        put(line2, line2Stations);
        put(line3, line3Stations);
    }};

    private Initializer() {
    }

    public static void set() {
        HashMap<String,Station> stations = makeStations();
        List<String> lineNameList = new ArrayList<String>(initLines.keySet());
        for (int i = 0; i < lineNameList.size(); i++) {
            String lineName = lineNameList.get(i);
            makeLine(lineName);
        }
    }

    private static HashMap<String, Station> makeStations() {
        HashMap<String, Station> stations = new HashMap<String, Station>();
        for (int i = 0; i < initStations.size(); i++) {
            String stationName = initStations.get(i);
            Station station = new Station(stationName);
            StationRepository.addStation(station);
            stations.put(stationName, station);
        }
        return stations;
    }

    private static void makeLine(String lineName) {
        Line line = new Line(lineName);
        List<String> stationList = initLines.get(lineName);
        for (int i = 0; i < stationList.size(); i++) {
            String stationName = stationList.get(i);
            int order = i + ORDER_CONSTANT;
            line.addStationByName(stationName, order);
        }
        LineRepository.addLine(line);
    }
}
