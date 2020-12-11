package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    public List<Station> stations(){
        return Collections.unmodifiableList(stations);
    }

    public void joinStation(Station station, int index) {
        if (!isCorrectIndex(index)) {
        }
        int newIndex = index - 1;   //1을 입력하면 0 번째 인덱스를 가르킨다.
        stations.add(newIndex, station);
        station.addLine();
    }

    public boolean isCorrectIndex(int index) {
        int minIndex = 1;
        int maxIndex = stations.size() + 1;
        return index >= minIndex && index <= maxIndex;
    }

    public void removeStation(Station station) {
        stations.remove(station);
        station.removeLine();
    }

    public boolean isStationRemovable() {
        return stations.size() > MIN_STATION_SIZE;
    }

    public int stationSize(){
        return stations.size();
    }

    public boolean containsStation(Station station) {
        return stations.contains(station);
    }

    public void removeAllStation(){
        stations.forEach(this::removeStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return getName().equals(line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
