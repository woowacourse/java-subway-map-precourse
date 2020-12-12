package subway.line;

import subway.line.view.LineOutputView;
import subway.station.Station;
import subway.station.StationService;

public class LineService {
    public static void addLine(String name, String startStationName, String endStationName) {
        Line newLine = new Line(name);

        Station startStation = StationService.findStation(startStationName);
        Station endStation = StationService.findStation(endStationName);

        newLine.addStation(startStation);
        newLine.addStation(endStation);

        LineRepository.addLine(newLine);
        LineOutputView.addLineComplete();
    }
}
