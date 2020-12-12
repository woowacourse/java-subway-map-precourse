package subway.line;

import subway.line.validation.CheckRegisteredLine;
import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.station.Station;
import subway.station.StationService;
import subway.station.validation.CheckLastLetter;

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
        CheckLastLetter.validation(startStationName);
        return StationService.findStation(startStationName);
    }

    private static Station getEndStation(LineInputView lineInputView) {
        String endStationName = lineInputView.endStationName();
        CheckLastLetter.validation(endStationName);
        return StationService.findStation(endStationName);
    }

    public static void deleteLine(String lineName) {
        try {
            CheckRegisteredLine.validation(lineName);
            LineRepository.deleteLineByName(lineName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
