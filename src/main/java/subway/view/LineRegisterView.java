package subway.view;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class LineRegisterView extends ManagerView {
	private static final String INPUT_LINE_NAME_MESSAGE = "등록할 노선 이름을 입력하세요.";
	private static final String INPUT_FIRST_STATION_NAME_MESSAGE = "등록할 노선의 상행 종점역 이름을 입력하세요.";
	private static final String INPUT_LAST_STATION_NAME_MESSAGE = "등록할 노선의 하행 종점역 이름을 입력하세요.";

	public LineRegisterView(Scanner scanner) {
		print();
		registerLine(scanner);
		new MainView(scanner);
	}

	public void registerLine(Scanner scanner) {
		Line line = new Line(scanner.nextLine());
		try {
			printTopMenu(INPUT_FIRST_STATION_NAME_MESSAGE);
			Station firstStation = StationRepository.getStationByName(scanner.nextLine());
			line.addFirstStation(firstStation);

			printTopMenu(INPUT_LAST_STATION_NAME_MESSAGE);
			Station lastStation = StationRepository.getStationByName(scanner.nextLine());
			line.addLastStation(lastStation);
			LineRepository.addLine(line);
		} catch (IllegalArgumentException e) {
			printInfo(e.getMessage());
		}
	}

	@Override
	public void print() {
		printTopMenu(INPUT_LINE_NAME_MESSAGE);
	}
}
