package subway.domain;

import subway.view.SectionMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sections {
	private final List<Station> sections = new ArrayList<>();

	public List<Station> sections() {
		return Collections.unmodifiableList(sections);
	}

	public void addSection(Station station) {
		sections.add(station);
	}

	public void addSection(Station station, int location) {
		sections.add(location, station);
	}

	public static void deleteSection(String lineName, String stationName) {
		Line line = LineRepository.getLine(lineName);
		Station station = StationRepository.getStation(stationName);
		line.getSections().sections.remove(station);
	}

	public int getSectionLength() {
		return sections.size();
	}

	public static void validateDuplicate(String lineName, String stationName) throws IllegalArgumentException {
		if (LineRepository.getLine(lineName).getSections().sections().contains(stationName)) {
			throw new IllegalArgumentException(SectionMessages.DUPLICATE_NAME_ERROR.getMessage());
		}
	}

	public static void validateInteger(String location) throws IllegalArgumentException {
		try {
			Integer.parseInt(location);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(SectionMessages.NON_POSITIVE_INTEGER_LOCATION_ERROR.getMessage());
		}
	}

	public static void validateRange(String location, String lineName) throws IllegalArgumentException {
		int sectionLength = LineRepository.getLine(lineName).getSections().getSectionLength();
		if (Integer.parseInt(location) < 0 || sectionLength <= Integer.parseInt(location)) {
			throw new IllegalArgumentException(SectionMessages.LOCATION_OUT_OF_RANGE_ERROR.getMessage());
		}
	}
}
