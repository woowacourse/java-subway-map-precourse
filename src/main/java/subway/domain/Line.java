package subway.domain;

import java.util.LinkedList;
import subway.utils.Message;

public class Line implements Message {

    private static final int ADJUST = 1;
    private static final int MIN_SIZE = 2;
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
        checkDuplicateStation(station);
        this.stations.addLast(station);
    }

    public boolean hasStation(String name) {
        for (Station station : this.stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void insertStation(int index, Station station) {

        checkDuplicateStation(station);
        if (index < 1) {
            throw new IllegalArgumentException("구간은 1부터 시작합니다.");
        }

        if (index > this.stations.size() - ADJUST) {
            throw new IllegalArgumentException("구간을 벗어났습니다.");
        }

        this.stations.add(index, station);
    }

    public void removeStation(Station station) {

        if (this.stations.size() <= MIN_SIZE) {
            throw new IllegalArgumentException("구간에 등록된 역은 2개 이하가 될 수 없습니다.");
        }

        boolean deleted = this.stations.remove(station);
        if (!deleted) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
    }

    private void checkDuplicateStation(Station station) {
        if (this.stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_STATION);
        }
    }

    public void setStations(Station... stations) {
        for (Station station : stations) {
            this.addLast(station);
        }
    }

}
