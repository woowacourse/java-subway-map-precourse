package subway.domain;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StationRepository {

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 역 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    public static final String SAVED_AT_LINE_ERROR = "노선에 등록된 역은 삭제할 수 없습니다.";

    private final Set<Station> stations;

    public StationRepository() {
        this.stations = new LinkedHashSet<>();
    }

    public StationRepository(String startStation, String finalStation) {
        this();

        addStation(startStation);
        addStation(finalStation);
    }


    public Set<Station> stations() {
        return Collections.unmodifiableSet(stations);
    }

    public void addStation(final String name) {
        if (!stations.add(new Station(name))) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, name));
        }
    }

    public void deleteStation(final String name, final LineRepository lineRepository) {
        if (lineRepository.contains(name)) {
            throw new IllegalArgumentException(SAVED_AT_LINE_ERROR);
        }

        if (!stations.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, name));
        }
    }

    public boolean contains(String stationName) {
        return stations.contains(new Station(stationName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof StationRepository)) { return false; }
        StationRepository that = (StationRepository) o;
        return Objects.equals(stations, that.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations);
    }
}
