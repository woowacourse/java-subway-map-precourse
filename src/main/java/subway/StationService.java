package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static final int MIN_STATION_NAME_LENGTH = 2;

    public static boolean addStation(String name, boolean isPrint) {
        // TODO - 조건검사 함수 분리하기
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            OutPut.printStationNameLengthError();
            return false;
        }
        if (StationRepository.isEqualStationName(name)) {
            OutPut.printStationNameDuplicateError();
            return false;
        }
        StationRepository.addStation(new Station(name));
        if (isPrint) {
            OutPut.printStationCreateMessage();
        }
        return true;
    }

    public static boolean deleteStation(String name) {
        if (StationRepository.isExistByLineInStation(name)) {
            OutPut.printStationDeleteError();
            return false;
        }
        if (!StationRepository.deleteStation(name)) {
            OutPut.printNonExistStationError(name);
            return false;
        }
        OutPut.printStationDeleteMessage();
        return true;
    }

    public static void print() {
        for (Station station : StationRepository.stations()) {
            OutPut.printName(station.getName());
        }
    }
}