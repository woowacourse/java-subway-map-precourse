package subway.line;

import subway.station.Station;
import subway.station.StationRepository;
import subway.station.StationService;
import utils.StringSeparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineInitialization {
    private static final String lineNumberTwo = "2호선, 교대역, 강남역, 역삼역";
    private static final String lineNumberThree = "3호선, 교대역, 남부터미널역, 양재역, 매봉역";
    private static final String dxLine = "신분당선, 강남역, 양재역, 양재시민의숲역";
    private static final List<String> basicLineList = Arrays.asList(lineNumberTwo, lineNumberThree, dxLine);

    public static void setBasicLines() {
        for (String lineComponent : basicLineList) {
            List<String> stations = Arrays.asList(StringSeparation.stringToArray(lineComponent));
            String lineName = stations.get(0);
            EachLineStations lineStations = new EachLineStations(getStationList(stations, lineName));
            Line line = new Line(lineName, lineStations);
            LineRepository.addLine(line);
        }
    }

    private static List<Station> getStationList(List<String> lineComponent, String lineName) {
        List<Station> stations = new ArrayList<>();

        for (String stationName : lineComponent) {
            if (!stationName.equals(lineName)) {
                Station station = StationService.findStation(stationName);
                stations.add(station);
            }
        }

        return stations;
    }
}
