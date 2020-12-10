package subway.domain.station;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemoryStationRepository implements StationRepository {
    private static Map<String, Station> stations = new ConcurrentHashMap<>();

    @Override
    public List<Station> stations() {
        return stations.values().stream().collect(Collectors.toList());
    }

    @Override
    public void addStation(Station station) {
        stations.put(station.getName(), station);
    }

    @Override
    public boolean deleteStationByName(String name) {
        if (stations.containsKey(name)) {
            stations.remove(name);
            return true;
        }
        return false;
    }

}
