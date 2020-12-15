package subway.repository.station;

import subway.domain.station.Station;
import subway.domain.station.StationName;

import java.util.List;

public interface StationRepository {
    List<Station> stations();
    void addStation(Station station);
    boolean deleteStation(StationName name);
    Station getStationByName(StationName name);
}
