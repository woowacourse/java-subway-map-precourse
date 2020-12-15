package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> registeredStation = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int length(){
        return registeredStation.size();
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
