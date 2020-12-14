package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class Station_management {
	public static void add_station(String name) {
		for (Station station : StationRepository.stations()) {
			if (station.getName().equals(name)) {
				System.out.println("[INFO] 이미 있는 지하철 역입니다.");
				return;
			}
		}
		Station new_station = new Station(name);
		StationRepository.addStation(new_station);
	}

	private static boolean check_station_in_line(Line line, String station_name) {
		for (Station station : line.getStations()) {
			if (station_name.equals(station.getName())) {
				return true;
			}
		}
		return false;
	}

	private static boolean check_station_in_section(String station_name) {
		for (Line line : LineRepository.lines()) {
			if (check_station_in_line(line, station_name)) {
				return true;
			}
		}
		return false;
	}	

	public static void delete_station(String station_name) {
		if (check_station_in_section(station_name)) {
			System.out.println("[ERROR] 노선상에 등록되어 있는 지하철 역입니다.");
			return;
		}
		if (StationRepository.deleteStation(station_name)) {
			System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
			return;
		}
		System.out.println("[ERROR] 존재하지 않는 지하철 역입니다.");

	}

	public static Station get_station_by_name(String name) {
		for (Station station : StationRepository.stations()) {
			if (name.equals(station.getName())) {
				return station;
			}
		}
		return null;
	}

	public static void print_stations() {
		System.out.println("##역 목록");
		for (Station station : StationRepository.stations()) {
			System.out.println("[INFO] " + station.getName());
		}
	}
}
