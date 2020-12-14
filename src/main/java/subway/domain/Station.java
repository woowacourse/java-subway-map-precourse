package subway.domain;

import subway.domain.constants.DomainConstant;
import subway.domain.constants.DomainErrorMessage;

public class Station implements Comparable<Station> {
    private String name;

    public Station(String name) {
        checkNameLength(name);
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

    private void checkNameLength(String name) {
        if (name.length() < DomainConstant.NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(DomainErrorMessage.STATION_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public int compareTo(Station station) {
        return this.name.compareTo(station.name);
    }
}
