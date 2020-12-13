package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Stations {
    private final List<Station> stations = new ArrayList<>();

    public void addStation(Station station) {
        if (!stations.contains(station)) {
            stations.add(station);
            return;
        }
        throw new IllegalStateException("[ERROR] 이미 등록된 역명입니다.");
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public int size() {
        return stations.size();
    }

    public Station findStation(String name) {
        return stations.stream()
                .filter(s -> s.equals(new Station(name)))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("[ERROR] 해당 역이 없습니다."));
    }
}
