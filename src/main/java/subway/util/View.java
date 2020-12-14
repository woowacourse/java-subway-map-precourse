package subway.util;

import java.util.Scanner;

import subway.Subway;

public class View {
	private Scanner scanner;
	private String selector;
	
	public View(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void main() {
		Output.mainView();
		selector = Input.nextLine(scanner);
		if (selector.equals("Q")) {
			Output.print(Message.EXIT);
			System.exit(0);
		}
		moveManagementViewBySelector(selector);
	}
	
	private void moveManagementViewBySelector(String selector) {
		if (selector.equals("1")) {
			stationManagement();
			return;
		} else if (selector.equals("2")) {
			lineManagement();
			return;
		} else if (selector.equals("3")) {
			sectionManagement();
			return;
		} else if (selector.equals("4")) {
			Output.title(Message.SUBWAY_LINE_VIEW);
			Subway.show();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
	
	private void stationManagement() {
		Output.stationManagement();
		selector = Input.nextLine(scanner);
		if (selector.equals("B")) {
			Output.print(Message.BACK_TO_MAIN);
			return;
		}
		moveStationViewBySelector(selector);
	}
	
	private void moveStationViewBySelector(String selector) {
		if (selector.equals("1")) {
			ViewManager.createStation();
			return;
		} else if (selector.equals("2")) {
			ViewManager.removeStation();
			return;
		} else if (selector.equals("3")) {
			Subway.readStation();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
	
	private void lineManagement() {
		Output.lineManagement();
		selector = Input.nextLine(scanner);
		if (selector.equals("B")) {
			Output.print(Message.BACK_TO_MAIN);
			return;
		}
		moveLineViewBySelector(selector);
	}
	
	private void moveLineViewBySelector(String selector) {
		if (selector.equals("1")) {
			ViewManager.createLine();
			return;
		} else if (selector.equals("2")) {
			ViewManager.removeLine();
			return;
		} else if (selector.equals("3")) {
			Subway.readLine();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
	
	private void sectionManagement() {
		Output.sectionManagement();
		selector = Input.nextLine(scanner);
		if (selector.equals("B")) {
			Output.print(Message.BACK_TO_MAIN);
			return;
		}
		moveSectionViewBySelector(selector);
	}
	
	private void moveSectionViewBySelector(String selector) {
		if (selector.equals("1")) {
			ViewManager.createSection();
			return;
		} else if (selector.equals("2")) {
			ViewManager.removeSection();
			return;
		}
		Output.error(Message.WRONG_INPUT);
	}
}
