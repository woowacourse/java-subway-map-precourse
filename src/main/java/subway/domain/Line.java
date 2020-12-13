package subway.domain;

import java.util.Objects;

public class Line {
    private String name;
    private Station uplineTerminalStation;
    private Station downlineTerminalStation;

    public Line(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        this.name = name;
        this.uplineTerminalStation = uplineTerminalStation;
        this.downlineTerminalStation = downlineTerminalStation;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
