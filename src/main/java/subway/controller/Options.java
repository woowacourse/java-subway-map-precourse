package subway.controller;

import subway.view.General;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

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

	public static List<String> getOptionList(Map<String, Consumer<Scanner>> options) {
		return new ArrayList<>(options.keySet());
	}

	private static boolean hasOption(List<String> options, String input) {
		return options.stream()
				.anyMatch(option -> option.equals(input));
	}

	public static void validateOption(List<String> options, String input) throws IllegalArgumentException {
		if (!hasOption(options, input)) {
			throw new IllegalArgumentException(General.NOT_AVAILABLE_OPTION_ERROR.getMessage());
		}
	}

	public String getOption() {
		return option;
	}
}
