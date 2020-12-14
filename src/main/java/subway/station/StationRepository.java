package subway.station;

import subway.domain.Station;

import java.util.Optional;
import java.util.Set;

public interface StationRepository {
    Set<Station> stations();

    void addStation(Station station);

    void deleteStation(Station station);

    Optional<Station> findStationByName(String name);
}
