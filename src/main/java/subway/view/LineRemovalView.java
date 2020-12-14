package subway.view;

import java.util.Scanner;

import subway.domain.LineRepository;

public class LineRemovalView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "삭제할 노선 이름을 입력하세요.";
	private static final String REMOVE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
	private static final String REMOVE_FAILURE_MESSAGE = "삭제할 지하철 노선이 없습니다.";

	public LineRemovalView(Scanner scanner) {
		print();
		removeLine(scanner);
		new MainView(scanner);
	}

	public void removeLine(Scanner scanner) {
		String name = scanner.nextLine();
		if (LineRepository.deleteLineByName(name)) {
			printInfo(REMOVE_SUCCESS_MESSAGE);
		}
		printInfo(REMOVE_FAILURE_MESSAGE);
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
