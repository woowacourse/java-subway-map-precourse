package subway.service;

import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionService extends FeatureService {
    public static void manageSection(Scanner scanner) {
        SectionService sectionService = new SectionService();

        while (true) {
            OutputView.printSectionManagementScreen();
            String sectionInput = scanner.next();
            if (sectionService.isInput(sectionInput)) {
                sectionService.chooseFeature(sectionInput);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }

    @Override
    public boolean isInput(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return true;
        }
        return input.equals(InputType.INPUT_BACK.getInput());
    }

    @Override
    public void chooseFeature(String input) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return;
        }
    }
}
