package subway;

import subway.domain.Line;

public class Section_management {
	
	public static void add_section(String line_name, String Station_name, int position) {
		Line line = Line_management.get_line_by_name(line_name);
		line.getStations().add(position-1, Station_management.get_station_by_name(Station_name));
	}
	
	public static void delete_section(String line_name, String Station_name) {
		Line line = Line_management.get_line_by_name(Station_name);
		line.getStations().remove(Station_management.get_station_by_name(Station_name));
	}
	
}
