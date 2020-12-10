package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.View;

import java.util.Scanner;

public class StationController {
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
		deleteStation(scanner);
	}
}
