package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class BasicData {
    public static String[] BASIC_STATIONS = {"교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역"};
    public static String[] BASIC_LINES = {"2호선", "3호선", "신분당선"};
    public static String[][] BASIC_ROUTES = {{"교대역", "강남역", "역삼역"}, {"교대역", "남부터미널역", "양재역", "매봉역"}, {"강남역", "양재역", "양재시민의숲역"}};

    public static void setBasicData() {
        setBasicStations();
        setBasicLines();
    }

    private static void setBasicStations() {
        for (String stationName : BASIC_STATIONS) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private static void setBasicLines() {
        for (int i = 0; i < BASIC_LINES.length; i++) {
            Line line = new Line(BASIC_LINES[i]);
            setBasicRoutes(line, i);
            LineRepository.addLine(line);
        }
    }

    private static void setBasicRoutes(Line line, int index) {
        for (String station : BASIC_ROUTES[index]) {
            line.addLineStation(StationRepository.getStation(station));
        }

    }
}
