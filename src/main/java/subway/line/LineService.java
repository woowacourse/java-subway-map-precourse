package subway.line;

import subway.line.validation.*;
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
    private static final String STATION_NUMBER_LACK = ERROR_PREFIX + "등록된 역이 2개 이하이므로 삭제할 수 없습니다.";

    public static boolean addLine(String lineName, LineInputView lineInputView) {
        try {
            Line line = new Line(lineName);
            Station startStation = getStartStation(lineInputView);
            Station endStation = getEndStation(lineInputView);
            line.addStation(startStation);
            line.addStation(endStation);
            LineRepository.addLine(line);
            LineOutputView.addLineComplete();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
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

    public static boolean deleteLine(String lineName) {
        boolean isDelete = false;
        try {
            CheckRegisteredLine.validation(lineName);
            isDelete = LineRepository.deleteLineByName(lineName);
            LineOutputView.deleteStationComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    public static boolean addSection(String lineName, LineInputView lineInputView, StationInputView stationInputView) {
        boolean isAdd = false;
        try {
            Line line = findLine(lineName);
            Station station = getSectionStation(line, stationInputView);
            int sectionNumber = getSectionPosition(line, lineInputView);
            line.addSection(station, sectionNumber);
            isAdd = true;
            LineOutputView.addSectionComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isAdd;
    }

    private static Station getSectionStation(Line line, StationInputView stationInputView) {
        String stationName = stationInputView.stationName();
        CheckAlreadyRegisteredStation.validation(line, stationName);
        return StationService.findStation(stationName);
    }

    private static int getSectionPosition(Line line, LineInputView lineInputView) {
        String number = lineInputView.sectionNumber();
        CheckRightSectionNumber.validation(line, number);
        return Integer.parseInt(number);
    }

    public static Line findLine(String lineName) {
        Line line = LineRepository.findByName(lineName);
        if (line == null) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
        return line;
    }

    public static boolean deleteSection(String lineName, StationInputView stationInputView) {
        boolean isDelete = false;
        try {
            Line line = findLine(lineName);
            Station station = getDeleteSectionStation(line, stationInputView);
            isDelete = line.deleteSection(station);
            if (!isDelete) {
                throw new IllegalArgumentException(STATION_NUMBER_LACK);
            }
            LineOutputView.deleteSectionComplete();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDelete;
    }

    private static Station getDeleteSectionStation(Line line, StationInputView stationInputView) {
        String stationName = stationInputView.stationSectionName();
        CheckNotExistStation.validation(line, stationName);
        return StationService.findStation(stationName);
    }

    public static void printAllLineInformation() {
        List<Line> lines = LineRepository.lines();

        for (Line line : lines) {
            String lineName = line.getName();
            EachLineStations stations = line.getStations();
            LineOutputView.printLineInformation(lineName, stations);
        }
    }

    public static boolean printAllLine() {
        List<Line> lines = LineRepository.lines();
        LineOutputView.printAllLine(lines);
        return true;
    }
}
