package subway.domain.station;

import java.util.List;

public interface StationRepository {
    Station addStation(Station station);

    Station findByName(String name);

    List<Station> stations();

    boolean deleteStationByName(String name);

    void removeAll();
}
