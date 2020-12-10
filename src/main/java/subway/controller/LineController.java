package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
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

	private static void createLine(Scanner scanner) {
		String name = View.getLineNameToRegister(scanner);
		String upwardDestination = View.getUpwardDestination(scanner);
		String downwardDestination = View.getDownwardDestination(scanner);
		try {
			Line line = new Line(name, upwardDestination, downwardDestination);
			LineRepository.addLine(line);
			View.printStationRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			createLine(scanner);
		}
	}

	private static void deleteLine(Scanner scanner) {
		String name = View.getLineNameToDelete(scanner);
		boolean isSuccessful = LineRepository.deleteLine(name);
		if (isSuccessful) {
			View.printLineDeleteCompletion();
			return;
		}
		View.printLineDeleteError();
		deleteLine(scanner);
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			createLine(scanner);
			MainController.run(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deleteLine(scanner);
			MainController.run(scanner);
		} else if (option.equals(Options.OPTION_3.getOption())) {
			View.showLines();
			MainController.run(scanner);
		} else if (option.equalsIgnoreCase(Options.BACK.getOption())) {
			MainController.run(scanner);
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
			run(scanner);
		}
	}
}
