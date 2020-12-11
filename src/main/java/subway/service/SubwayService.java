package subway.service;

import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayService extends FeatureService {
    public static void manageSubway(Scanner scanner) {
        SubwayService subwayService = new SubwayService();
        FeatureService featureService = new FeatureService();

        while (true) {
            OutputView.printMainScreen();
            String mainInput = scanner.next();
            if (quitSubway(mainInput)) {
                break;
            }
            if (subwayService.isInput(mainInput)) {
                featureService.chooseSubwayFeature(mainInput, scanner);
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
}
