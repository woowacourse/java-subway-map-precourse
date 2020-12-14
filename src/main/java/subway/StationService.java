package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationService {

    public static final int MIN_STATION_NAME_LENGTH = 2;

    public static boolean addStation(String name) {

        if (name.length() < MIN_STATION_NAME_LENGTH) {
            OutPut.printStationNameLengthError();
            return false;
        }
        StationRepository.addStation(new Station(name));
        // TODO - 완료출력함수 호출하기
        return true;
    }
}
