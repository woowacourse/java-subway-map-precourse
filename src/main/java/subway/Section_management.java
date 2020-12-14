package subway;

import subway.domain.Line;
import subway.domain.Station;

public class Section_management {

	public static void add_section(String line_name, String Station_name, int position) {
		Line line = Line_management.get_line_by_name(line_name);
		Station station = Station_management.get_station_by_name(Station_name);
		if (station != null) {
			line.getStations().add(position - 1, Station_management.get_station_by_name(Station_name));
			System.out.println("[INFO] 구간이 등록되었습니다.");
			return;
		}
		System.out.println("[ERROR] 존재하지 않는 지하철 역입니다.");
	}

	public static void delete_section(String line_name, String Station_name) {
		Line line = Line_management.get_line_by_name(Station_name);
		Station station = Station_management.get_station_by_name(Station_name);
		if (station != null) {			
			line.getStations().remove(Station_management.get_station_by_name(Station_name));
			System.out.println("[INFO] 구간이 삭제되었습니다.");
			return;
		}
		System.out.println("[ERROR] 존재하지 않는 지하철역입니다.");
	}

}
