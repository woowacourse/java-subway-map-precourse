package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private LineName name;
    private List<Station> stations = new ArrayList<>();

    public Line(LineName name) {
        this.name = name;
    }

    public LineName getName() {
        return name;
    }

    public void addStations(Station station) {
        station.setRegister(true);
        stations.add(station);
    }

}
