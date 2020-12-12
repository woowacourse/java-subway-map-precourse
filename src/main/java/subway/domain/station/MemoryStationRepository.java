package subway.domain.station;

import subway.exception.ErrorCode;
import subway.exception.StationException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemoryStationRepository implements StationRepository {
    private static final Map<String, Station> stations = new ConcurrentHashMap<>();

    private MemoryStationRepository() {
    }

    public static MemoryStationRepository of() {
        return new MemoryStationRepository();
    }

    @Override
    public List<Station> stations() {
        return stations.values().stream().collect(Collectors.toList());
    }

    @Override
    public Station addStation(Station station) {
        stations.put(station.getName(), station);
        return station;
    }

    @Override
    public Station findByName(String name) {
        Station station = stations.get(name);
        return station;
    }

    @Override
    public boolean deleteStationByName(String name) {
        if (stations.containsKey(name)) {
            stations.remove(name);
            return true;
        }
        return false;
    }

    @Override
    public void removeAll() {
        stations.clear();
    }
}
