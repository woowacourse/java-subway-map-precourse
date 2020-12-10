package subway.controller;

import subway.domain.*;
import subway.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SectionController {
	private static final List<String> options = new ArrayList<>();

	static {
		options.add(Options.OPTION_1.getOption());
		options.add(Options.OPTION_2.getOption());
		options.add(Options.BACK.getOption());
	}

	private static String getValidLineNameToRegister(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToRegisterSection(scanner);
		try {
			LineRepository.validateRegistration(lineName);
			return lineName;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidLineNameToRegister(scanner);
		}
	}

	private static String getValidLineNameToDelete(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToDeleteSection(scanner);
		try {
			LineRepository.validateRegistration(lineName);
			return lineName;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidLineNameToDelete(scanner);
		}
	}

	private static String getValidStationNameToRegister(Scanner scanner, String lineName) throws IllegalArgumentException {
		String stationName = View.getStationNameToRegisterSection(scanner);
		try {
			Sections.validateDuplicate(stationName, lineName);
			return stationName;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidStationNameToRegister(scanner, lineName);
		}
	}

	private static String getValidStationNameToDelete(Scanner scanner, String lineName) throws IllegalArgumentException {
		String stationName = View.getStationNameToDeleteSection(scanner);
		try {
			Sections.validateDuplicate(stationName, lineName);
			return stationName;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidStationNameToDelete(scanner, lineName);
		}
	}

	private static int getValidLocation(Scanner scanner, String lineName) throws IllegalArgumentException {
		String location = View.getLocationToRegisterSection(scanner);
		try {
			Sections.validateInteger(location);
			Sections.validateRange(location, lineName);
			return Integer.parseInt(location);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidLocation(scanner, lineName);
		}
	}

	private static void createSection(Scanner scanner) {
		String lineName = getValidLineNameToRegister(scanner);
		String stationName = getValidStationNameToRegister(scanner, lineName);
		int location = getValidLocation(scanner, lineName);

		Station station = StationRepository.getStation(stationName);
		Line line = LineRepository.getLine(lineName);
		line.getSections().addSection(station, location);
		View.printSectionRegisterCompletion();
	}

	private static void deleteSection(Scanner scanner) {
		String lineName = getValidLineNameToDelete(scanner);
		String stationName = getValidStationNameToDelete(scanner, lineName);
		Sections.deleteSection(lineName, stationName);
		View.printSectionDeleteCompletion();
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			createSection(scanner);
			MainController.run(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deleteSection(scanner);
			MainController.run(scanner);
		} else if (option.equalsIgnoreCase(Options.BACK.getOption())) {
			MainController.run(scanner);
		}
	}

	public static void run(Scanner scanner) {
		View.printSectionScreen();
		String option = View.getScreenOption(scanner).trim();
		try {
			Options.validateOption(options, option);
			controlByOption(option, scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			run(scanner);
		}
	}
}
