package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.domain.StationRepository;

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
	
}
