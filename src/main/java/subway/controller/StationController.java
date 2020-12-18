package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.StationMenu;
import subway.screen.StationScreen;
import subway.view.Input;
import subway.view.Output;

public class StationController {
    private static final String ADD_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public static void executeStationMenu() {
        Output.printMenu(new StationScreen());
        StationMenu.execute(Input.chooseFunction());
    }
    
    public static void addStation() {
        try {
            Station station = new Station(Input.inputAddStationName());
            StationRepository.addStation(station);
            Output.printResult(ADD_SUCCESS_MESSAGE);
        } catch (Exception error) {
            Output.printError(error.getMessage());
        }
    }

    public static void deleteStation() {
        try {
            StationRepository.deleteStationByName(Input.inputDeleteStationName());
            Output.printResult(DELETE_SUCCESS_MESSAGE);
        } catch (Exception error) {
            Output.printError(error.getMessage());
        }
    }
}
