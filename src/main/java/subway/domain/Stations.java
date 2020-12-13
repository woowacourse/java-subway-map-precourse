package subway.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stations {
    private static final String ERR_ALREADY_ADD_STATION_NAME_MSG = "[ERROR] 이미 등록된 역명입니다.";
    private static final String ERR_NO_SUCH_NAME_STATION_MSG = "[ERROR] 해당 역이 없습니다.";

    private final List<Station> stations = new ArrayList<>();

    public void addStation(Station station) {
        if (!stations.contains(station)) {
            stations.add(station);
            return;
        }
        throw new IllegalStateException(ERR_ALREADY_ADD_STATION_NAME_MSG);
    }

    public void deleteStation(String name) {
        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new NoSuchElementException(ERR_NO_SUCH_NAME_STATION_MSG);
        }
    }

    public int size() {
        return stations.size();
    }

    public Station findStation(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(ERR_NO_SUCH_NAME_STATION_MSG));
    }

    public List<String> stationNames() {
        return stations.stream()
                .map(Station::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stations)) return false;
        Stations stations1 = (Stations) o;
        return Objects.equals(stations, stations1.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations);
    }
}
