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

    public static void deleteStation(String name) {
        if (isExistedStation(name)) {
            LineRepository.deleteStationOnData(name);
            stations.removeIf(station -> Objects.equals(station.getName(), name));
            return;
        }
        System.out.println(DomainErrorMessage.NO_CONTAIN_STATION);
        throw new IllegalArgumentException(DomainErrorMessage.NO_CONTAIN_STATION);
    }

    public static void checkOverlappedStation(String target) {
        if (isExistedStation(target)) {
            System.out.println(DomainErrorMessage.OVERLAP_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_STATION);
        }
    }

    public static boolean isExistedStation(String target) {
        long checkOverlapped = stations.stream()
                .filter(station -> station.compareName(target))
                .count();
        if (checkOverlapped == DomainConstant.ZERO_LONG_NUMBER) {
            return false;
        }
        return true;
    }
}
