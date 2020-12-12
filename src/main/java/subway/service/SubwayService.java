package subway.service;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.input.InputInterface;
import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayService implements InputInterface, FeatureChoiceInterface {
    public static void manageSubway(Scanner scanner) {
        SubwayService subwayService = new SubwayService();

        while (true) {
            OutputView.printMainScreen();
            String mainInput = scanner.next();
            if (quitSubway(mainInput)) {
                break;
            }
            if (subwayService.isInput(mainInput)) {
                subwayService.chooseFeature(mainInput, scanner);
                continue;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }

    public static boolean quitSubway(String mainInput) {
        return mainInput.equals(InputType.INPUT_QUITTING.getInput());
    }

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
        return input.equals(InputType.INPUT_FOUR.getInput());
    }

    @Override
    public void chooseFeature(String input, Scanner scanner) {
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
    }
}
