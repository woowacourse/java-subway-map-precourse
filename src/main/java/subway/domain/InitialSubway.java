package subway.domain;

import java.util.*;

import static subway.domain.LineRepository.addLine;
import static subway.domain.StationRepository.addStation;

public enum InitialSubway {
	LINE_2("2호선", Arrays.asList("교대역", "강남역", "역삼역")),
	LINE_3("3호선", Arrays.asList("교대역", "남부터미널역", "양재역", "매봉역")),
	LINE_SHIN_BUNDANG("신분당선", Arrays.asList("강남역", "양재역", "양재시민의숲역"));

	private final String lineName;
	private final List<String> stations;

	InitialSubway(String lineName, List<String> stations) {
		this.lineName = lineName;
		this.stations = stations;
	}

	public static void initializeStations() {
		Arrays.stream(values())
				.map(subway -> subway.stations)
				.flatMap(Collection::stream)
				.distinct()
				.forEach(station -> addStation(new Station(station)));
	}

	public static void initializeLines() {
		Arrays.stream(values())
				.forEach(subway -> addLine(new Line(subway.lineName)));
	}

	private static ArrayList<String> getReversedStations(InitialSubway subway) {
		ArrayList<String> stationsCopy = new ArrayList<>(subway.stations);
		Collections.reverse(stationsCopy);
		return stationsCopy;
	}

	private static void createSections(InitialSubway subway) {
		for (String station : getReversedStations(subway)) {
			Sections.addSection(subway.lineName, station, Sections.FIRST_SECTION_LOCATION);
		}
	}

	public static void initializeSections() {
		Arrays.stream(values())
				.forEach(InitialSubway::createSections);
	}
}
