package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineController {
	private static final List<String> options = new ArrayList<>();

	static {
		options.add(Options.OPTION_1.getOption());
		options.add(Options.OPTION_2.getOption());
		options.add(Options.OPTION_3.getOption());
		options.add(Options.BACK.getOption());
	}

	private static void createLine(Scanner scanner) {
		String name = View.getLineNameToRegister(scanner);
		String upwardDestination = View.getUpwardDestination(scanner);
		String downwardDestination = View.getDownwardDestination(scanner);
		Line line = new Line(name, upwardDestination, downwardDestination);
		LineRepository.addLine(line);
		View.printStationRegisterCompletion();
	}

	private static void deleteLine(Scanner scanner) {
		String name = View.getStationNameToDelete(scanner);
		boolean isSuccessful = LineRepository.deleteLine(name);
		if (isSuccessful) {
			View.printLineDeleteCompletion();
			return;
		}
		View.printLineDeleteError();
		deleteLine(scanner);
	}
}
