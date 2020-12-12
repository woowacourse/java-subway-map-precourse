package subway.service;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.controller.TransitMapController;
import subway.service.abstraction.input.InputInterface;
import subway.type.InputType;
import subway.view.output.ExceptionView;
import subway.view.output.ScreenView;

import java.util.Scanner;

public class SubwayService implements InputInterface {
    public static void manageSubway(Scanner scanner) {
        SubwayService subwayService = new SubwayService();

        while (true) {
            ScreenView.printMainScreen();
            String mainInput = scanner.nextLine();
            if (quitSubway(mainInput)) {
                break;
            }
            if (subwayService.isInput(mainInput)) {
                chooseSubwayFeature(mainInput, scanner);
                continue;
            }
            ExceptionView.printInvalidFeatureChoiceException();
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

    public static void chooseSubwayFeature(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            StationController.startStation(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            LineController.startLine(scanner);
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            SectionController.startSection(scanner);
        }
        if (input.equals(InputType.INPUT_FOUR.getInput())) {
            TransitMapController.showTransitMap();
        }
    }
}
