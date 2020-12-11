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

	private static void addSection(String lineName, String stationName, String location) throws IllegalArgumentException {
		LineRepository.validateRegistration(lineName);
		Sections.validateDuplicate(stationName, lineName);
		Sections.validateInteger(location);
		Sections.validateRange(location, lineName);
		LineRepository.getLine(lineName)
				.getSections()
				.addSection(StationRepository.getStation(stationName), Integer.parseInt(location));
	}

	private static void registerSection(Scanner scanner) {
		String lineName = View.getLineNameToRegisterSection(scanner);
		String stationName = View.getStationNameToRegisterSection(scanner);
		String location = View.getLocationToRegisterSection(scanner);
		try {
			addSection(lineName, stationName, location);
			View.printSectionRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}

	private static void deleteSection(String lineName, String stationName) throws IllegalArgumentException {
		LineRepository.validateRegistration(lineName);
		Sections.validateRegistration(stationName, lineName);
		Sections.deleteSection(lineName, stationName);
	}

	private static void deregisterSection(Scanner scanner) {
		String lineName = View.getLineNameToDeleteSection(scanner);
		String stationName = View.getStationNameToDeleteSection(scanner);
		try {
			deleteSection(lineName, stationName);
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
