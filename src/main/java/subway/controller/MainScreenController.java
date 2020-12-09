package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class MainScreenController {
	public static void showMainScreen(Scanner scanner) {
		InputView.getInput(scanner);
		OutputView.printMainScreen();
	}
}
