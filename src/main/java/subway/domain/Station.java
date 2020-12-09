package subway.domain;

public class Station {
    private static final int NAME_LENGTH_LOWER_BOUND = 2;

    private String name;

    public Station(String name) throws IllegalArgumentException {
        validateDuplicate(name);
        validateNameLength(name);
        this.name = name;
    }

    private boolean hasName(String name) {
        return StationRepository.stations().stream()
                .map(Station::getName)
                .anyMatch(station -> station.equals(name));
    }

    private void validateDuplicate(String name) throws IllegalArgumentException {
        if (hasName(name)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
