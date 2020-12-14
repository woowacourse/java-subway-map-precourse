package subway.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private final List<Station> stations = new ArrayList<>();

    public List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public void checkDuplicateStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                throw new IllegalArgumentException("이미 등록된 역 이름입니다.");
            }
        }
    }

    public void checkStationExist(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return;
            }
        }
        throw new IllegalArgumentException("존재하지 않는 역입니다.");
    }
}
