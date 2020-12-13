package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stations {
    private final List<Station> stations = new ArrayList<>();

    public void addStation(Station station) {
        if (!stations.contains(station)) {
            stations.add(station);
        }
        throw new IllegalStateException("[ERROR] 이미 등록된 역명입니다.");
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
