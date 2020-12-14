package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.SubwayProgramException;

import java.util.*;
import java.util.stream.Collectors;

public class Line {
    private static final int MIN_INDEX = 1;
    private static final int MIN_STATIONS_SIZE = 2;
    private static final String INDEX_RANGE_ERROR = "순서의 범위를 벗어났습니다. 1 ~ %d 까지 입력 가능합니다.";
    private static final String STATIONS_SIZE_ERROR = "노선에 포함된 역이 2개 이하일 때는 제거할 수 없습니다.";

    private final List<Station> stations;
    private final LineName lineName;

    private Line(LineName lineName, List<Station> stations) {
        this.lineName = lineName;
        this.stations = stations;
    }

    public LineName getName() {
        return lineName;
    }

    // 추가 기능 구현
    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public static Line of(LineName lineName, StationName upLastStationName, StationName downLastStationName) {
        Station upLastStation = Station.of(upLastStationName);
        Station downLastStation = Station.of(downLastStationName);
        List<Station> stations = new LinkedList<>(Arrays.asList(upLastStation, downLastStation));
        return new Line(lineName, stations);
    }

    public static Line of(LineName lineName, List<StationName> stationNames) {
        List<Station> stations = stationNames.stream()
                .map(Station::of)
                .collect(Collectors.toCollection(LinkedList::new));
        return new Line(lineName, stations);
    }

    public void addStationInLine(Station newStation, int index) {
        if (!isIndexInRange(index)) {
            throw new SubwayProgramException(String.format(INDEX_RANGE_ERROR, stations.size() + 1));
        }
        stations.add(index - 1, newStation);
    }

    private boolean isIndexInRange(int index) {
        return ((index >= MIN_INDEX) && (index <= stations.size() + 1));
    }

    public void deleteStationToLine(Station station) {
        if (stations.size() <= MIN_STATIONS_SIZE) {
            throw new SubwayProgramException(STATIONS_SIZE_ERROR);
        }
        stations.remove(station);
    }

    public boolean hasStationInLine(StationName stationName) {
        return stations.contains(Station.of(stationName));
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
