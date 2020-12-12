package subway.line;

import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.station.Station;
import subway.station.StationService;

public class LineService {
    public static void addLine(String lineName, LineInputView lineInputView) {
        try {
            Line line = new Line(lineName);
            Station startStation = getStartStation(lineInputView);
            Station endStation = getEndStation(lineInputView);
            line.addStation(startStation);
            line.addStation(endStation);
            LineRepository.addLine(line);
            LineOutputView.addLineComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Station getStartStation(LineInputView lineInputView) {
        String startStationName = lineInputView.startStationName();
        return StationService.findStation(startStationName);
    }

    private static Station getEndStation(LineInputView lineInputView) {
        String endStationName = lineInputView.endStationName();
        return StationService.findStation(endStationName);
    }
}
