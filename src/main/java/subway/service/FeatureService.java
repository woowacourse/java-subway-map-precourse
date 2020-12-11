package subway.service;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class FeatureService implements FeatureInterface {
    @Override
    public boolean isInput(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return true;
        }
        return input.equals(InputType.INPUT_BACK.getInput());
    }

    @Override
    public void chooseSubwayFeature(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            StationController.startStation(scanner);
            return;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            LineController.startLine(scanner);
            return;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            SectionController.startSection(scanner);
            return;
        }
        if (input.equals(InputType.INPUT_FOUR.getInput())) {
            // TODO: 지하철 노선도 출력 기능 구현
            return;
        }
        OutputView.printInvalidFeatureChoiceException();
    }

    @Override
    public void chooseFeature(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return;
        }
    }
}
