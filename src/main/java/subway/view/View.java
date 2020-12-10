package subway.view;

import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	public static void printMainScreen() {
		Arrays.stream(Base.values())
				.limit(6)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static void printStationScreen() {
		Arrays.stream(Station.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getStationRegisterInput(Scanner scanner) {
		System.out.println(Station.REGISTER_MESSAGE.getMessage());
		return scanner.nextLine();
	}

	public static String getStationDeleteInput(Scanner scanner) {
		System.out.println(Station.DELETE_MESSAGE.getMessage());
		return scanner.nextLine();
	}

	public static void printStationRegisterCompletion() {
		System.out.println(Station.REGISTER_COMPLETE_MESSAGE.getMessage());
	}

	public static void printStationDeleteCompletion() {
		System.out.println(Station.REGISTER_DELETE_MESSAGE.getMessage());
	}

	public static void showStations() {
		StationRepository.stations().stream()
				.map(subway.domain.Station::getName)
				.forEach(name -> System.out.println(Logger.INFO.getMessage() + name));
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
