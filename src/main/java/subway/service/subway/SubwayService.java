package subway.service.subway;

import subway.controller.LineController;
import subway.controller.SectionController;
import subway.controller.StationController;
import subway.controller.TransitMapController;
import subway.service.util.ChoiceService;
import subway.type.InputType;
import subway.view.input.subway.SubwayScanView;
import subway.view.output.util.FeatureChoiceExceptionView;

import java.util.Scanner;

/**
 * SubwayService.java : 지하철 비즈니스 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SubwayService extends ChoiceService implements SubwayInterface {
    @Override
    public void manage(Scanner scanner) {
        SubwayService subwayService = new SubwayService();

        while (true) {
            String mainInput = SubwayScanView.scanMainInputForManagement(scanner);

            if (check(mainInput)) {
                subwayService.choose(mainInput, scanner);
                continue;
            }
            if (quit(mainInput)) {
                break;
            }
            FeatureChoiceExceptionView.printInvalidFeatureChoiceException();
        }
    }

    public static boolean check(String input) {
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
