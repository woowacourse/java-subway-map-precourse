package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import subway.controller.ManagementController;
import subway.exception.AlreadyExistsException;
import subway.exception.AlreadySavedAtLineException;
import subway.exception.NotFoundElementException;
import subway.exception.RangeIndexOutOfBoundsException;
import subway.exception.TooLessStationException;

public final class StationRepository {

    public static final int MINIMUM_INDEX = 0;

    public static final int MINIMUM_STATION_SIZE = 2;

    private final List<Station> stations;

    public StationRepository() {
        this.stations = new LinkedList<>();
    }

    public StationRepository(final List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public StationRepository addStations(final String... stationNames) {
        StationRepository stationRepository = new StationRepository();

        for (String stationName : stationNames) {
            stationRepository = add(stations.size(), stationName);
        }

        return stationRepository;
    }

    public StationRepository addStation(final String stationName) {
        return add(stations.size(), stationName);
    }

    public StationRepository addRange(final int index, final String stationName) {
        int size = stations.size();

        boolean canInsert = (index > MINIMUM_INDEX) && (index < size);

        if (!canInsert) {
            throw new RangeIndexOutOfBoundsException(size);
        }

        return add(index, stationName);
    }

    public StationRepository removeStation(final String stationName,
                                           final LineRepository lineRepository) {
        if (lineRepository.contains(stationName)) {
            throw new AlreadySavedAtLineException();
        }

        return remove(stationName);
    }

    public StationRepository removeRange(final String stationName) {
        boolean canRemove = stations.size() > MINIMUM_STATION_SIZE;

        if (!canRemove) {
            throw new TooLessStationException();
        }

        return remove(stationName);
    }

    public boolean contains(final String stationName) {
        return stations.contains(new Station(stationName));
    }

    public List<String> stationNames() {
        return stations.stream().map(Station::getName).collect(Collectors.toList());
    }

    private StationRepository add(final int index, final String stationName) {
        if (contains(stationName)) {
            throw new AlreadyExistsException(stationName, ManagementController.STATION);
        }

        stations.add(index, new Station(stationName));

        return new StationRepository(stations);
    }

    private StationRepository remove(final String stationName) {
        boolean removed =
                stations.removeIf(station -> Objects.equals(station.getName(), stationName));

        if (!removed) {
            throw new NotFoundElementException(stationName);
        }

        return new StationRepository(stations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof StationRepository)) { return false; }
        StationRepository that = (StationRepository) o;
        return Objects.equals(stations, that.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations);
    }
}
