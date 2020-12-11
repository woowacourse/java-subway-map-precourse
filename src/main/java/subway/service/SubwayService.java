package subway.service;

import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayService {
    public static void manageSubway(Scanner scanner) {
        FeatureService featureService = new FeatureService();

        while (true) {
            OutputView.printMainScreen();
            String mainInput = scanner.next();
            if (quitSubway(mainInput)) {
                break;
            }
            featureService.chooseSubwayFeature(mainInput, scanner);
        }
    }

    public static boolean quitSubway(String mainInput) {
        return mainInput.equals(InputType.INPUT_QUITTING.getInput());
    }
}
