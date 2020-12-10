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

	private static String getValidLineName(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameForNewSection(scanner);
		try {
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
			Sections.validateInteger(location);
			Sections.validateRange(location, lineName);
			return Integer.parseInt(location);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getValidLocation(scanner, lineName);
		}
	}

	private static void createSection(Scanner scanner) {
		String lineName = getValidLineName(scanner);
		String stationName = getValidStationName(scanner, lineName);
		int location = getValidLocation(scanner, lineName);

		Station station = StationRepository.getStation(stationName);
		Line line = LineRepository.getLine(lineName);
		line.getSections().addSection(station, location);
		View.printSectionRegisterCompletion();
	}

	private static void deleteSection(Scanner scanner) {
		String name = View.getStationNameToDelete(scanner);
		boolean isSuccessful = StationRepository.deleteStation(name);
		if (isSuccessful) {
			View.printStationDeleteCompletion();
			return;
		}
		View.printStationDeleteError();
		deleteSection(scanner);
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			createSection(scanner);
			MainController.run(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deleteSection(scanner);
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
