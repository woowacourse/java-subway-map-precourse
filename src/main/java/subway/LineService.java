package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {

    public static final int MIN_LINE_NAME_LENGTH = 2;

    private static boolean isNotLineNameState(String lineName) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            OutPut.printLineLengthError();
            return true;
        }
        if (LineRepository.isEqualLineName(lineName)) {
            OutPut.printLineDuplicateError();
            return true;
        }
        return false;
    }

    private static boolean isNotExistStation(String firstStationName, String lastStationName) {
        if (!StationRepository.isEqualStationName(firstStationName)) {
            OutPut.printNonExistStationError(firstStationName);
            return true;
        }
        if (!StationRepository.isEqualStationName(lastStationName)) {
            OutPut.printNonExistStationError(lastStationName);
            return true;
        }
        return false;
    }

    public static boolean addLine(String lineName, String firstStationName, String lastStationName,
        boolean isPrint) {
        if (isNotLineNameState(lineName) || isNotExistStation(firstStationName, lastStationName)) {
            return false;
        }
        Station firstStation = StationRepository.getStation(firstStationName);
        Station lastStation = StationRepository.getStation(lastStationName);
        Line line = new Line(lineName);
        line.initLineInStation(firstStation, lastStation);
        LineRepository.addLine(line);
        if (isPrint) {
            OutPut.printLineCreateMessage();
        }
        return true;
    }
}
