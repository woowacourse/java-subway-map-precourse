package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineService {

    public static final int MIN_LINE_NAME_LENGTH = 2;

    public static boolean addLine(String lineName, String firstStationName, String lastStationName,
        boolean isPrint) {
        if (lineName.length() < MIN_LINE_NAME_LENGTH) {
            OutPut.printLineLengthError();
            return true;
        }
        if (LineRepository.isEqualLineName(lineName)) {
            OutPut.printLineDuplicateError();
            return true;
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
