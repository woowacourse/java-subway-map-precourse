package subway.view;

import java.util.Arrays;

public class OutputView {
	public static void printMainScreen() {
		Arrays.stream(MainScreen.values())
				.forEach(value -> System.out.println(value.getMessage()));
	}
}
