package subway.domain;

public class Station implements Comparable<Station> {
    private static final int NAME_LIMIT_LENGTH = 2;
    private static final String LENGTH_ERROR_MESSAGE = "[ERROR] 역의 이름은 2글자 이상이어야 합니다.";
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
        if (name.length() < NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public int compareTo(Station station) {
        return this.name.compareTo(station.name);
    }
}
