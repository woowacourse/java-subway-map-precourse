package subway.service.util;

import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.output.util.FeatureExceptionView;
import subway.view.output.util.StateView;

import java.util.Scanner;

public class StateService implements StateInterface {
    @Override
    public boolean check(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return true;
        }
        FeatureExceptionView.printInvalidFeatureChoiceException();
        return false;
    }

    @Override
    public boolean choose(String input, Scanner scanner) {
        StationService stationService = new StationService();

        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return stationService.add(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return stationService.delete(scanner);
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return stationService.show();
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return StateView.printNewLine();
        }
        return false;
    }
}
