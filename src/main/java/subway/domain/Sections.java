package subway.domain;

import subway.view.LineMessages;
import subway.view.SectionMessages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Sections {
	public static final int FIRST_SECTION_LOCATION = 1;
	public static final int MINIMUM_SECTION_LENGTH = 2; // At least 2 stations required for one Line

	private final List<Station> sections = new ArrayList<>();

	private static List<String> getSectionNames(String lineName) {
		return LineRepository.getLine(lineName)
				.getSections()
				.sections
				.stream()
				.map(Station::getName)
				.collect(Collectors.toUnmodifiableList());
	}

	public static void addSection(String lineName, String stationName, int location) {
		LineRepository.getLine(lineName)
				.getSections()
				.sections
				.add(location - 1, StationRepository.getStation(stationName)); // index = user's input location - 1
	}

	public static void deleteSection(String lineName, String stationName) {
		LineRepository.getLine(lineName)
				.getSections()
				.sections
				.remove(StationRepository.getStation(stationName));
	}

	public static int getSectionLength(String lineName) {
		return LineRepository.getLine(lineName)
				.getSections()
				.sections
				.size();
	}

	public static void validateDuplicate(String lineName, String stationName) throws IllegalArgumentException {
		if (getSectionNames(lineName).contains(stationName)) {
			throw new IllegalArgumentException(SectionMessages.DUPLICATE_NAME_ERROR.getMessage());
		}
	}

	public static void validateRegistration(String lineName, String stationName) throws IllegalArgumentException {
		if (!getSectionNames(lineName).contains(stationName)) {
			throw new IllegalArgumentException(SectionMessages.UNREGISTERED_STATION_NAME_ERROR.getMessage());
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
		if (Integer.parseInt(location) < FIRST_SECTION_LOCATION || getSectionLength(lineName) + 1 < Integer.parseInt(location)) {
			throw new IllegalArgumentException(SectionMessages.LOCATION_OUT_OF_RANGE_ERROR.getMessage());
		}
	}

	public static void validateDuplicateDestination(String upwardDestination, String downwardDestination) throws IllegalArgumentException {
		if (upwardDestination.equalsIgnoreCase(downwardDestination)) {
			throw new IllegalArgumentException(LineMessages.DESTINATION_DUPLICATE_ERROR.getMessage());
		}
	}

	public static void validateSectionLength(String lineName) throws IllegalArgumentException {
		if (getSectionLength(lineName) <= MINIMUM_SECTION_LENGTH) {
			throw new IllegalArgumentException(SectionMessages.MINIMUM_SECTION_LENGTH_ERROR.getMessage());
		}
	}

	public List<Station> sections() {
		return Collections.unmodifiableList(sections);
	}
}
