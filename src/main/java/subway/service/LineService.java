package subway.service;

import java.util.List;
import subway.domain.Line;
import subway.repository.LineRepository;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.validation.LineValidation;

public class LineService {

    private static final int NAME_LENGTH_LIMIT = 2;
    private static final int DELETE_STATION_IN_LINE_LIMIT = 2;

    public static boolean addLine(String lineName, List<Station> stationList) {
        if (LineValidation.checkInsertLine(lineName, stationList)) {
            Line line = new Line(lineName, stationList);
            LineRepository.addLine(line);
            StationRepository.setAllStationIsRegistered(stationList);
            return true;
        }
        return false;
    }

    public static boolean deleteLine(String name) {
        if (LineValidation.checkDeleteLine(name)) {
            LineRepository.deleteLineByName(name);
            return true;
        }
        return false;
    }

    public static boolean addStationInLine(String lineName, String stationName, int order) {
        if (LineValidation.checkInsertStationInLine(lineName, stationName, order)) {
            Line line = LineRepository.findByName(lineName);
            line.addStation(StationRepository.findByName(stationName), order);
            StationRepository.setStationIsRegistered(stationName);
            return true;
        }
        return false;
    }

    public static boolean deleteStationInLine(String lineName, String stationName) {
        if(LineValidation.checkDeleteStationInLine(lineName, stationName)) {
            Line line = LineRepository.findByName(lineName);
            line.deleteStation(StationRepository.findByName(stationName));
            StationRepository.setStationIsUnregistered(stationName);
            return true;
        }
        return false;
    }

    public static List<Line> findAllLine() {
        return LineRepository.lines();
    }

    public static boolean isAlreadyExistLine(String name) {
        return LineRepository.isDuplicateLine(new Line(name, null));
    }

    public static boolean isUnderNameLength(String name) {
        return name.length() < NAME_LENGTH_LIMIT;
    }

    public static boolean isUnderDeleteLimit(String lineName) {
        return LineRepository.findByName(lineName).getStationSize() <= DELETE_STATION_IN_LINE_LIMIT;
    }

    public static boolean isStationInLine(String lineName, String stationName) {
        return LineRepository.findByName(lineName).isStationInLine(stationName);
    }

    public static boolean isOrderOutOfBounds(String lineName, int order) {
        return LineRepository.findByName(lineName).getStationSize() < order;
    }

}
