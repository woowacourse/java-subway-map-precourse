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
}
