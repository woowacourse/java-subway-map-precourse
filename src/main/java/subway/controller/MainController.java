package subway.controller;

import subway.view.View;

import java.util.Scanner;

public class MainController {
	public static void run(Scanner scanner) {
		View.printMainScreen();
		View.getScreenChoiceInput(scanner);

	}
}
