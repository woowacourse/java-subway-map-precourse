package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class StationController {
	private static final Map<String, Consumer<Scanner>> options = new HashMap<>();

	static {
		options.put(Options.OPTION_1.getOption(), StationController::registerStation);
		options.put(Options.OPTION_2.getOption(), StationController::deregisterStation);
		options.put(Options.OPTION_3.getOption(), (scanner) -> View.showStations());
		options.put(Options.BACK.getOption(), (scanner) -> {
		});
	}

	public static int getOptionLength() {
		return options.size();
	}

	private static void registerStation(Scanner scanner) {
		try {
			String name = View.getStationNameToRegister(scanner);
			System.out.println();
			StationRepository.addStation(new Station(name));
			View.printStationRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	private static void deregisterStation(Scanner scanner) {
		try {
			String name = View.getStationNameToDelete(scanner);
			System.out.println();
			StationRepository.deleteStation(name);
			View.printStationDeleteCompletion();
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
			View.printStationScreen();
			String option = Options.createOption(scanner, options);
			controlByOption(option, scanner);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}
}
