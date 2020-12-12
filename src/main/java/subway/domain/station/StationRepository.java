package subway.domain.station;

import java.util.List;

public interface StationRepository {
    List<Station> stations();

    Station addStation(Station station);

    Station findByName(String name);

    boolean deleteStationByName(String name);

    void removeAll();
}
