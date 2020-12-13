package subway.view;

import java.util.Scanner;

import subway.domain.StationRepository;

public class StationRemovalView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "삭제할 역 이름을 입력하세요.";
	
	public StationRemovalView(Scanner scanner) {
		print();
		removeStation(scanner);
	}
	
	public boolean removeStation(Scanner scanner) {
		String name = scanner.nextLine();
		return StationRepository.deleteStation(name);
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
