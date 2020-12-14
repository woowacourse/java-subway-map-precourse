package subway.line;

import subway.line.validation.*;
import subway.station.Station;
import subway.station.StationService;
import subway.view.InputView;
import subway.view.line.LineManagementView;
import subway.view.subwaymap.SubwayMapView;

import java.util.List;

public class LineService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 노선입니다.";

    public static boolean addLine(String lineName, InputView inputView) {
        boolean isAdd = false;
        try {
            Line line = new Line(lineName);
            Station startStation = getStartStation(inputView);
            Station endStation = getEndStation(inputView);
            line.addStation(startStation);
            line.addStation(endStation);
            LineRepository.addLine(line);
            isAdd = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isAdd;
    }

    private static Station getStartStation(InputView inputView) {
        LineManagementView.askStartStationName();
        String startStationName = inputView.stationName();
        return StationService.findStation(startStationName);
    }

    private static Station getEndStation(InputView inputView) {
        LineManagementView.askEndStationName();
        String endStationName = inputView.stationName();
        return StationService.findStation(endStationName);
    }

    public static boolean deleteLine(String lineName) {
        boolean isDelete = false;
        try {
            CheckRegisteredLine.validation(lineName);
            isDelete = LineRepository.deleteLineByName(lineName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    public static Line findLine(String lineName) {
        Line line = LineRepository.findByName(lineName);
        if (line == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
        return line;
    }

    public static void printAllLineInformation() {
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            String lineName = line.getName();
            EachLineStations stations = line.getStations();
            SubwayMapView.showLineInformation(lineName, stations);
        }
    }

    public static boolean printAllLine() {
        List<Line> lines = LineRepository.lines();
        LineManagementView.showAllLine(lines);
        return true;
    }
}
