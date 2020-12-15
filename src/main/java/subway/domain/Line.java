package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private String name;
    private List<Station> registeredStation = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean deleteStationByName(String name) {
        return this.registeredStation.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public int length() {
        return this.registeredStation.size();
    }

    public void addStation(Station stationName) {
        this.registeredStation.add(stationName);
    }

    public void addStation(Station stationName, int index) {
        this.registeredStation.add(index, stationName);
    }

    public List<Station> getLineMembers() {
        return this.registeredStation;
    }
}
