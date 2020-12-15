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

    public boolean compareName(String compareName) {
        if (name.equals(compareName)) {
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
            System.out.println(DomainErrorMessage.STATION_LENGTH);
            throw new IllegalArgumentException(DomainErrorMessage.STATION_LENGTH);
        }
    }

    private void checkEndName(String name) {
        String last = name.substring(name.length() - DomainConstant.LAST_LOCATION);
        if (!last.equals(DomainConstant.STATION_STRING)) {
            System.out.println(DomainErrorMessage.STATION_FORMAT);
            throw new IllegalArgumentException(DomainErrorMessage.STATION_FORMAT);
        }
    }

    @Override
    public int compareTo(Station station) {
        return this.name.compareTo(station.name);
    }
}
