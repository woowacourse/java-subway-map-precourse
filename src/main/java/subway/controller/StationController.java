package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.General;
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

	private static void registerStation(Scanner scanner) {
		try {
			String name = View.getStationNameToRegister(scanner);
			StationRepository.addStation(new Station(name));
			View.printStationRegisterCompletion();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			System.out.println();
			run(scanner);
		}
	}

	private static void deregisterStation(Scanner scanner) {
		String name = View.getStationNameToDelete(scanner);
		boolean isSuccessful = StationRepository.deleteStation(name);
		if (isSuccessful) {
			View.printStationDeleteCompletion();
			return;
		}
		View.printStationDeleteError();
		run(scanner);
	}

	private static void showStations() {
		System.out.println(StationMessages.REFERENCE.getMessage());
		StationRepository
				.stations()
				.stream()
				.map(Station::getName)
				.forEach(name -> System.out.println(General.INFO.getMessage() + name));
	}

	private static void controlByOption(String option, Scanner scanner) {
		if (option.equals(Options.OPTION_1.getOption())) {
			registerStation(scanner);
		} else if (option.equals(Options.OPTION_2.getOption())) {
			deregisterStation(scanner);
		} else if (option.equals(Options.OPTION_3.getOption())) {
			showStations();
		} else if (option.equalsIgnoreCase(Options.BACK.getOption())) {
			System.out.println();
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
			System.out.println();
			run(scanner);
		}
	}
}
