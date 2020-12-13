package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private static final List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean validateNewName(String stationName) {
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getName().equals(stationName)) {
                return false;
            }
        }
        return true;
    }
}
