package subway.controller;

import subway.view.View;

import java.util.Scanner;

public class MainController {
	private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

	public static void showMainScreen() {
//		View.getInput(scanner);
		View.printMainScreen();
	}

	public static void choice(Scanner scanner) {
		View.getScreenChoiceInput(scanner);
	}
}
