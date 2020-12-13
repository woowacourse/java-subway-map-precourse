package subway.view;

import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;

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
		String name = scanner.nextLine();
		Line line = new Line(name);
		
		printTopMenu(INPUT_FIRST_STATION_NAME_MESSAGE);
		String firstStationName = scanner.nextLine();
		line.addStation(0, new Station(firstStationName));
		
		printTopMenu(INPUT_LAST_STATION_NAME_MESSAGE);
		String lastStationName = scanner.nextLine();
		line.addStation(1, new Station(lastStationName));
		
		LineRepository.addLine(line);
	}

	@Override
	public void print() {
		printTopMenu(INPUT_LINE_NAME_MESSAGE);
	}
}
