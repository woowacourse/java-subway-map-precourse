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
        if (StationRepository.isEqualStationName(name)) {
            // TODO - 역 중복관련 메시지 출력함수 호출하기
            return false;
        }
        StationRepository.addStation(new Station(name));
        OutPut.printStationCreateMessage();
        return true;
    }
}
