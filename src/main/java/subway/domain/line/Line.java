package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MIN_INDEX = 1;
    private static final int MIN_STATIONS_SIZE = 2;
    private static final String INDEX_RANGE_ERROR = "\n[ERROR] 순서의 범위를 벗어났습니다. 1 ~ %d 까지 입력 가능합니다.";
    private static final String STATION_DUPLICATE_ERROR = "\n[ERROR] 이미 노선에 해당 역이 동록되어 있습니다.";
    private static final String STATION_EXIST_ERROR = "\n[ERROR] 노선에 해당 역이 존재하지 않습니다.";
    private static final String STATIONS_SIZE_ERROR = "\n[ERROR] 노선에 포함된 역이 2개 이하일 때는 제거할 수 없습니다.";

    private List<Station> stations;
    private final LineName lineName;

    private Line(LineName lineName) {
        this.lineName = lineName;
        stations = new ArrayList<>();
    }

    public LineName getName() {
        return lineName;
    }

    // 추가 기능 구현
    public List<Station> getStations() {
        return stations;
    }

    public static Line createLine(LineName lineName, StationName firstStationName, StationName lastStationName) {
        Line line = new Line(lineName);
        Station firstStation = Station.of(firstStationName);
        Station lastStation = Station.of(lastStationName);
        line.addStationToLine(firstStation, 1);
        line.addStationToLine(lastStation, 2);
        return line;
    }

    public static Line of(LineName lineName) {
        return new Line(lineName);
    }

    public void addStationToLine(Station newStation, int index) {
        validateIndexRange(index);
        stations.add(index - 1, newStation);
    }

    public void deleteStationToLine(Station station) {
        if (stations.size() <= MIN_STATIONS_SIZE) {
            throw new IllegalArgumentException(STATIONS_SIZE_ERROR);
        }
        stations.remove(station);
    }

    private void validateIndexRange(int index) {
        if (index < MIN_INDEX || index > stations.size() + 1) {
            throw new IllegalArgumentException(String.format(INDEX_RANGE_ERROR, stations.size() + 1));
        }
    }

    public void validateDuplicateStationToLine(Station newStation) {
        if (stations.contains(newStation)) {
            throw new IllegalArgumentException(STATION_DUPLICATE_ERROR);
        }
    }

    public boolean hasStationToLine(StationName stationName) {
        if (!stations.contains(Station.of(stationName))) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lineName, line.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineName);
    }
}
