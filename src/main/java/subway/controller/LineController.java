package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.StationRepository;
import subway.view.General;
import subway.view.LineMessages;
import subway.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineController {
	private static final List<String> options = new ArrayList<>();

	static {
		options.add(Options.OPTION_1.getOption());
		options.add(Options.OPTION_2.getOption());
		options.add(Options.OPTION_3.getOption());
		options.add(Options.BACK.getOption());
	}

	private static String createLineName(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToRegister(scanner);
		LineRepository.validateDuplicateName(lineName);
		Line.validateNameLength(lineName);
		return lineName;
	}

	private static String createDestination(Scanner scanner) throws IllegalArgumentException {
		String destination = View.getUpwardDestination(scanner);
		StationRepository.validateRegistration(destination);
		return destination;
	}

	private static void createLine(String lineName, String upwardDestination, String downwardDestination) throws IllegalArgumentException {
		Sections.validateDuplicateDestination(upwardDestination, downwardDestination);
		LineRepository.addLine(new Line(lineName));
		for (String destination : new String[] {downwardDestination, upwardDestination}) {
			Sections.addSection(lineName, destination, Sections.FIRST_SECTION_LOCATION);
		}
	}

	private static void registerLine(Scanner scanner) {
		try {
			String lineName = createLineName(scanner);
			String upwardDestination = createDestination(scanner);
			String downwardDestination = createDestination(scanner);
			createLine(lineName, upwardDestination, downwardDestination);
			View.printStationRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}

	private static void deregisterLine(Scanner scanner) {
		String name = View.getLineNameToDelete(scanner);
		boolean isSuccessful = LineRepository.deleteLine(name);
		if (isSuccessful) {
			View.printLineDeleteCompletion();
			return;
		}
		View.printLineDeleteError();
		run(scanner);
	}

	private static void showLines() {
		System.out.println(LineMessages.REFERENCE);
		LineRepository.lines()
				.stream()
				.map(Line::getName)
				.forEach(name -> System.out.println(General.INFO.getMessage() + name));
		System.out.println();
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			registerLine(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deregisterLine(scanner);
		} else if (option.equals(Options.OPTION_3.getOption())) {
			showLines();
		} else if (option.equalsIgnoreCase(Options.BACK.getOption())) {
			System.out.println();
		}
	}

	public static void run(Scanner scanner) {
		View.printLineScreen();
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
