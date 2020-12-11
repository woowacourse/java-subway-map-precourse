package subway.controller;

import subway.service.LineService;
import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class LineController {
    public static void startLine(Scanner scanner) {
        while (true) {
            OutputView.printLineManagementScreen();
            String lineInput = scanner.next();
            if (LineService.isLineInput(lineInput)) {
                chooseLineFeature(lineInput);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }

    public static void chooseLineFeature(String lineInput) {
        if (lineInput.equals(InputType.INPUT_ONE.getInput())) {
            return;
        }
        if (lineInput.equals(InputType.INPUT_TWO.getInput())) {
            return;
        }
        if (lineInput.equals(InputType.INPUT_THREE.getInput())) {
            return;
        }
        if (lineInput.equals(InputType.INPUT_BACK.getInput())) {
            return;
        }
    }
}
