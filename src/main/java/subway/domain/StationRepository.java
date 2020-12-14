package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
	private static final String NOT_FOUND_STATION_MESSAGE = "입력한 역을 찾을 수 없습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }
    
    public static Station getStationByName(String name) {
		for(Station station : stations) {
			if(station.getName().equals(name)) {
				return station;
			}
		}
		throw new IllegalArgumentException(NOT_FOUND_STATION_MESSAGE);
	}

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
