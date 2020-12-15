package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    public static final String ERROR_NO_POSITIVE_NUMBER = "양수를 입력해야 합니다.";
    public static final String ERROR_FIRST_POSITION = "상행 종점 자리에는 역을 추가할 수 없습니다.";
    public static final String ERROR_EXCESS_POSITION_RANGE = "노선 범위 내의 값을 입력해야 합니다.";
    public static final String ERROR_EXISTENCE_IN_LINE = "해당 역이 노선에 이미 등록되어 있습니다.";
    public static final String ERROR_NOT_FOUND_IN_LINE = "해당 역이 노선에 등록되어있지 않습니다.";
    public static final int POSITION_VALUE_MIN = 1;
    public static final int NONE = 0;
    private String name;
    private List<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(this.stations);
    }

    public List<String> getStationsNames() {
        return this.stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    public void checkStationInLineToAdd(String stationToFind) {
        int useCount = (int) this.stations.stream()
                .filter(station -> station.getName().equals(stationToFind))
                .count();

        if (useCount != NONE) {
            throw new IllegalArgumentException(ERROR_EXISTENCE_IN_LINE);
        }
    }

    public void checkStationInLineToDelete(String stationToFind) {
        int useCount = (int) this.stations.stream()
                .filter(station -> station.getName().equals(stationToFind))
                .count();

        if (useCount == NONE) {
            throw new IllegalArgumentException(ERROR_NOT_FOUND_IN_LINE);
        }
    }

    public void addUpAndDownWardStations(Station upward, Station downward) {
        this.stations.add(upward);
        this.stations.add(downward);
    }

    public void insertStation(int position, Station station) {
        validatePositiveNumber(position);
        validateFirstPosition(position);
        validateExcessPositionRange(position);
        this.stations.add(position - 1, station);
    }

    public void deleteStation(Station Station) {
        this.stations.remove(Station);
    }

    private void validatePositiveNumber(int position) {
        if (position < POSITION_VALUE_MIN) {
            throw new IllegalArgumentException(ERROR_NO_POSITIVE_NUMBER);
        }
    }

    private void validateFirstPosition(int position) {
        if (position == POSITION_VALUE_MIN) {
            throw new IllegalArgumentException(ERROR_FIRST_POSITION);
        }
    }

    private void validateExcessPositionRange(int position) {
        if (position > this.stations.size()) {
            throw new IllegalArgumentException(ERROR_EXCESS_POSITION_RANGE);
        }
    }
}
