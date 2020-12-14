package subway.view;

import java.util.List;
import java.util.Scanner;

import subway.domain.Line;
import subway.domain.LineRepository;

public class LineListView extends ManagerView {
	private static final String TOP_MENU_MESSAGE = "노선 목록";

	public LineListView(Scanner scanner) {
		print();
		printLineList();
		new MainView(scanner);
	}

	private void printLineList() {
		List<Line> lines = LineRepository.lines();
		for (Line line : lines) {
			printInfo(line.getName());
		}
	}

	@Override
	public void print() {
		printTopMenu(TOP_MENU_MESSAGE);
	}
}
