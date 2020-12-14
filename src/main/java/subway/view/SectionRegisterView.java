package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionRegisterView extends ManagerView {
	private static final String LINE_INPUT_MESSAGE = "노선을 입력하세요.";
	private static final String STATION_NAME_INPUT_MESSAGE = "역이름을 입력하세요.";
	private static final String INDEX_INPUT_MESSAGE = "순서를 입력하세요.";

	public SectionRegisterView(Scanner scanner) {
		print();
		registerSection(scanner);
		new MainView(scanner);
	}

	public void registerSection(Scanner scanner) {
		String lineName = scanner.nextLine();
		Line line = LineRepository.getLineByName(lineName);
		
		printTopMenu(STATION_NAME_INPUT_MESSAGE);
		String stationName = scanner.nextLine();
		Station station = StationRepository.getStationByName(stationName);
		
		printTopMenu(INDEX_INPUT_MESSAGE);
		int index = Integer.parseInt(scanner.nextLine());
		
		line.addStation(index, station);
	}
	
	@Override
	public void print() {
		printTopMenu(LINE_INPUT_MESSAGE);
	}

}
