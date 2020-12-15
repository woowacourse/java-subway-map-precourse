package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.LineMenu;
import subway.view.Input;

public class LineController {
    private static final String ADD_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
	
    public static void line() {
    	SubwayController.output.printLineMenu();
        LineMenu.execute(Input.chooseFunction());
    }
    
    public static void addLine() {
        try {
            String[] info = Input.inputAddLine();
            Line line = new Line(info[0]);
            Station up = StationRepository.getStationByName(info[1]);
            Station down = StationRepository.getStationByName(info[2]);
            line.addUpTerminal(up);
            line.addDownTerminal(down);
            LineRepository.addLine(line);
            SubwayController.output.printResult(ADD_SUCCESS_MESSAGE);
        }catch(Exception error) {
            SubwayController.output.printError(error.getMessage());
        }
    }
	
    public static void deleteLine() {
        try {
            LineRepository.deleteLineByName(Input.inputDeleteLineName());
            SubwayController.output.printResult(DELETE_SUCCESS_MESSAGE);
        }catch(Exception error) {
            SubwayController.output.printError(error.getMessage());
        }
    }
	
    public static void printLine() {
        for (Line line : LineRepository.lines()) {
            SubwayController.output.printResult(line.getName());
        }
    }
}
