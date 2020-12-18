package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.SectionMenu;
import subway.screen.SectionScreen;
import subway.view.Input;
import subway.view.Output;

public class SectionController {
    private static final String ADD_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";
    
    public static void executeSectionMenu() {
    	Output.printMenu(new SectionScreen());
    	SectionMenu.execute(Input.chooseFunction());
    }
    
    public static void addSection() {
        try {
            Line line = LineRepository.getLineByName(Input.inputAddSectionLineName());
            Station station = StationRepository.getStationByName(Input.inputAddSectionStationName());
            int order = Integer.parseInt(Input.inputAddSectionOrder());
            LineRepository.addSection(line, station, order);
            Output.printResult(ADD_SUCCESS_MESSAGE);
        } catch (Exception error) {
            Output.printError(error.getMessage());
        }
    }
    
    public static void deleteSection() {
        try {
            Line line = LineRepository.getLineByName(Input.inputDeleteSectionLineName());
            Station station = StationRepository.getStationByName(Input.inputDeleteSectionStationName());
            LineRepository.deleteSection(line, station);
            Output.printResult(DELETE_SUCCESS_MESSAGE);
        } catch (Exception error) {
            Output.printError(error.getMessage());
        }
    }
}
