package subway.view;

import java.util.Scanner;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.StationNameVaildator;

public class StationRegisterView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "등록할 역 이름을 입력하세요";
	private static final String REGISTER_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";

	public StationRegisterView(Scanner scanner) {
		print();
		registerStation(scanner);
		new MainView(scanner);
	}

	public void registerStation(Scanner scanner) {
		String name = scanner.nextLine();
		try {
			StationNameVaildator.check(name);
			StationRepository.addStation(new Station(name));
			printInfo(REGISTER_SUCCESS_MESSAGE);
		} catch (IllegalArgumentException e) {
			printInfo(e.getMessage());
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
