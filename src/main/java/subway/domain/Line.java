package subway.domain;

import subway.view.LineMessages;

public class Line {
	public static final int NAME_LENGTH_LOWER_BOUND = 2;
	private final Sections sections = new Sections();
	private String name;

	public Line(String name) throws IllegalArgumentException {
		LineRepository.validateDuplicateName(name);
		validateNameLength(name);
		this.name = name;
	}

	public static void validateNameLength(String name) throws IllegalArgumentException {
		if (name.length() < NAME_LENGTH_LOWER_BOUND) {
			throw new IllegalArgumentException(LineMessages.NAME_LENGTH_ERROR.getMessage());
		}
	}

	public String getName() {
		return name;
	}

	public Sections getSections() {
		return sections;
	}
}
