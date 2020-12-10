package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    public static final int INSERT_MINIMUM_INDEX = 1;

    public static final String DUPLICATE_NAME_ERROR = "%s은 이미 존재하는 역 이름입니다!";

    public static final String DOES_NOT_EXIST_ERROR = "%s은 존재하지 않습니다.";

    public static final String SAVED_AT_LINE_ERROR = "노선에 등록된 역은 삭제할 수 없습니다.";

    public static final String OUT_OF_BOUNDS_ERROR = "노선의 범위를 벗어난 구간입니다. 1 이상 %d 미만의 값을 입력해주세요.";

    private final List<Station> stations;

    public StationRepository() {
        this.stations = new LinkedList<>();
    }

    public StationRepository(String startStation, String finalStation) {
        this();

        addStation(startStation);
        addStation(finalStation);
    }

    public StationRepository(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public StationRepository addStation(final String stationName) {
        Station station = new Station(stationName);

        checkDuplicateStation(contains(stationName),
                String.format(DUPLICATE_NAME_ERROR, stationName));

        stations.add(station);

        return new StationRepository(stations);
    }

    public StationRepository insertStation(int index, String stationName) {
        int size = stations.size();

        if (index < INSERT_MINIMUM_INDEX || index >= size) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUNDS_ERROR, size));
        }

        checkDuplicateStation(contains(stationName),
                String.format(DUPLICATE_NAME_ERROR, stationName));

        stations.add(index, new Station(stationName));

        return new StationRepository(stations);
    }

    public StationRepository deleteStation(final String stationName,
                                           final LineRepository lineRepository) {
        checkDuplicateStation(lineRepository.contains(stationName), SAVED_AT_LINE_ERROR);

        boolean removed =
                stations.removeIf(station -> Objects.equals(station.getName(), stationName));

        if (!removed) {
            throw new IllegalArgumentException(String.format(DOES_NOT_EXIST_ERROR, stationName));
        }

        return new StationRepository(stations);
    }

    public boolean contains(String stationName) {
        return stations.contains(new Station(stationName));
    }

    private void checkDuplicateStation(boolean contains, String format) {
        if (contains) {
            throw new IllegalArgumentException(format);
        }
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
