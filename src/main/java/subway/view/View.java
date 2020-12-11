package subway.view;

import java.util.Arrays;
import java.util.Scanner;

public class View {
	public static void printMainScreen() {
		Arrays.stream(MainMessages.values())
				.limit(6)
				.forEach(value -> System.out.println(value.getMessage()));
		System.out.println();
	}

	public static String getScreenOption(Scanner scanner) {
		System.out.println(General.CHOICE.getMessage());
		return scanner.nextLine();
	}

	public static void printStationScreen() {
		Arrays.stream(StationMessages.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
		System.out.println();
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

	public static void printLineScreen() {
		Arrays.stream(LineMessages.values())
				.limit(5)
				.forEach(value -> System.out.println(value.getMessage()));
		System.out.println();
	}

	public static String getLineNameToRegister(Scanner scanner) {
		System.out.println(LineMessages.REGISTER_NAME.getMessage());
		return scanner.nextLine();
	}

	public static String getUpwardDestination(Scanner scanner) {
		System.out.println(LineMessages.UPWARD_DESTINATION_NAME.getMessage());
		return scanner.nextLine();
	}

	public static String getDownwardDestination(Scanner scanner) {
		System.out.println(LineMessages.DOWNWARD_DESTINATION_NAME.getMessage());
		return scanner.nextLine();
	}

	public static String getLineNameToDelete(Scanner scanner) {
		System.out.println(LineMessages.DELETE_NAME.getMessage());
		return scanner.nextLine();
	}

	public static void printLineDeleteCompletion() {
		System.out.println(LineMessages.DELETE_COMPLETE.getMessage());
	}

	public static void printLineDeleteError() {
		System.out.println(LineMessages.UNREGISTERED_NAME_ERROR.getMessage());
	}

	public static void printSectionScreen() {
		Arrays.stream(SectionMessages.values())
				.limit(4)
				.forEach(value -> System.out.println(value.getMessage()));
		System.out.println();
	}

	public static String getLineNameToRegisterSection(Scanner scanner) {
		System.out.println(SectionMessages.LINE_NAME_TO_REGISTER.getMessage());
		return scanner.nextLine();
	}

	public static String getStationNameToRegisterSection(Scanner scanner) {
		System.out.println(SectionMessages.STATION_NAME_TO_REGISTER.getMessage());
		return scanner.nextLine();
	}

	public static String getLocationToRegisterSection(Scanner scanner) {
		System.out.println(SectionMessages.STATION_NAME_TO_REGISTER.getMessage());
		return scanner.nextLine();
	}

	public static void printSectionRegisterCompletion() {
		System.out.println(SectionMessages.REGISTER_COMPLETE.getMessage());
	}

	public static String getLineNameToDeleteSection(Scanner scanner) {
		System.out.println(SectionMessages.LINE_NAME_TO_DELETE.getMessage());
		return scanner.nextLine();
	}

	public static String getStationNameToDeleteSection(Scanner scanner) {
		System.out.println(SectionMessages.STATION_NAME_TO_DELETE.getMessage());
		return scanner.nextLine();
	}

	public static void printSectionDeleteCompletion() {
		System.out.println(SectionMessages.DELETE_COMPLETE.getMessage());
	}
}
