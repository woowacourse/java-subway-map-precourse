package subway.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 역 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    private final Set<Station> stations;

    public StationRepository() {
        this.stations = new LinkedHashSet<>();
    }

    public Set<Station> stations() {
        return Collections.unmodifiableSet(stations);
    }

    public void addStation(String name) {
        if (!stations.add(new Station(name))) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, name));
        }
    }

    public void deleteStation(String name) {
        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, name));
        }
    }
}
