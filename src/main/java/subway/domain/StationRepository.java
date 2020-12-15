package subway.domain;

import static subway.message.ErrorMessage.STATION_REPOSITORY_STATION_ALREADY_EXIST;
import static subway.message.ErrorMessage.STATION_REPOSITORY_STATION_DOES_NOT_EXIST;
import static subway.message.ErrorMessage.STATION_REPOSITORY_STATION_HAS_PARENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) throws IllegalArgumentException {
        validateStationNameDuplicate(station.getName());
        stations.add(station);
    }

    private static void validateStationNameDuplicate(String stationName) {
        if (stations.stream().anyMatch(station -> station.getName().equals(stationName))) {
            throw new IllegalArgumentException(STATION_REPOSITORY_STATION_ALREADY_EXIST.toString());
        }
    }

    public static Optional<Station> getStationByName(String name) {
        return stations.stream().filter(station -> station.getName().equals(name)).findFirst();
    }

    public static void deleteStationByName(String name) throws IllegalArgumentException {
        final int index = validateStationExistInRepository(name);
        validateStationHasNoParent(stations.get(index));

        stations.remove(index);
    }

    private static int validateStationExistInRepository(String name) {
        AtomicInteger atomicInteger = new AtomicInteger(-1);
        boolean isAny = stations.stream()
            .peek(v -> atomicInteger.incrementAndGet())
            .anyMatch(station -> station.getName().equals(name));
        if (!isAny) {
            throw new IllegalArgumentException(
                STATION_REPOSITORY_STATION_DOES_NOT_EXIST.toString());
        }
        return atomicInteger.intValue();
    }

    private static void validateStationHasNoParent(Station station) {
        if (station.hasParentLine()) {
            throw new IllegalArgumentException(STATION_REPOSITORY_STATION_HAS_PARENT.toString());
        }
    }
}
