package subway.station.domain;

import subway.line.domain.Line;
import subway.station.StationValidator;

public class Station {
    public static final int MIN_NAME_LENGTH = 2;

    private final Lines lines;
    private String name;

    public Station(String name) {
        StationValidator.validateRegistration(name);
        this.lines = new Lines();
        this.name = name;
    }

    public void addLine(Line line) {
        this.lines.addLine(line);
    }

    public boolean isRegistered() {
        return this.lines.isRegistered();
    }

    public String getName() {
        return name;
    }
}
