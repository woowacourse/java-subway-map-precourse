package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line implements Comparable<Line> {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        checkNameLength(name);
        checkEndName(name);
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
        checkOverlappedStation(station.getName());
        stations.add(location - DomainConstant.HUMAN_NUMBER_CALIBRATION, station);
    }

    public void deleteStation(String name) {
        checkAbleDeleteStation();
        stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public int getStationNumber() {
        return stations.size();
    }

    public boolean isContainedStation(String target) {
        long checkOverlapped = stations.stream()
                .map(Station::getName)
                .filter(station -> station.equals(target))
                .count();
        if (checkOverlapped == DomainConstant.ZERO_LONG_NUMBER) {
            return false;
        }
        return true;
    }

    private void checkOverlappedStation(String target) {
        if (isContainedStation(target)) {
            System.out.println(DomainErrorMessage.OVERLAP_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.OVERLAP_STATION);
        }
    }

    private void checkNameLength(String name) {
        if (name.length() < DomainConstant.NAME_LIMIT_LENGTH) {
            System.out.println(DomainErrorMessage.LINE_LENGTH);
            throw new IllegalArgumentException(DomainErrorMessage.LINE_LENGTH);
        }
    }

    /** 해당 역 삭제시에 문제가 없는지 체크하는 메소드 **/
    private void checkAbleDeleteStation() {
        if (stations.size() <= DomainConstant.MINIMUM_STATION) {
            System.out.println(DomainErrorMessage.MINIMUM_STATION);
            throw new IllegalArgumentException(DomainErrorMessage.MINIMUM_STATION);
        }
    }

    /** 문자 마지막이 선으로 끝나는지 확인하는 메소드 **/
    private void checkEndName(String name) {
        String last = name.substring(name.length() - DomainConstant.LAST_LOCATION);
        if (!last.equals(DomainConstant.LINE_STRING)) {
            System.out.println(DomainErrorMessage.LINE_FORMAT);
            throw new IllegalArgumentException(DomainErrorMessage.LINE_FORMAT);
        }
    }

    /**
     * 노선 정렬을 위해 오버라이딩한 메소드
     * @param line 노선
     * @return 노선과의 순서 정렬을 위한 정수
     */
    @Override
    public int compareTo(Line line) {
        return this.name.compareTo(line.name);
    }
}
