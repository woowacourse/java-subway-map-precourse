package subway.station;

import subway.domain.Station;

import java.util.*;

public class StationRepositoryJava implements StationRepository {
    private static final StationRepositoryJava singleton = new StationRepositoryJava();
    private static final Set<Station> stations = new HashSet<>();

    private StationRepositoryJava(){}

    public static StationRepositoryJava get(){
        return singleton;
    }

    @Override
    public Set<Station> stations() {
        return new HashSet<>(stations);
    }

    @Override
    public void addStation(Station station) {
        stations.add(station);
    }

    @Override
    public void deleteStation(Station station) {
        stations.remove(station);
    }

    @Override
    public Optional<Station> findStationByName(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny();
    }
}
