package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.StationMessages;
import subway.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StationController {
	private static final List<String> options = new ArrayList<>();

	static {
		options.add(Options.OPTION_1.getOption());
		options.add(Options.OPTION_2.getOption());
		options.add(Options.OPTION_3.getOption());
		options.add(Options.BACK.getOption());
	}

	private static void createStation(Scanner scanner) {
		String name = View.getStationRegisterInput(scanner);
		StationRepository.addStation(new Station(name));
		View.printStationRegisterCompletion();
	}

	private static void deleteStation(Scanner scanner) {
		String name = View.getStationDeleteInput(scanner);
		boolean isSuccessful = StationRepository.deleteStation(name);
		if (isSuccessful) {
			View.printStationDeleteCompletion();
			return;
		}
		View.printStationDeleteError();
		deleteStation(scanner);
	}

	private static boolean hasOption(String input) {
		return options.stream()
				.anyMatch(option -> option.equalsIgnoreCase(input));
	}

	private static void validateOption(String input) throws IllegalArgumentException {
		if (!hasOption(input)) {
			throw new IllegalArgumentException(StationMessages.OPTION_ERROR_MESSAGE.getMessage());
		}
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

	public static void run(Scanner scanner) throws IllegalArgumentException {
		View.printStationScreen();
		String option = View.getScreenChoiceInput(scanner).trim();
		validateOption(option);
		controlByOption(option, scanner);
	}
}
