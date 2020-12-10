package subway.controller;

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
}
