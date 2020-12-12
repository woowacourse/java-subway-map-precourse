package subway.domain.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.input.StationManageInput;

import java.util.List;
import java.util.Scanner;

public class StationManageController {

    static final String FUNCTION_ONE = "1";
    static final String FUNCTION_TWO = "2";
    static final String FUNCTION_THREE = "3";
    static final String FUNCTION_BACK = "B";

    StationManageInput input = new StationManageInput();
    List<String> functionList = input.functionList();

    public void processEnrollStation(Scanner scanner) {
        if (input.inputStationManageScreen(scanner).equals(FUNCTION_ONE)) {
            Station station = new Station(input.inputEnrollStation(scanner));
            StationRepository.addStation(station);
        }
    }

}
