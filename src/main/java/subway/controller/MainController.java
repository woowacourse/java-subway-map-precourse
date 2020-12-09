package subway.controller;

import subway.view.View;

public class MainController {
	private static final String CHOICE_MESSAGE = "## 원하는 기능을 선택하세요.";

	public static void showMainScreen() {
//		InputView.getInput(scanner);
		View.printMainScreen();
	}
}
