package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.view.InputView;
import subway.view.OutputView;

enum MainButton {
	STATION("1"), LINE("2"), SECTION("3"), PRINT_SUBWAY_MAP("4"), SYSTEM_OUT("Q");
	
	private final String button;
	
	MainButton(String button) {
		this.button = button;
	}
	
	public String getButton() {
		return button;
	}
}

public class MainManagement {
	private static final List<String> menu = Arrays.asList(
		MainButton.STATION.getButton(),
		MainButton.LINE.getButton(),
		MainButton.PRINT_SUBWAY_MAP.getButton(),
		MainButton.SYSTEM_OUT.getButton()
	);
	
	public static void execute() {
		OutputView.printMainMenu();
		String selectedButton = InputView.getSelectFunction();
		proceduresExecute(selectedButton);
	}
	
	public static void proceduresExecute(String selectedButton) {
		if (selectedButton.equals(MainButton.SYSTEM_OUT.getButton())) {
			return;
		} else if (selectedButton.equals(MainButton.STATION.getButton())) {
			StationManagement.execute();
		} else if (selectedButton.equals(MainButton.LINE.getButton())) {
			LineManagement.execute();
		} else if (selectedButton.equals(MainButton.SECTION.getButton())) {
			SectionManagement.execute();
		} else if (selectedButton.equals(MainButton.PRINT_SUBWAY_MAP.getButton())) {
			
		}
	}
}
