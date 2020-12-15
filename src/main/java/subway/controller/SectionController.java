package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class SectionController {
	private static final Map<String, Consumer<Scanner>> options = new HashMap<>();

	static {
		options.put(Options.OPTION_1.getOption(), SectionController::registerSection);
		options.put(Options.OPTION_2.getOption(), SectionController::deregisterSection);
		options.put(Options.BACK.getOption(), (scanner) -> {
		});
	}

	public static int getOptionLength() {
		return options.size();
	}

	private static String createLineNameToRegister(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToRegisterSection(scanner);
		System.out.println();
		LineRepository.validateRegistration(lineName);
		return lineName;
	}

	private static String createStationNameToRegister(String lineName, Scanner scanner) throws IllegalArgumentException {
		String stationName = View.getStationNameToRegisterSection(scanner);
		System.out.println();
		Sections.validateDuplicate(lineName, stationName);
		return stationName;
	}

	private static int createLocationToRegister(String lineName, Scanner scanner) throws IllegalArgumentException {
		String location = View.getLocationToRegisterSection(scanner);
		System.out.println();
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
		}
	}

	private static String createLineNameToDelete(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToDeleteSection(scanner);
		System.out.println();
		LineRepository.validateRegistration(lineName);
		Sections.validateSectionLength(lineName);
		return lineName;
	}

	private static String createStationNameToDelete(String lineName, Scanner scanner) throws IllegalArgumentException {
		String stationName = View.getStationNameToDeleteSection(scanner);
		System.out.println();
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
		}
	}

	private static void controlByOption(String option, Scanner scanner) {
		options.get(option).accept(scanner);
		if (option.equals(Options.BACK.getOption())) {
			return;
		}
		run(scanner);
	}

	public static void run(Scanner scanner) {
		try {
			View.printSectionScreen();
			String option = Options.createOption(scanner, options);
			controlByOption(option, scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}
}
