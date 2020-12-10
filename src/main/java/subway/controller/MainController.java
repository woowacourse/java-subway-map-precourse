package subway.controller;

import subway.view.View;

import java.util.Scanner;

public class MainController {
	public static void run(Scanner scanner) {
		View.printMainScreen();
		String option = View.getScreenChoiceInput(scanner);
		controlByOption(option, scanner);
	}

	private static void controlByOption(String option, Scanner scanner) {
		// 1,2,3,4,Q
	}
}
