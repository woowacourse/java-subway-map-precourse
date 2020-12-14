package subway.domain;

import java.util.ArrayList;
import java.util.List;

import subway.Station_management;

public class Line {
    private String name;
    private List<Station> stations = new ArrayList<Station>();
    
    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public Line(String name, String UP, String DOWN) {
    	this.name = name;
    	stations.add(Station_management.get_station_by_name(UP));
    	stations.add(Station_management.get_station_by_name(DOWN));
    }
    
    public Line(String name, List<String> station_name) {
    	this.name = name;
    	for (String station : station_name) {    		
    		stations.add(Station_management.get_station_by_name(station));
    	}
    }
    
    public List<Station> getStations(){
    	return stations;
    }
    
    public void print_stationOfLine() {
    	System.out.println("[INFO] "+this.name);
    	System.out.println("[INFO] ---");
    	for (Station station : stations) {
    		System.out.println("[INFO] "+station.getName());
    	}
    }
}
