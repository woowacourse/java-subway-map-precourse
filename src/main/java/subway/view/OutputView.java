package subway.view;

import java.util.Arrays;

public class OutputView {
	public static void printMainScreen() {
		Arrays.stream(MainScreen.values())
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printStationScreen() {
		Arrays.stream(StationScreen.values())
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printLineScreen() {
		Arrays.stream(LineScreen.values())
				.forEach(value -> System.out.println(value.getMessage()));
	}
}
