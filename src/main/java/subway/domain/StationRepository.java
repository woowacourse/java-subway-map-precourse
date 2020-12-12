package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class StationRepository {

    public static final int MINIMUM_INDEX = 0;

    public static final int MINIMUM_STATION_SIZE = 2;

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 역 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    public static final String SAVED_AT_LINE_ERROR = "노선에 등록된 역은 삭제할 수 없습니다.";

    public static final String OUT_OF_BOUNDS_ERROR = "노선의 범위를 벗어난 구간입니다. %d 초과 %d 미만의 값을 입력해주세요.";

    public static final String TOO_LESS_STATIONS_ERROR = "역이 %d개 이하인 노선의 역은 제거할 수 업습니다";

    private final List<Station> stations;

    public StationRepository() {
        this.stations = new LinkedList<>();
    }

    public StationRepository(final List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public StationRepository addStation(final String stationName) {
        return insert(stations.size(), stationName);
    }

    public StationRepository insertStation(final int index, final String stationName) {
        int size = stations.size();

        boolean canInsert = (index > MINIMUM_INDEX) && (index < size);

        if (!canInsert) {
            throw new IllegalArgumentException(
                    String.format(OUT_OF_BOUNDS_ERROR, MINIMUM_INDEX, size));
        }

        return insert(index, stationName);
    }

    public StationRepository removeStation(final String stationName) {
        boolean canRemove = stations.size() > MINIMUM_STATION_SIZE;

        if (!canRemove) {
            throw new IllegalArgumentException(
                    String.format(TOO_LESS_STATIONS_ERROR, MINIMUM_STATION_SIZE));
        }

        return remove(stationName);
    }

    public StationRepository removeStation(final String stationName,
                                           final LineRepository lineRepository) {
        if (lineRepository.contains(stationName)) {
            throw new IllegalArgumentException(SAVED_AT_LINE_ERROR);
        }

        return remove(stationName);
    }

    public boolean contains(final String stationName) {
        return stations.contains(new Station(stationName));
    }

    public List<String> stationNames() {
        return stations.stream().map(Station::getName).collect(Collectors.toList());
    }

    private StationRepository insert(final int index, final String stationName) {
        if (contains(stationName)) {
            throw new IllegalArgumentException(String.format(DUPLICATE_NAME_ERROR, stationName));
        }

        stations.add(index, new Station(stationName));

        return new StationRepository(stations);
    }

    private StationRepository remove(final String stationName) {
        boolean removed =
                stations.removeIf(station -> Objects.equals(station.getName(), stationName));

        if (!removed) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, stationName));
        }

        return new StationRepository(stations);
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
