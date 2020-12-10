package subway.controller;

import subway.view.General;

import java.util.List;

public enum Options {
	OPTION_1("1"),
	OPTION_2("2"),
	OPTION_3("3"),
	OPTION_4("4"),
	BACK("B"),
	QUIT("Q");

	private final String option;

	Options(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}

	private static boolean hasOption(List<String> options, String input) {
		return options.stream()
				.anyMatch(option -> option.equalsIgnoreCase(input));
	}

	public static void validateOption(List<String> options, String input) throws IllegalArgumentException {
		if (!hasOption(options, input)) {
			throw new IllegalArgumentException(General.NOT_AVAILABLE_OPTION_ERROR.getMessage());
		}
	}
}
