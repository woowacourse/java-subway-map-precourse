package subway.domain;

import java.util.LinkedList;
import java.util.Objects;

public class Line {
	private String name;
	private LinkedList<Station> stations;

	public Line(String name) {
		this.name = name;
		stations = new LinkedList<Station>();
	}

	public String getName() {
		return name;
	}

	public LinkedList<Station> getStations() {
		return stations;
	}

	public void addStation(int index, Station station) {
		stations.add(index, station);
	}
	
	public void addFirstStation(Station station) {
		stations.addFirst(station);
	}
	
	public void addLastStation(Station station) {
		stations.addLast(station);
	}

	public void removeStationByName(String name) {
		stations.removeIf(station -> Objects.equals(station.getName(), name));
	}
}
