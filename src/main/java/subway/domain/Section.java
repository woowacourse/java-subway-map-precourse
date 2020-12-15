package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Section {
    private String line;
    private static final List<Station> station = new ArrayList<>();

    public Section(String line, Station upperStation, Station lowerStation) {
        this.line = line;
        station.add(upperStation);
        station.add(lowerStation);
    }

    public String getLine() {
        return line;
    }

    public static List<Station> getStation() {
        return Collections.unmodifiableList(station);
    }


}
