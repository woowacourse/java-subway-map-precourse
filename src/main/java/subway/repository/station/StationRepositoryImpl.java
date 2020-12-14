package subway.repository.station;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.station.StationNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepositoryImpl implements StationRepository {
    private final List<Station> stations = new ArrayList<>();

    @Override
    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }



    @Override
    public boolean deleteStation(StationName name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    @Override
    public Station getStationByName(StationName name) {
        Station goalStation = stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findAny()
                .orElseThrow(() -> new StationNotFoundException());

        return goalStation;
    }
}
