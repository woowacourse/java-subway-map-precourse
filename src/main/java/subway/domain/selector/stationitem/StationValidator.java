package subway.domain.selector.stationitem;

import java.util.List;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class StationValidator {

    public static final int MIN_NAME_LENGTH = 2;
    public static final String DUPLICATE_STATION_NAME_ERROR = "[ERROR] 이미 등록되어있는 역 입니다.";
    public static final String UNDER_NAME_LENGTH_ERROR = "[ERROR] 역 이름은 2글자 이상이어야 합니다.";

    public void validateAddStation(String name) {
        validateNameDuplication(name);
        validateNameLength(name);
    }

    private void validateNameDuplication(String name) {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                throw new IllegalArgumentException(DUPLICATE_STATION_NAME_ERROR);
            }
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(UNDER_NAME_LENGTH_ERROR);
        }
    }

}
