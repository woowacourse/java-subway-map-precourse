package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private String name;
	private List<Station> stations = new ArrayList<>();;

	public Line(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 異붽� 湲곕뒫 援ы쁽

	public void startStation(Station station) {
		stations.add(station);
	}

	public void endStation(Station station) {
		stations.add(stations.size(), station);
	}

	public void addStation(StationRepository stationRepository, String name, int count) {
		Station station = stationRepository.findStation(name);
		stations.add(count - 1, station);

	}

	public void viewLine() {
		for (int station = 0; station < stations.size(); station++) {
			System.out.println(stations.get(station).getName());
		}
	}

}
