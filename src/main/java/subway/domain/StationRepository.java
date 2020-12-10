package subway.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    public static final String DUPLICATE_NAME = "이미 존재하는 이름입니다.";

    private final Set<Station> stations;

    public StationRepository() {
        this.stations = new LinkedHashSet<>();
    }

    public Set<Station> stations() {
        return Collections.unmodifiableSet(stations);
    }

    public void addStation(Station station) {
        if (!stations.add(station)) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
