package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Section {
    private Line line;
    private static final List<Station> station = new ArrayList<>();

    public Section(Line line) {
        this.line = line;
    }

    public void addStations(Station station) {
        this.station.add(station);
    }

    public Line getLine() {
        return line;
    }

    public static List<Station> getStation() {
        return Collections.unmodifiableList(station);
    }


}
