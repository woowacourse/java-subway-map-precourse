package subway.station.domain;

import subway.line.domain.Line;
import subway.station.StationValidator;

public class Station {
    public static final int MIN_NAME_LENGTH = 2;

    private final Lines lines;
    private final String name;

    public Station(String name) {
        StationValidator.validateRegistration(name);
        this.lines = new Lines();
        this.name = name;
    }

    public void addLine(Line line) {
        lines.addLine(line);
    }

    public void removeLine(Line line) {
        lines.removeLine(line);
    }

    public boolean isRegistered() {
        return lines.isRegistered();
    }

    public String getName() {
        return name;
    }
}
