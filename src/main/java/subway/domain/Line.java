package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line implements Comparable<Line> {
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
        /*checkOverlappedStation(station);*/
        stations.add(location - DomainConstant.HUMAN_NUMBER_CALIBRATION, station);
    }

    public boolean deleteStation(String name) {
        checkAbleDeleteStation();
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    private void checkNameLength(String name) {
        if (name.length() < DomainConstant.NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(DomainErrorMessage.LINE_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkOverlappedStation(Station target) {
        long isOverlap = stations.stream()
                .filter(station -> station.compareName(target.getName()))
                .count();
        if (isOverlap != DomainConstant.ZERO_LONG_NUMBER) {
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_STATION_ERROR);
        }
    }

    private static void checkAbleDeleteStation() {
        if (stations.size() <= DomainConstant.MINIMUM_STATION_NUMBER) {
            throw new IllegalArgumentException(DomainErrorMessage.MINIMUM_STATION_ERROR);
        }
    }

    @Override
    public int compareTo(Line line) {
        return this.name.compareTo(line.name);
    }
}
