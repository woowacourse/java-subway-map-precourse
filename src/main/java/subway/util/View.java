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
		moveManagementViewBySelector(selector);
	}
	
	private void moveManagementViewBySelector(String selector) {
		if (selector.equals("1")) {
			stationManagement();
		} else if (selector.equals("2")) {
			lineManagement();
		} else if (selector.equals("3")) {
			sectionManagement();
		} else if (selector.equals("4")) {
			Output.title(Message.SUBWAY_LINE_VIEW);
			Subway.show();
		}
	}
	
	private void stationManagement() {
		Output.stationManagement();
		selector = Input.nextLine(scanner);
		moveStationViewBySelector(selector);
	}
	
	private void moveStationViewBySelector(String selector) {
		if (selector.equals("1")) {
			ViewManager.createStation();
		} else if (selector.equals("2")) {
			ViewManager.removeStation();
		} else if (selector.equals("3")) {
			Subway.readStation();
		}
	}
	
	private void lineManagement() {
		Output.lineManagement();
		selector = Input.nextLine(scanner);
		moveLineViewBySelector(selector);
	}
	
	private void moveLineViewBySelector(String selector) {
		if (selector.equals("1")) {
			ViewManager.createLine();
		} else if (selector.equals("2")) {
			ViewManager.removeLine();
		} else if (selector.equals("3")) {
			Subway.readLine();
		}
	}
	
	private void sectionManagement() {
		Output.sectionManagement();
		selector = Input.nextLine(scanner);
		moveSectionViewBySelector(selector);
	}
	
	private void moveSectionViewBySelector(String selector) {
		if (selector.equals("1")) {
			ViewManager.createSection();
		} else if (selector.equals("2")) {
			ViewManager.removeSection();
		}
	}
}
