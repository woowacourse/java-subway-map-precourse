package subway.domain;

import subway.view.StationMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
	private static final List<Station> stations = new ArrayList<>();

	static {
		InitialSubway.initializeStations();
	}

	public static List<Station> stations() {
		return Collections.unmodifiableList(stations);
	}

	public static void addStation(Station station) {
		stations.add(station);
	}

	public static Station getStation(String name) throws IllegalArgumentException {
		return StationRepository
				.stations()
				.stream()
				.filter(station -> station.getName().equals(name))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(StationMessages.UNREGISTERED_NAME_ERROR.getMessage()));
	}

	public static void deleteStation(String name) throws IllegalArgumentException {
		validateRegistration(name);
		Sections.validateStationInUse(name);
		stations.removeIf(station -> Objects.equals(station.getName(), name));
	}

	private static boolean hasName(String name) {
		return StationRepository
				.stations()
				.stream()
				.map(Station::getName)
				.anyMatch(stationName -> stationName.equals(name));
	}

	public static void validateDuplicateName(String name) throws IllegalArgumentException {
		if (hasName(name)) {
			throw new IllegalArgumentException(StationMessages.DUPLICATE_NAME_ERROR.getMessage());
		}
	}

	public static void validateRegistration(String name) throws IllegalArgumentException {
		if (!hasName(name)) {
			throw new IllegalArgumentException(StationMessages.UNREGISTERED_NAME_ERROR.getMessage());
		}
	}
}
