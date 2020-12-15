package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
	private static final List<Station> stations = new ArrayList<>();

	public static List<Station> stations() {
		return Collections.unmodifiableList(stations);
	}

	public static void addStation(Station station) {
		stations.add(station);
	}

	public static boolean deleteStation(String name) {
		return stations.removeIf(station -> Objects.equals(station.getName(), name));
	}

	public static void sizeStation() {
		System.out.println(stations.size());
	}

	public static Station findStation(String name) {
		for (int tempStation = 0; tempStation < stations.size(); tempStation++) {
			if (stations.get(tempStation).getName().equals(name)) {
				Station station = stations.get(tempStation);
				return station;
			}
		}
		System.out.println(name + " ¸øÃ£À½");
		return null;
	}

	public static void viewStations() {
		for (int station = 0; station < stations.size(); station++) {
			System.out.println(stations.get(station).getName());
		}
	}

}
