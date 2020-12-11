package subway.domain;

import subway.view.LineMessages;

public class Line {
	public static final int NAME_LENGTH_LOWER_BOUND = 2;
	private final Sections sections = new Sections();
	private String name;

	public Line(String name, String upwardDestination, String downwardDestination) throws IllegalArgumentException {
		LineRepository.validateDuplicateName(name);
		validateNameLength(name);
		StationRepository.validateRegistration(upwardDestination);
		StationRepository.validateRegistration(downwardDestination);
		this.name = name;
		this.sections.addSection(StationRepository.getStation(upwardDestination));
		this.sections.addSection(StationRepository.getStation(downwardDestination));
	}

	public String getName() {
		return name;
	}

	public Sections getSections() {
		return sections;
	}

	private void validateNameLength(String name) throws IllegalArgumentException {
		if (name.length() < NAME_LENGTH_LOWER_BOUND) {
			throw new IllegalArgumentException(LineMessages.NAME_LENGTH_ERROR.getMessage());
		}
	}
}
