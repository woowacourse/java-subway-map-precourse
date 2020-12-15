package subway.domain;

import java.util.HashSet;

public class Station {
    private String name;
    private HashSet<String> StationLineSet = new HashSet<String>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void registerStationSet(String stationName) {
    	StationLineSet.add(stationName);    
    }
    
    public void deleteStationSet(String stationName) {
    	StationLineSet.remove(stationName);
    }
}
