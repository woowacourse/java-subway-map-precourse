package subway.domain;

import subway.view.LineMessages;
import subway.view.SectionMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sections {
	public static final int FIRST_SECTION_LOCATION = 1;

	private final List<Station> sections = new ArrayList<>();

	public List<Station> sections() {
		return Collections.unmodifiableList(sections);
	}

	public static void addSection(String lineName, String stationName, int location) {
		LineRepository.getLine(lineName)
				.getSections()
				.sections
				.add(location-1, StationRepository.getStation(stationName));
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
		List<Station> sections = LineRepository.getLine(lineName)
				.getSections()
				.sections();
		if (sections.contains(stationName)) {
			throw new IllegalArgumentException(SectionMessages.DUPLICATE_NAME_ERROR.getMessage());
		}
	}

	public static void validateRegistration(String lineName, String stationName) throws IllegalArgumentException {
		List<Station> sections = LineRepository.getLine(lineName)
				.getSections()
				.sections();
		if (!sections.contains(stationName)) {
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

	public static void validateRange(String lineName, String location) throws IllegalArgumentException {
		int sectionLength = LineRepository.getLine(lineName)
				.getSections()
				.getSectionLength();
		if (Integer.parseInt(location) - 1 < 0 || sectionLength < Integer.parseInt(location) - 1) {
			throw new IllegalArgumentException(SectionMessages.LOCATION_OUT_OF_RANGE_ERROR.getMessage());
		}
	}

	public static void validateDuplicateDestination(String upwardDestination, String downwardDestination) throws IllegalArgumentException {
		if (upwardDestination.equalsIgnoreCase(downwardDestination)) {
			throw new IllegalArgumentException(LineMessages.DESTINATION_DUPLICATE_ERROR.getMessage());
		}
	}
}
