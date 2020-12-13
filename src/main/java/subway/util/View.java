package subway.util;

import java.util.Scanner;

import subway.Subway;

public class View {
	private Scanner scanner;
	private String stationName;
	private int selectorInt;
	
	public View(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void main() {
		Output.mainView();
		selectorInt = Input.nextInt(scanner);
		moveManagementViewBySelector(selectorInt);
	}
	
	private void moveManagementViewBySelector(int selectorInt) {
		if (selectorInt == 1) {
			stationManagement();
		}
	}
	
	private void stationManagement() {
		Output.stationManagement();
		selectorInt = Input.nextInt(scanner);
		moveStationViewBySelector(selectorInt);
	}
	
	private void moveStationViewBySelector(int selectorInt) {
		if (selectorInt == 1) {
			System.out.println(Message.STATION_NAME_INPUT);
			stationName = Input.nextLine(scanner);
			Subway.addStation(stationName);
		}
	}
}
