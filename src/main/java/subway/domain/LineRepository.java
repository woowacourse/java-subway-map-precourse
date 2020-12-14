package subway.domain;

import subway.view.LineMessages;

import java.util.*;

public class LineRepository {
	private static final List<Line> lines = new ArrayList<>();

	static {
		InitialSubway.initializeLines();
		InitialSubway.initializeSections();
	}

	public static List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	public static void addLine(Line line) {
		lines.add(line);
	}

	public static boolean deleteLine(String name) {
		return lines.removeIf(line -> Objects.equals(line.getName(), name));
	}

	public static Line getLine(String lineName) throws IllegalArgumentException {
		return LineRepository
				.lines()
				.stream()
				.filter(line -> line.getName().equals(lineName))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(LineMessages.UNREGISTERED_NAME_ERROR.getMessage()));
	}

	private static boolean hasName(String name) {
		return LineRepository
				.lines()
				.stream()
				.map(Line::getName)
				.anyMatch(lineName -> lineName.equals(name));
	}

	public static void validateDuplicateName(String name) throws IllegalArgumentException {
		if (hasName(name)) {
			throw new IllegalArgumentException(LineMessages.DUPLICATE_NAME_ERROR.getMessage());
		}
	}

	public static void validateRegistration(String name) throws IllegalArgumentException {
		if (!hasName(name)) {
			throw new IllegalArgumentException(LineMessages.UNREGISTERED_NAME_ERROR.getMessage());
		}
	}
}
