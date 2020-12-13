package subway;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.View;

public class Subway {	
	public static void run(Scanner scanner) {
		View view = new View(scanner);
		while (true) {
			view.main();
		}
	}
	
	public static void addStation(String stationName) {
		if (!StationRepository.contains(stationName)) {
			Station station = new Station(stationName);
			StationRepository.addStation(station);
		}
		System.out.println(StationRepository.stations());
	}
}
