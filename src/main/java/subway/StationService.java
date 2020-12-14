package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static final int MIN_STATION_NAME_LENGTH = 2;

    public static boolean addStation(String name, boolean isPrint) {
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
}