package subway.domain.station;

import java.util.List;

public interface StationRepository {
    List<Station> stations();

    void addStation(Station station);

    Station findByName(String name);

    boolean deleteStationByName(String name);
}
