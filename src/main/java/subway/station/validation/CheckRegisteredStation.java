package subway.station.validation;

import subway.station.Station;
import subway.station.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class CheckRegisteredStation {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String NOT_EXIST = ERROR_PREFIX + "등록되지 않은 역입니다.";

    public static void validation(String name) {
        List<Station> stations = StationRepository.stations();
        List<String> stationNames = new ArrayList<>();

        for (Station station : stations) {
            stationNames.add(station.getName());
        }

        if (!stationNames.contains(name)) {
            throw new IllegalArgumentException(NOT_EXIST);
        }
    }
}
