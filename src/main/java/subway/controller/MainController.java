package subway.controller;

import subway.view.MainMessages;
import subway.view.View;

import java.util.*;
import java.util.function.Consumer;

public class MainController {
	private static final Map<String, Consumer<Scanner>> options = new HashMap<>();

	static {
		options.put(Options.OPTION_1.getOption(), StationController::run);
		options.put(Options.OPTION_2.getOption(), LineController::run);
		options.put(Options.OPTION_3.getOption(), SectionController::run);
		options.put(Options.OPTION_4.getOption(), (scanner) -> View.showWholeMap());
		options.put(Options.QUIT.getOption(), (scanner) -> System.out.println(MainMessages.QUIT.getMessage()));
	}

	public static int getOptionLength() {
		return options.size();
	}

	private static void controlByOption(String option, Scanner scanner) {
		options.get(option).accept(scanner);
		if (option.equals(Options.QUIT.getOption())) {
			return;
		}
		View.printMainScreen();
		run(scanner);
	}

	public static void run(Scanner scanner) {
		try {
			String option = Options.createOption(scanner, options);;
			controlByOption(option, scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}
}
