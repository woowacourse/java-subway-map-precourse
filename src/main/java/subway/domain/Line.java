package subway.domain;

import java.util.LinkedList;
import subway.utils.Message;
import subway.utils.Validator;

public class Line implements Message {

    private static final int ADJUST = 1;
    private final LinkedList<Station> stations = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addFirst(Station station) {
        this.stations.addFirst(station);
    }

    public void addLast(Station station) {
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

    public void insertStation(int idx, Station station) {
        int index = idx - ADJUST;
        checkDuplicateStation(station);
        if (index < 0) {
            throw new IllegalArgumentException("구간은 1부터 시작합니다.");
        }
        if (index == 0) {
            stations.addFirst(station);
            return;
        }
        if (index == this.stations.size()) {
            this.stations.addLast(station);
            return;
        }
        if (index > this.stations.size()) {
            throw new IllegalArgumentException("구간을 벗어났습니다.");
        }

        this.stations.add(index, station);
    }

    private void checkDuplicateStation(Station station) {
        if (this.stations.contains(station)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_STATION);
        }
    }
}
