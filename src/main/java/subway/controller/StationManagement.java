package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

enum StationButton {
	REGISTER("1"), DELETE("2"), LOOK_UP("3"), BACK_TO_MAIN("B");
	
	private final String button;
	
	StationButton(String button) {
		this.button = button;
	}
	
	public String getButton() {
		return button;
	}
}

public class StationManagement {
	private StationRepository stationRepository = new StationRepository();
	
	private static final List<String> menu = Arrays.asList(
			StationButton.REGISTER.getButton(),
			StationButton.DELETE.getButton(),
			StationButton.LOOK_UP.getButton(),
			StationButton.BACK_TO_MAIN.getButton()
	);
	
	public static void execute() {
		OutputView.printStationManagementMenu();
		String selectedButton = InputView.getSelectFunction();
		proceduresExecute(selectedButton);
	}
	
	public static void proceduresExecute(String selectedButton) {
		if (selectedButton.equals(StationButton.BACK_TO_MAIN.getButton())) {
			return;
		} else if (selectedButton.equals(StationButton.REGISTER.getButton())) {
			
		} else if (selectedButton.equals(StationButton.DELETE.getButton())) {
			
		} else if (selectedButton.equals(StationButton.LOOK_UP.getButton())) {
			
		}
	}
	
	public static void registerStation() {
		String stationName = InputView.getRegisterStation();
		Station station = new Station(stationName);
		StationRepository.addStation(station);
	}
	
	public static void deleteStation() {
		String stationName = InputView.getDeleteStation();
		StationRepository.deleteStation(stationName);
	}
	
	
}
