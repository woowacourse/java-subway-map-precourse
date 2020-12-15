package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.menu.StationMenu;
import subway.view.Input;

public class StationController {
    private static final String ADD_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";

    public static void executeStationMenu() {
        SubwayController.output.printStationMenu();
        StationMenu.execute(Input.chooseFunction());
    }
    
    public static void addStation() {
        try {
            Station station = new Station(Input.inputAddStationName());
            StationRepository.addStation(station);
            SubwayController.output.printResult(ADD_SUCCESS_MESSAGE);
        } catch (Exception error) {
            SubwayController.output.printError(error.getMessage());
        }
    }

    public static void deleteStation() {
        try {
            StationRepository.deleteStationByName(Input.inputDeleteStationName());
            SubwayController.output.printResult(DELETE_SUCCESS_MESSAGE);
        } catch (Exception error) {
            SubwayController.output.printError(error.getMessage());
        }
    }

    public static void printStation() {
        SubwayController.output.printStationListInfoMessage();
        for (Station station : StationRepository.stations()) {
            SubwayController.output.printResult(station.getName());
        }
    }
}
