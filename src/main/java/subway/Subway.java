package subway;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.util.Output;
import subway.util.View;

public class Subway {	
	public static void run(Scanner scanner) {
		View view = new View(scanner);
		Initializer.run();
		
		while (true) {
			view.main();
		}
	}
	
	public static void addStation(String name) {
		if (!StationRepository.contains(name)) {
			Station station = new Station(name);
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
	
	public static void removeStation(String name) {
		if (StationRepository.deleteStation(name)) {
			Output.info("지하철 역이 삭제되었습니다.");
			return;
		}
		Output.error("등록되지 않은 역 이름입니다.");
	}
}
