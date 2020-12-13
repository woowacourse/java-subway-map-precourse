package subway;

import subway.domain.Station;
import subway.domain.StationRepository;

public class Station_management {
	public void add_station(String name) {
		Station new_station = new Station(name);
		for (Station station : StationRepository.stations()) {
			if (station.getName().equals(name)) {
				System.out.println("[INFO] 이미 있는 지하철 역입니다.");
				return;
			}
		}
		StationRepository.addStation(new_station);
	}
	
	public void delete_station(String name) {
		if (StationRepository.deleteStation(name)) {
			System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
			return;
		}
		System.out.println("[INFO] 존재하지 않는 지하철 역입니다.");
	}
	
	public void print_stations() {
		System.out.println("##역 목록");
		for ( Station station : StationRepository.stations()) {
			System.out.println("[INFO] "+station.getName());
		}
	}
}
