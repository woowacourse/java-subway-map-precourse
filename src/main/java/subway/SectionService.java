package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionService {

    private static final int DELETE_MIN_SIZE = 2;
    private static final String THREE_MINUS = "---";

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

    private static boolean isNotDeleteSize(Line line) {
        if (line.lineInStationList().size() <= DELETE_MIN_SIZE) {
            OutPut.printSectionDeleteSizeError();
            return true;
        }
        return false;
    }

    public static boolean deleteSection(String lineName, String stationName) {
        if (isNotExistLineAndStation(lineName, stationName)) {
            return false;
        }
        Line line = LineRepository.getLine(lineName);
        if (isNotDeleteSize(line)) {
            return false;
        }
        if (!line.deleteLineByName(stationName)) {
            OutPut.printNonExistStationError(stationName);
            return false;
        }
        OutPut.printSectionDeleteMessage();
        return true;
    }

    public static void print() {
        for (Line line : LineRepository.lines()) {
            OutPut.printName(line.getName());
            OutPut.printName(THREE_MINUS);
            for (Station station : line.lineInStationList()) {
                OutPut.printName(station.getName());
            }
            OutPut.printNextLine();
        }
    }
}
