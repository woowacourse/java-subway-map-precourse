package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionService {

    private static final int DELETE_MIN_SIZE = 2;

    private static boolean isNotExistLineAndStation(String lineName, String stationName) {
        if (!LineRepository.isEqualLineName(lineName)) {
            OutPut.printNonExistLineError();
            return true;
        }
        if (!StationRepository.isEqualStationName(stationName)) {
            OutPut.printNonExistStationError(stationName);
            return true;
        }
        return false;
    }

    private static boolean isExistStation(Line line, String stationName) {
        if (line.isExistStation(stationName)) {
            OutPut.printExistStationError();
            return true;
        }
        return false;
    }

    public static boolean addSection(String lineName, String stationName, int stationIndex,
        boolean isPrint) {
        if (isNotExistLineAndStation(lineName, stationName)) {
            return false;
        }
        Line line = LineRepository.getLine(lineName);
        if (isExistStation(line, stationName)) {
            return false;
        }
        Station station = StationRepository.getStation(stationName);
        line.insertLineInStation(station, stationIndex);
        if (isPrint) {
            OutPut.printSectionAddMessage();
        }
        return true;
    }

}
