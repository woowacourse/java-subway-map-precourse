package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line implements Comparable<Line> {
    private static final int ZERO_NUMBER = 0;
    private static final int HUMAN_NUMBER_CALIBRATION = 1;
    private static final int NAME_LIMIT_LENGTH = 2;
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 노선의 이름은 2글자 이상이어야 합니다.";
    private static final String OVERLAP_ERROR = "[ERROR] 이미 등록된 역 이름입니다.";
    private static final String LACK_STATION_NUMBER_ERROR = "[ERROR] 역을 삭제하기에 너무 역의 수가 적습니다.";
    private String name;
    private static List<Station> stations = new ArrayList<>();

    public Line(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public boolean compareName(String compareName) {
        if (name.equals(compareName)) {
            return true;
        }
        return false;
    }

    public void insertStation(int location, Station station) {
        checkOverlappedStation(station);
        stations.add(location - HUMAN_NUMBER_CALIBRATION, station);
    }

    public static boolean deleteStation(String name) {
        checkAbleDeleteStation();
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private void checkNameLength(String name) {
        if (name.length() < NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkOverlappedStation(Station target) {
        long isOverlap = stations.stream()
                .filter(station -> station.compareName(target.getName()))
                .count();
        if (isOverlap != ZERO_NUMBER) {
            throw new IllegalArgumentException(OVERLAP_ERROR);
        }
    }

    private static void checkAbleDeleteStation() {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException(LACK_STATION_NUMBER_ERROR);
        }
    }

    @Override
    public int compareTo(Line line) {
        return this.name.compareTo(line.name);
    }
}
