package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private final List<Station> lineIntervals = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> intervals() {
        return Collections.unmodifiableList(lineIntervals);
    }

    public void addIntervals (Station intervalStation, int pos) {
        lineIntervals.add(pos-1, intervalStation);
    }
}
