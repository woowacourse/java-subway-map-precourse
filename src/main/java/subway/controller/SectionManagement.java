package subway.controller;

import java.util.Arrays;
import java.util.List;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

enum SectionButton {
	REGISTER("1"), DELETE("2"), BACK_TO_MAIN("B");
	
	private final String button;
	
	SectionButton(String button) {
		this.button = button;
	}
	
	public String getButton() {
		return button;
	}
}

public class SectionManagement {

	private StationRepository stationRepository = new StationRepository();
	
	private static final List<String> menu = Arrays.asList(
			SectionButton.REGISTER.getButton(),
			SectionButton.DELETE.getButton(),
			SectionButton.BACK_TO_MAIN.getButton()
	);
	
	public static void execute() {
		OutputView.printSectionManagementMenu();
		String selectedButton = InputView.getSelectFunction();
		proceduresExecute(selectedButton);
	}
	
	public static void proceduresExecute(String selectedButton) {
		if (selectedButton.equals(SectionButton.BACK_TO_MAIN.getButton())) {
			return;
		} else if (selectedButton.equals(SectionButton.REGISTER.getButton())) {
			registerSection();
		} else if (selectedButton.equals(SectionButton.DELETE.getButton())) {
			deleteSection();
		}
	}
	
	public static void registerSection() {
		String lineName = InputView.getSelectLineSection();
		String stationName = InputView.getSelectStationSection();
		Line sectionLine = LineRepository.getLineName(lineName);
		Station sectionStation = StationRepository.getStationName(stationName);
		int sequence = InputView.getRegisterSequenceSection();
		sectionLine.registerSection(sequence, stationName);
		sectionStation.registerStationSet(stationName);
	}
	
	public static void deleteSection() {
		String lineName = InputView.getDeleteLineSection();
		String stationName = InputView.getDeleteStationSection();
		Line sectionLine = LineRepository.getLineName(lineName);
		Station sectionStation = StationRepository.getStationName(stationName);
		sectionLine.deleteSection(lineName);
		sectionStation.deleteStationSet(stationName);
	}
}
