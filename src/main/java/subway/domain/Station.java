package subway.domain;

import static subway.message.ErrorMessage.STATION_INVALID_NAME_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class Station {

    public static final int MIN_STATION_NAME_LENGTH = 2;

    private final String name;
    private final Set<Line> parents = new HashSet<>(); // 이 역을 포함하고 있는 노선의 목록

    public Station(final String name) throws IllegalArgumentException {
        validateStationNameLength(name);
        this.name = name;
    }

    private void validateStationNameLength(final String name) {
        if (name.length() < MIN_STATION_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_INVALID_NAME_LENGTH.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void addParentLine(final Line line) {
        parents.add(line);
    }

    public void removeParentLine(final Line line) {
        parents.remove(line);
    }

    public boolean hasParentLine() {
        return !parents.isEmpty();
    }
}
