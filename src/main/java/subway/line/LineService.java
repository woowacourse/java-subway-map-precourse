package subway.line;

import subway.line.validation.CheckRegisteredLine;
import subway.line.validation.CheckRightSectionNumber;
import subway.line.view.LineInputView;
import subway.line.view.LineOutputView;
import subway.station.Station;
import subway.station.StationService;
import subway.station.validation.CheckLastLetter;
import subway.station.view.StationInputView;

import java.util.List;

public class LineService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 노선입니다.";

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
            LineOutputView.deleteStationComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addSection(String lineName, LineInputView lineInputView, StationInputView stationInputView) {
        try {
            Line line = findLine(lineName);
            Station station = getSectionStation(stationInputView);
            int sectionNumber = getSectionPosition(line, lineInputView);
            line.addSection(station, sectionNumber);
            LineOutputView.addSectionComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Station getSectionStation(StationInputView stationInputView) {
        String stationName = stationInputView.stationName();
        return StationService.findStation(stationName);
    }

    private static int getSectionPosition(Line line, LineInputView lineInputView) {
        String number = lineInputView.sectionNumber();
        CheckRightSectionNumber.validation(line, number);
        return Integer.parseInt(number);
    }

    public static Line findLine(String lineName) {
        List<Line> lines = LineRepository.lines();
        Line findLine = null;

        for (Line line : lines) {
            String name = line.getName();
            if (name.equals(lineName)) {
                findLine = line;
                break;
            }
        }

        if (findLine == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }

        return findLine;
    }
}
