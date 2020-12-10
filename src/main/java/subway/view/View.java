package subway.view;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	public static void printMainScreen() {
		Arrays.stream(MainMessages.values())
				.limit(6)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getScreenOption(Scanner scanner) {
		System.out.println(General.CHOICE.getMessage());
		return scanner.nextLine();
	}

	public static void printStationScreen() {
		Arrays.stream(StationMessages.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getStationNameToRegister(Scanner scanner) {
		System.out.println(StationMessages.REGISTER_NAME.getMessage());
		return scanner.nextLine();
	}

	public static String getStationNameToDelete(Scanner scanner) {
		System.out.println(StationMessages.DELETE_NAME.getMessage());
		return scanner.nextLine();
	}

	public static void printStationRegisterCompletion() {
		System.out.println(StationMessages.REGISTER_COMPLETE.getMessage());
	}

	public static void printStationDeleteError() {
		System.out.println(StationMessages.UNREGISTERED_NAME_ERROR.getMessage());
	}

	public static void printStationDeleteCompletion() {
		System.out.println(StationMessages.DELETE_COMPLETE.getMessage());
	}

	public static void showStations() {
		System.out.println(StationMessages.REFERENCE);
		StationRepository.stations().stream()
				.map(Station::getName)
				.forEach(name -> System.out.println(General.INFO.getMessage() + name));
	}

	public static void printLineScreen() {
		Arrays.stream(LineMessages.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getLineNameToRegister(Scanner scanner) {
		System.out.println(LineMessages.REGISTER_NAME);
		return scanner.nextLine();
	}

	public static String getUpwardDestination(Scanner scanner) {
		System.out.println(LineMessages.UPWARD_DESTINATION_NAME);
		return scanner.nextLine();
	}

	public static String getDownwardDestination(Scanner scanner) {
		System.out.println(LineMessages.DOWNWARD_DESTINATION_NAME);
		return scanner.nextLine();
	}

	public static String getLineNameToDelete(Scanner scanner) {
		System.out.println(LineMessages.DELETE_NAME);
		return scanner.nextLine();
	}

	public static void showLines() {
		System.out.println(LineMessages.REFERENCE);
		LineRepository.lines().stream()
				.map(Line::getName)
				.forEach(name -> System.out.println(General.INFO.getMessage() + name));
	}

	public static void printLineDeleteCompletion() {
		System.out.println(LineMessages.DELETE_COMPLETE);
	}

	public static void printLineDeleteError() {
		System.out.println(LineMessages.UNREGISTERED_NAME_ERROR);
	}

	public static void printSectionScreen() {
		Arrays.stream(SectionMessages.values())
				.limit(4)
				.forEach(value -> System.out.println(value.getMessage()));
	}

	public static String getLineNameForNewSection(Scanner scanner) {
		System.out.println(SectionMessages.LINE_NAME_FOR_NEW_SECTION.getMessage());
		return scanner.nextLine();
	}

	public static String getStationNameForNewSection(Scanner scanner) {
		System.out.println(SectionMessages.STATION_NAME_FOR_NEW_SECTION.getMessage());
		return scanner.nextLine();
	}

	public static int getLocationForNewSection(Scanner scanner, String lineName) {
		System.out.println(SectionMessages.STATION_NAME_FOR_NEW_SECTION.getMessage());
		String location = scanner.nextLine();
		try {
			Line.validateInteger(location);
			Line.validateRange(location, lineName);
			return Integer.parseInt(location);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getLocationForNewSection(scanner, lineName);
		}
	}
}
