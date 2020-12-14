package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Sections;
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

	private static String createLineNameToRegister(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToRegisterSection(scanner);
		LineRepository.validateRegistration(lineName);
		return lineName;
	}

	private static String createStationNameToRegister(String lineName, Scanner scanner) throws IllegalArgumentException {
		String stationName = View.getStationNameToRegisterSection(scanner);
		Sections.validateDuplicate(lineName, stationName);
		return stationName;
	}

	private static int createLocationToRegister(String lineName, Scanner scanner) throws IllegalArgumentException {
		String location = View.getLocationToRegisterSection(scanner);
		Sections.validateInteger(location);
		Sections.validateRange(lineName, location);
		return Integer.parseInt(location);
	}

	private static void registerSection(Scanner scanner) {
		try {
			String lineName = createLineNameToRegister(scanner);
			String stationName = createStationNameToRegister(lineName, scanner);
			int location = createLocationToRegister(lineName, scanner);
			Sections.addSection(lineName, stationName, location);
			View.printSectionRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}

	private static String createLineNameToDelete(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToDeleteSection(scanner);
		LineRepository.validateRegistration(lineName);
		Sections.validateSectionLength(lineName);
		return lineName;
	}

	private static String createStationNameToDelete(String lineName, Scanner scanner) throws IllegalArgumentException {
		String stationName = View.getStationNameToDeleteSection(scanner);
		Sections.validateRegistration(lineName, stationName);
		return stationName;
	}

	private static void deregisterSection(Scanner scanner) {
		try {
			String lineName = createLineNameToDelete(scanner);
			String stationName = createStationNameToDelete(lineName, scanner);
			Sections.deleteSection(lineName, stationName);
			View.printSectionDeleteCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			registerSection(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deregisterSection(scanner);
		} else if (option.equalsIgnoreCase(Options.BACK.getOption())) {
			System.out.println();
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
			System.out.println();
			run(scanner);
		}
	}
}
