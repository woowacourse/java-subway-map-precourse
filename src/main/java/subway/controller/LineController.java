package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
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

	private static void registerLine(Scanner scanner) {
		String name = View.getLineNameToRegister(scanner);
		String upwardDestination = View.getUpwardDestination(scanner);
		String downwardDestination = View.getDownwardDestination(scanner);
		try {
			LineRepository.addLine(new Line(name, upwardDestination, downwardDestination));
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
