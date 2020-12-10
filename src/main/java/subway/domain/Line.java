package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private static final int MIN_STATION_SIZE = 2;
    private String name;
    private List<Station> stations;

    private Line(String name, Station start, Station end) {
        this.name = name;
        stations = new LinkedList<>();
        stations.add(start);
        stations.add(end);
        start.addLine();
        end.addLine();
    }

    public static Line of(String name, Station start, Station end) {
        return new Line(name, start, end);
    }

    public String getName() {
        return name;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void joinStation(Station station, int index) {
        if (!isCorrectIndex(index)) {
            final String errorMessage = "순서가 너무 큽니다. 등록되어 있는 역 수 : %d";
            throw new IllegalStateException(String.format(errorMessage, stations.size()));
        }
        int newIndex = index - 1;   //1을 입력하면 0 번째 인덱스를 가르킨다.
        stations.add(newIndex, station);
        station.addLine();
    }

    private boolean isCorrectIndex(int index) {
        int minIndex = 1;
        int maxIndex = stations.size() + 1;
        return index >= minIndex && index <= maxIndex;
    }

    public void removeStation(Station station) {
        if (!isStationRemovable()) {
            final String errorMessage = "노선을 유지하려면 최소 둘 이상의 역이 등록되어 있어야 합니다.";
            throw new IllegalStateException(errorMessage);
        }
        station.removeLine();
        stations.remove(station);
    }

    private boolean isStationRemovable() {
        return stations.size() > MIN_STATION_SIZE;
    }

}
