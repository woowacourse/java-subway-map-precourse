package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.View;

import java.util.Scanner;

public class StationController {
	private static void createStation(Scanner scanner) {
		String name = View.getStationInput(scanner);
		StationRepository.addStation(new Station(name));
	}
}
