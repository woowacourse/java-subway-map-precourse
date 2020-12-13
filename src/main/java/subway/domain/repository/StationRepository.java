package subway.domain.repository;

import subway.domain.entity.Station;

import java.util.Collections;
import java.util.List;

public class StationRepository {

    private final List<Station> stations;

    public StationRepository(List<Station> stations) {
        this.stations = stations;
    }

    public void save(Station station) {
        stations.add(station);
    }

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }
}
