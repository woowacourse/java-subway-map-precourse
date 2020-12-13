package subway.view;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;

public class StationRegisterView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "등록할 역 이름을 입력하세요";

	public StationRegisterView(Scanner scanner) {
		print();
		registerStation(scanner);
		new MainView(scanner);
	}
	
	public void registerStation(Scanner scanner) {
		String name = scanner.nextLine();
		StationRepository.addStation(new Station(name));
	}
	
	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
