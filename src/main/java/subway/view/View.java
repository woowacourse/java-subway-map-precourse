package subway.view;

import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	public static void printMainScreen() {
		Arrays.stream(MainMessages.values())
				.limit(6)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printScreenChoiceInput() {
		System.out.println(General.CHOICE.getMessage());
	}

	public static void printStationScreen() {
		Arrays.stream(StationMessages.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getStationRegisterInput(Scanner scanner) {
		System.out.println(StationMessages.REGISTER_MESSAGE.getMessage());
		return scanner.nextLine();
	}

	public static String getStationDeleteInput(Scanner scanner) {
		System.out.println(StationMessages.DELETE_MESSAGE.getMessage());
		return scanner.nextLine();
	}

	public static void printStationRegisterCompletion() {
		System.out.println(StationMessages.REGISTER_COMPLETE_MESSAGE.getMessage());
	}

	public static void printStationDeleteCompletion() {
		System.out.println(StationMessages.REGISTER_DELETE_MESSAGE.getMessage());
	}

	public static void showStations() {
		StationRepository.stations().stream()
				.map(subway.domain.Station::getName)
				.forEach(name -> System.out.println(General.INFO.getMessage() + name));
	}

	public static void printLineScreen() {
		Arrays.stream(LineMessages.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printSectionScreen() {
		Arrays.stream(SectionMessages.values())
				.limit(4)
				.forEach(value -> System.out.println(value.getMessage()));
	}
}
