package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    public List<Station> stations = new ArrayList<Station>();

    public Line(String name) {
        this.name = name;
    }

    public Line(String name, Station... stations) {
        this.name = name;
        for(int i=0; i< stations.length; i++){
            this.stations.add(stations[i]);
        }
    }

    public String getName() {
        return name;
    }

    public boolean existStation(String stationName) {
        return stations.stream().anyMatch(s -> s.getName().equals(stationName));
    }

    public void addStation(String stationName, int order) {
        stations.add(order-1, new Station(stationName));
    }

    public boolean checkStationSize() {
        return stations.size() <= Constant.MIN_LENGTH;
    }
}
