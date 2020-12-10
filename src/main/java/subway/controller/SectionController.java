package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.StationRepository;
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

	private static String getValidLineName(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameForNewSection(scanner);
		try {
			LineRepository.validateDuplicateName(lineName);
			LineRepository.validateRegistration(lineName);
			return lineName;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidLineName(scanner);
		}
	}

	private static String getValidStationName(Scanner scanner, String lineName) throws IllegalArgumentException {
		String stationName = View.getStationNameForNewSection(scanner);
		try {
			StationRepository.validateRegistration(stationName);
			Sections.validateDuplicate(stationName, lineName);
			return stationName;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidStationName(scanner, lineName);
		}
	}

	private static int getValidLocation(Scanner scanner, String lineName) throws IllegalArgumentException {
		String location = View.getLocationForNewSection(scanner);
		try {
			Line.validateInteger(location);
			Line.validateSectionRange(location, lineName);
			return Integer.parseInt(location);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidLocation(scanner, lineName);
		}
	}

	private static void createStation(Scanner scanner) {
		String lineName = getValidLineName(scanner);
		String stationName = getValidStationName(scanner);
		int Location = getValidLocation(scanner, lineName);
		LineRepository

		View.printStationRegisterCompletion();
	}

	private static void deleteStation(Scanner scanner) {
		String name = View.getStationNameToDelete(scanner);
		boolean isSuccessful = StationRepository.deleteStation(name);
		if (isSuccessful) {
			View.printStationDeleteCompletion();
			return;
		}
		View.printStationDeleteError();
		deleteStation(scanner);
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			createStation(scanner);
			MainController.run(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deleteStation(scanner);
			MainController.run(scanner);
		} else if (option.equals(Options.OPTION_3.getOption())) {
			View.showStations();
			MainController.run(scanner);
		} else if (option.equalsIgnoreCase(Options.BACK.getOption())) {
			MainController.run(scanner);
		}
	}

	public static void run(Scanner scanner) {
		View.printStationScreen();
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
