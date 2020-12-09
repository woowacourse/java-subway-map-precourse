package subway.view;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	public static void printMainScreen() {
		Arrays.stream(Main.values())
				.limit(6)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printStationScreen() {
		Arrays.stream(Station.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getStationInput(Scanner scanner) {
		System.out.println(Station.REGISTER_MESSAGE.getMessage());
		return scanner.nextLine();
	}

	public static void printStationRegisterCompletion() {
		System.out.println(Station.REGISTER_COMPLETE_MESSAGE);
	}

	public static void printLineScreen() {
		Arrays.stream(Line.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printSectionScreen() {
		Arrays.stream(Section.values())
				.limit(4)
				.forEach(value -> System.out.println(value.getMessage()));
	}
}
