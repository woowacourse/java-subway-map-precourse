package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.LineMenu;
import subway.screen.LineScreen;
import subway.view.Input;
import subway.view.Output;

public class LineController {
    private static final String ADD_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 노선이 삭제되었습니다.";
	
    public static void executeLineMenu() {
    	Output.printMenu(new LineScreen());
        LineMenu.execute(Input.chooseFunction());
    }
    
    public static void addLine() {
        try {
            Line line = new Line(Input.inputAddLineName());
            Station upTerminal = StationRepository.getStationByName(Input.inputAddLineUpTerminalName());
            Station downTerminal = StationRepository.getStationByName(Input.inputAddLineDownTerminalName());
            line.addUpTerminal(upTerminal);
            line.addDownTerminal(downTerminal);
            LineRepository.addLine(line);
            Output.printResult(ADD_SUCCESS_MESSAGE);
        } catch (Exception error) {
            Output.printError(error.getMessage());
        }
    }
	
    public static void deleteLine() {
        try {
            LineRepository.deleteLineByName(Input.inputDeleteLineName());
            Output.printResult(DELETE_SUCCESS_MESSAGE);
        } catch (Exception error) {
            Output.printError(error.getMessage());
        }
    }
}
