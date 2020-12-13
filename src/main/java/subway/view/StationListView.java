package subway.view;

import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationListView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "역 목록";

	public StationListView() {
		print();
		printStationList();
	}
	
	private void printStationList() {
		List<Station> stations = StationRepository.stations();
		for(Station station : stations) {
			printInfo(station.getName());
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
