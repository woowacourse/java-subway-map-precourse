package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

public class SubwayMapView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "지하철 노선도";

	public SubwayMapView(Scanner scanner) {
		print();
		printLinesWithStations();
		new MainView(scanner);
	}

	private void printLinesWithStations() {
		List<Line> lines = LineRepository.lines();
		for (Line line : lines) {
			printInfo(line.getName());
			for (Station station : line.getStations()) {
				printInfo(station.getName());
			}
			System.out.println();
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
