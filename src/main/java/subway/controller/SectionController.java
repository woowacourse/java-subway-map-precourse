package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.SectionMenu;
import subway.view.Input;

public class SectionController {
    private static final String ADD_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";
    
    public static void executeSectionMenu() {
    	SubwayController.output.printSectionMenu();
    	SectionMenu.execute(Input.chooseFunction());
    }
    
    public static void addSection() {
        try {
            Line line = LineRepository.getLineByName(Input.inputAddSectionLineName());
            Station station = StationRepository.getStationByName(Input.inputAddSectionStationName());
            int order = Integer.parseInt(Input.inputAddSectionOrder());
            LineRepository.addSection(line, station, order);
            SubwayController.output.printResult(ADD_SUCCESS_MESSAGE);
        } catch (Exception error) {
            SubwayController.output.printError(error.getMessage());
        }
    }
    
    public static void deleteSection() {
        try {
            Line line = LineRepository.getLineByName(Input.inputDeleteSectionLineName());
            Station station = StationRepository.getStationByName(Input.inputDeleteSectionStationName());
            LineRepository.deleteSection(line, station);
            SubwayController.output.printResult(DELETE_SUCCESS_MESSAGE);
        } catch (Exception error) {
            SubwayController.output.printError(error.getMessage());
        }
    }
}
