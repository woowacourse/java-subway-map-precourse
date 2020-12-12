package subway.line;

import subway.line.view.LineOutputView;
import subway.station.Station;
import subway.station.StationService;

import java.util.ArrayList;
import java.util.List;

public class LineService {
    public static void addLine(String name, String startStationName, String endStationName) {
        List<Station> newStations = new ArrayList<>();
        Station startStation = StationService.findStation(startStationName);
        Station endStation = StationService.findStation(endStationName);

        newStations.add(startStation);
        newStations.add(endStation);

        EachLineStations stations = new EachLineStations(newStations);
        Line line = new Line(name, stations);
        LineRepository.addLine(line);
        LineOutputView.addLineComplete();
    }
}
