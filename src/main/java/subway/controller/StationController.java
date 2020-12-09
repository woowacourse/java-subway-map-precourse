package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController {
	private static final String REGISTER_MESSAGE = "## 등록할 역 이름을 입력하세요.";

	private static void showStationScreen() {
		OutputView.printStationScreen();
	}

	private static void createStation(Scanner scanner) {
		System.out.println(REGISTER_MESSAGE);
		String name = InputView.getInput(scanner);
		StationRepository.addStation(new Station(name));
	}
}
