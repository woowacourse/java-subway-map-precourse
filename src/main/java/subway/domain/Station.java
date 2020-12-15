package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

public class Station implements Comparable<Station> {
    private String name;

    public Station(String name) {
        checkValidName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean compareName(String targetName) {
        if (name.equals(targetName)) {
            return true;
        }
        return false;
    }

    private void checkValidName(String name) {
        checkNameLength(name);
        checkEndName(name);
    }

    private void checkNameLength(String name) {
        if (name.length() < DomainConstant.NAME_LIMIT_LENGTH) {
            System.out.println();
            System.out.println(DomainErrorMessage.STATION_LENGTH);
            throw new IllegalArgumentException(DomainErrorMessage.STATION_LENGTH);
        }
    }

    private void checkEndName(String name) {
        String last = name.substring(name.length() - DomainConstant.LAST_LOCATION);
        if (!last.equals(DomainConstant.STATION_STRING)) {
            System.out.println();
            System.out.println(DomainErrorMessage.STATION_FORMAT);
            throw new IllegalArgumentException(DomainErrorMessage.STATION_FORMAT);
        }
    }

    /**
     * 역 이름 순서대로 정렬을 위해서 역 이름을 비교하여 정수로 반환하는 메소드 오버라이딩
     * @param station 타겟 역
     * @return 비교했을 때의 결과 값을 정수로 반환
     */
    @Override
    public int compareTo(Station station) {
        return this.name.compareTo(station.name);
    }
}
