package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController {
	public static void showStationScreen(Scanner scanner) {
		InputView.getInput(scanner);
		OutputView.printStationScreen();
	}
}
