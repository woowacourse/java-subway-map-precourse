package subway.domain;

import subway.exception.SubwayException;

import static subway.util.TextConstant.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Stations {
    private final List<Station> stations = new ArrayList<>();

    public void addStation(Station station) {
        if (!stations.contains(station)) {
            stations.add(station);
            return;
        }
        throw new SubwayException(ERR_ALREADY_ADD_STATION_NAME_MSG);
    }

    public void deleteStation(String name) {
        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new SubwayException(ERR_NO_SUCH_NAME_STATION_MSG);
        }
    }

    public int size() {
        return stations.size();
    }

    public Station findStation(String name) {
        return stations.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findFirst()
                .orElseThrow(() -> new SubwayException(ERR_NO_SUCH_NAME_STATION_MSG));
    }

    public List<String> stationNames() {
        return stations.stream()
                .map(Station::getName)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public boolean isPresentStation(Station station) {
        return stations.contains(station);
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

    @Override
    public String toString() {
        return "Stations{" +
                "stations=" + stations +
                '}';
    }
}
