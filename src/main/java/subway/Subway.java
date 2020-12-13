package subway;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.Output;
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
			return;
		}
		Output.error("이미 등록된 역 이름입니다.");
	}
	
	public static void readStation() {
		for (Station station: StationRepository.getStations()) {
			Output.info(station.getName());
		}
	}
}
