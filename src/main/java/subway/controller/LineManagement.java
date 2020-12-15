package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

enum LineButton {
	REGISTER("1"), DELETE("2"), LOOK_UP("3"), BACK_TO_MAIN("B");
	
	private final String button;
	
	LineButton(String button) {
		this.button = button;
	}
	
	public String getButton() {
		return button;
	}
}

public class LineManagement {
	private LineRepository lineRepository = new LineRepository();
	
	private static final List<String> menu = Arrays.asList(
		LineButton.REGISTER.getButton(),
		LineButton.DELETE.getButton(),
		LineButton.LOOK_UP.getButton(),
		LineButton.BACK_TO_MAIN.getButton()
	);
	
	public static void execute() {
		OutputView.printLineManagementMenu();
		String selectedButton = InputView.getSelectFunction();
		proceduresExecute(selectedButton);
	}
	
	public static void proceduresExecute(String selectedButton) {
		if (selectedButton.equals(LineButton.BACK_TO_MAIN.getButton())) {
			return;
		} else if (selectedButton.equals(LineButton.REGISTER.getButton())) {
			registerLine();
		} else if (selectedButton.equals(LineButton.DELETE.getButton())) {
			deleteLine();
		} else if (selectedButton.equals(LineButton.LOOK_UP.getButton())) {
			OutputView.printTotalLine();
		}
	}
	
	public static void registerLine() {
		String lineName = InputView.getRegisterLine();
		String ascendingEndPoint = InputView.getAscendingEndPointLine();
		String descendingEndPoint = InputView.getDescendingEndPointLine();
		Line line = new Line(lineName,ascendingEndPoint,descendingEndPoint);
		LineRepository.addLine(line);
	}
	
	public static void deleteLine() {
		String lineName = InputView.getDeleteLine();
		LineRepository.deleteLineByName(lineName);
	}
}
