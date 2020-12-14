package subway.view;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;

public class SectionRemovalView extends ManagerView {
	private static final String LINE_INPUT_MESSAGE = "노선을 입력하세요.";
	private static final String STATION_NAME_INPUT_MESSAGE = "역이름을 입력하세요.";

	public SectionRemovalView(Scanner scanner) {
		print();
		removeSection(scanner);
		new MainView(scanner);
	}

	public void removeSection(Scanner scanner) {
		String lineName = scanner.nextLine();
		Line line = LineRepository.getLineByName(lineName);

		printTopMenu(STATION_NAME_INPUT_MESSAGE);
		String stationName = scanner.nextLine();

		line.removeStationByName(stationName);
	}

	@Override
	public void print() {
		printTopMenu(LINE_INPUT_MESSAGE);
	}
}
