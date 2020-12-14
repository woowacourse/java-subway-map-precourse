package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Sections;
import subway.domain.StationRepository;
import subway.view.View;

import java.util.*;
import java.util.function.Consumer;

public class LineController {
	private static final Map<String, Consumer<Scanner>> options = new HashMap<>();

	static {
		options.put(Options.OPTION_1.getOption(), LineController::registerLine);
		options.put(Options.OPTION_2.getOption(), LineController::deregisterLine);
		options.put(Options.OPTION_3.getOption(), (scanner) -> View.showLines());
		options.put(Options.BACK.getOption(), (scanner) -> System.out.println());
	}

	private static String createLineName(Scanner scanner) throws IllegalArgumentException {
		String lineName = View.getLineNameToRegister(scanner);
		LineRepository.validateDuplicateName(lineName);
		Line.validateNameLength(lineName);
		return lineName;
	}

	private static String createUpwardDestination(Scanner scanner) throws IllegalArgumentException {
		String destination = View.getUpwardDestination(scanner);
		StationRepository.validateRegistration(destination);
		return destination;
	}

	private static String createDownwardDestination(Scanner scanner) throws IllegalArgumentException {
		String destination = View.getDownwardDestination(scanner);
		StationRepository.validateRegistration(destination);
		return destination;
	}

	private static void createInitialLine(String lineName, String upwardDestination, String downwardDestination) throws IllegalArgumentException {
		Sections.validateDuplicateDestination(upwardDestination, downwardDestination);
		LineRepository.addLine(new Line(lineName));
		for (String destination : new String[] {downwardDestination, upwardDestination}) {
			Sections.addSection(lineName, destination, Sections.FIRST_SECTION_LOCATION);
		}
	}

	private static void registerLine(Scanner scanner) {
		try {
			String lineName = createLineName(scanner);
			String upwardDestination = createUpwardDestination(scanner);
			String downwardDestination = createDownwardDestination(scanner);
			createInitialLine(lineName, upwardDestination, downwardDestination);
			View.printStationRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}

	private static void deregisterLine(Scanner scanner) {
		String name = View.getLineNameToDelete(scanner);
		if (LineRepository.deleteLine(name)) {
			View.printLineDeleteCompletion();
			return;
		}
		View.printLineDeleteError();
		run(scanner);
	}

	private static void controlByOption(String option, Scanner scanner) {
		options.get(option).accept(scanner);
	}

	public static void run(Scanner scanner) {
		View.printLineScreen();
		String option = View.getScreenOption(scanner);
		try {
			Options.validateOption(Options.getOptionList(options), option);
			controlByOption(option, scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}
}
