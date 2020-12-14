package subway.view;

import java.util.Scanner;

import subway.domain.StationRepository;

public class StationRemovalView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "삭제할 역 이름을 입력하세요.";
	private static final String REMOVE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
	private static final String REMOVE_FAILURE_MESSAGE = "삭제할 지하철 역이 없습니다.";

	public StationRemovalView(Scanner scanner) {
		print();
		removeStation(scanner);
		new MainView(scanner);
	}

	public void removeStation(Scanner scanner) {
		String name = scanner.nextLine();
		if (StationRepository.deleteStation(name)) {
			printInfo(REMOVE_SUCCESS_MESSAGE);
		}
		printInfo(REMOVE_FAILURE_MESSAGE);
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
