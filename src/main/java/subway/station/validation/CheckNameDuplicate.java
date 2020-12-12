package subway.station.validation;

import subway.station.Station;
import subway.station.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckNameDuplicate {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NAME_DUPLICATE = ERROR_PREFIX + "이미 등록된 역 이름입니다.";

    public static void validation(String name) {
        List<Station> stations = StationRepository.stations();
        List<String> stationNames = new ArrayList<>();
        for (Station station : stations) {
            stationNames.add(station.getName());
        }

        if (stationNames.contains(name)) {
            throw new IllegalArgumentException(NAME_DUPLICATE);
        }
    }
}
