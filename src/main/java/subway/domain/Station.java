package subway.domain;

import static subway.station.StationValidator.*;

public class Station {
    private static final int ZERO = 0;
    private String name;
    private int lineCount = 0;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLine() {
        lineCount++;
    }

    public void removeLine() {
        lineCount--;
    }

    public boolean isRemovable() {
        return lineCount == ZERO;
    }
}
