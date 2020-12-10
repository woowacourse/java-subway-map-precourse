package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
	private static final List<String> options = new ArrayList<>();

	static {
		options.add(Options.OPTION_1.getOption());
		options.add(Options.OPTION_2.getOption());
		options.add(Options.OPTION_3.getOption());
		options.add(Options.OPTION_4.getOption());
		options.add(Options.QUIT.getOption());
	}

	private static void printStations() {

	}

	public static void showWholeMap() {
		// get all lines
		List<Line> lines = LineRepository.lines();
		// iterate lines
		for (Line line : lines) {
			System.out.println(line.getName());
		}
		// print names
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
//			createLine(scanner);
			run(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
//			deleteLine(scanner);
			run(scanner);
		} else if (option.equals(Options.OPTION_3.getOption())) {
//			View.showLines();
			run(scanner);
		} else if (option.equals(Options.OPTION_3.getOption())) {

		} else if (option.equalsIgnoreCase(Options.QUIT.getOption())) {
			return;
		}
	}

	public static void run(Scanner scanner) {
		View.printMainScreen();
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
