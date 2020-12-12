package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;
import java.util.List;

public class StationController {
    private static StationController stationController = null;
    private final Scanner scanner;

    private StationController(Scanner scanner){
        this.scanner = scanner;
    }

    public static StationController getInstance(Scanner scanner){
        if(stationController == null){
            return new StationController(scanner);
        }
        return stationController;
    }
}
