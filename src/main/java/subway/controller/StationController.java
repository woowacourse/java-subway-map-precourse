package subway.controller;

import subway.service.StationService;
import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class StationController {
    public static void startStation(Scanner scanner) {
        while (true) {
            OutputView.printStationManagementScreen();
            String stationInput = scanner.next();
            if (StationService.isStationInput(stationInput)) {
                chooseStationFeature(stationInput);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }

    public static void chooseStationFeature(String stationInput) {
        if (stationInput.equals(InputType.INPUT_ONE.getInput())) {
            return;
        }
        if (stationInput.equals(InputType.INPUT_TWO.getInput())) {
            return;
        }
        if (stationInput.equals(InputType.INPUT_THREE.getInput())) {
            return;
        }
        if (stationInput.equals(InputType.INPUT_BACK.getInput())) {
            return;
        }
    }
}
