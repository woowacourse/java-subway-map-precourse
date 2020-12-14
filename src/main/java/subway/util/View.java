package subway.util;

import java.util.Scanner;

import subway.Subway;

public class View {
	private final String FIRST = "1";
	private final String SECOND = "2";
	private final String THIRD = "3";
	private final String FOURTH = "4";
	private final String QUITE = "Q";
	private final String BACK = "B";
	
	private Scanner scanner;
	private String selector;
	
	public View(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void main() {
		Output.mainView();
		selector = Input.nextLine(scanner);
		if (selector.equals(QUITE)) {
			Output.print(Message.EXIT);
			System.exit(0);
		}
		moveManagementViewBySelector(selector);
	}
	
	private void moveManagementViewBySelector(String selector) {
		if (selector.equals(FIRST)) {
			stationManagement();
			return;
		} else if (selector.equals(SECOND)) {
			lineManagement();
			return;
		} else if (selector.equals(THIRD)) {
			sectionManagement();
			return;
		} else if (selector.equals(FOURTH)) {
			Output.title(Message.SUBWAY_LINE_VIEW);
			Subway.show();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
	
	private void stationManagement() {
		Output.stationManagement();
		selector = Input.nextLine(scanner);
		if (selector.equals(BACK)) {
			Output.print(Message.BACK_TO_MAIN);
			return;
		}
		moveStationViewBySelector(selector);
	}
	
	private void moveStationViewBySelector(String selector) {
		if (selector.equals(FIRST)) {
			ViewManager.createStation();
			return;
		} else if (selector.equals(SECOND)) {
			ViewManager.removeStation();
			return;
		} else if (selector.equals(THIRD)) {
			Subway.readStation();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
	
	private void lineManagement() {
		Output.lineManagement();
		selector = Input.nextLine(scanner);
		if (selector.equals(BACK)) {
			Output.print(Message.BACK_TO_MAIN);
			return;
		}
		moveLineViewBySelector(selector);
	}
	
	private void moveLineViewBySelector(String selector) {
		if (selector.equals(FIRST)) {
			ViewManager.createLine();
			return;
		} else if (selector.equals(SECOND)) {
			ViewManager.removeLine();
			return;
		} else if (selector.equals(THIRD)) {
			Subway.readLine();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
	
	private void sectionManagement() {
		Output.sectionManagement();
		selector = Input.nextLine(scanner);
		if (selector.equals(BACK)) {
			Output.print(Message.BACK_TO_MAIN);
			return;
		}
		moveSectionViewBySelector(selector);
	}
	
	private void moveSectionViewBySelector(String selector) {
		if (selector.equals(FIRST)) {
			ViewManager.createSection();
			return;
		} else if (selector.equals(SECOND)) {
			ViewManager.removeSection();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
}
