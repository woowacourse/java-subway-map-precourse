package subway.line;

import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.station.Station;
import subway.station.StationService;

public class LineService {
    public static void addLine(String name, LineInputView lineInputView) {
        try {
            Line line = new Line(name);
            String startStationName = lineInputView.startStationName();
            String endStationName = lineInputView.endStationName();
            Station startStation = StationService.findStation(startStationName);
            Station endStation = StationService.findStation(endStationName);
            line.addStation(startStation);
            line.addStation(endStation);
            LineRepository.addLine(line);
            LineOutputView.addLineComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
