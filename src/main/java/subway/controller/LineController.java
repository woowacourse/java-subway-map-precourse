package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
	public static void showStationScreen(Scanner scanner) {
		InputView.getInput(scanner);
		OutputView.printLineScreen();
	}
}
