package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LineStations {
    private final List<Station> stations;

    private LineStations(Station start, Station end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException("상행 종점과 하행 종점이 같을 수 없습니다.");
        }

        stations = new LinkedList<>();
        stations.add(0, start);
        stations.add(stations.size(), end);
    }

    public static LineStations create(Station start, Station end) {
        return new LineStations(start, end);
    }

    public void addStation(Order order, Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("이미 노선에 포함된 역입니다.");
        }

        if (order.getIndex() > stations.size()) {
            throw new IllegalArgumentException("유효하지 않은 순서 입력입니다.");
        }

        stations.add(order.getIndex(), station);

        station.onLine();
    }

    public void deleteSection(Station station) {
        if (!stations.contains(station)) {
            throw new IllegalArgumentException("해당 노선에 존재하지 않는 역입니다.");
        }

        stations.remove(station);
        station.outOfLine();
    }

    public void removeAll() {
        stations.stream().forEach(Station::outOfLine);
    }

    public List<String> getStationNames() {
        return stations.stream()
                .map(Station::toString)
                .collect(Collectors.toList());
    }
}

