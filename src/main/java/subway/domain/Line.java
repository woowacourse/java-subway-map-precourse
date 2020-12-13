package subway.domain;

import java.util.LinkedList;
import subway.utils.Message;
import subway.utils.Validator;

public class Line implements Message {

    private final LinkedList<Station> stations = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    public void addFirst(Station station) {
        this.stations.addFirst(station);
    }

    public void addLast(Station station) {
        Validator.checkDuplicateStation(this.stations, station);
        this.stations.addLast(station);
    }

    public boolean hasStation(String name) {
        return this.stations.stream()
            .anyMatch(station -> station.getName().equals(name));
    }

    public void insertStation(int index, Station station) {
        Validator.checkDuplicateStation(this.stations, station);
        Validator.checkMinIndex(index);
        Validator.checkValidRange(this.stations, index);

        this.stations.add(index, station);
    }

    public void removeStation(Station station) {
        Validator.checkMinSizeStationsInLine(this.stations);

        boolean deleted = this.stations.remove(station);
        if (!deleted) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
    }
}
