package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        checkOverlappedStation(station.getName());
        stations.add(station);
        Collections.sort(stations);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void checkOverlappedStation(String target) {
        long isOverlap = stations.stream()
                .filter(station -> station.compareName(target))
                .count();
        if (isOverlap != DomainConstant.ZERO_LONG_NUMBER) {
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_LINE_ERROR);
        }
    }
}
