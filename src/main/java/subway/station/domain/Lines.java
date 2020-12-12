package subway.station.domain;

import subway.line.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int MIN_COUNT_IF_REGISTERED = 1;

    private final List<Line> lines = new ArrayList<>();

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public boolean isRegistered() {
        return lines.size() >= MIN_COUNT_IF_REGISTERED;
    }
}
