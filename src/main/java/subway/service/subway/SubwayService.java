package subway.service.subway;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.controller.TransitMapController;
import subway.service.util.StateService;
import subway.type.InputType;
import subway.view.output.util.FeatureExceptionView;
import subway.view.output.util.ScreenView;

import java.util.Scanner;

public class SubwayService extends StateService implements SubwayInterface {
    @Override
    public void manage(Scanner scanner) {
        SubwayService subwayService = new SubwayService();

        while (true) {
            ScreenView.printMainScreen();
            String mainInput = scanner.nextLine();

            if (subwayService.check(mainInput)) {
                subwayService.choose(mainInput, scanner);
                continue;
            }
            if (quit(mainInput)) {
                break;
            }
            FeatureExceptionView.printInvalidFeatureChoiceException();
        }
    }

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
        return input.equals(InputType.INPUT_FOUR.getInput());
    }

    @Override
    public boolean choose(String input, Scanner scanner) {
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
            TransitMapController.startTransitMap();
        }
        return true;
    }

    public static boolean quit(String mainInput) {
        return mainInput.equals(InputType.INPUT_QUITTING.getInput());
    }
}
