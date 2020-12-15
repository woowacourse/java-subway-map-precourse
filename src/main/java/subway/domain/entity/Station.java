package subway.domain.entity;

import java.util.Objects;

public class Station {
    private static final int MINIMUM_STATION_NAME_LENGTH = 2;
    private static final int DEFAULT_LINE_SECTION_REGISTRATION_COUNTS = 0;

    private final String name;
    private int lineSectionRegistrationCounts = DEFAULT_LINE_SECTION_REGISTRATION_COUNTS;

    public Station(String name) {
        validateStationName(name);
        this.name = name;
    }

    private void validateStationName(String name) {
        if (Objects.isNull(name)) {
            throw new StationNameException();
        }
        int trimNameLength = name.trim().length();
        if (trimNameLength < MINIMUM_STATION_NAME_LENGTH) {
            throw new StationNameException();
        }
    }

    public boolean matchesName(String name) {
        return Objects.equals(this.name, name);
    }

    public void registerAsLineSection() {
        this.lineSectionRegistrationCounts++;
    }

    public void unregisterFromLineSection() {
        if (this.lineSectionRegistrationCounts > DEFAULT_LINE_SECTION_REGISTRATION_COUNTS) {
            this.lineSectionRegistrationCounts--;
        }
    }

    public boolean isRegisteredAsLineSection() {
        return lineSectionRegistrationCounts != DEFAULT_LINE_SECTION_REGISTRATION_COUNTS;
    }

    public String getName() {
        return name;
    }
}
