package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    private boolean hasName(String name) {
        return StationRepository.stations().stream()
                .map(Station::getName)
                .anyMatch(station -> station.equals(name));
    }

    private void validateDuplicate(String name) {
        if (hasName(name)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        // under length 2

    }

    public String getName() {
        return name;
    }
}
