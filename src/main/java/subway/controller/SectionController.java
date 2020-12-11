package subway.controller;

import subway.service.SectionService;
import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionController {
    public static void startSection(Scanner scanner) {
        while (true) {
            OutputView.printSectionManagementScreen();
            String sectionInput = scanner.next();
            if (SectionService.isSectionInput(sectionInput)) {
                chooseSectionFeature(sectionInput);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }

    public static void chooseSectionFeature(String sectionInput) {
        if (sectionInput.equals(InputType.INPUT_ONE.getInput())) {
            return;
        }
        if (sectionInput.equals(InputType.INPUT_TWO.getInput())) {
            return;
        }
        if (sectionInput.equals(InputType.INPUT_BACK.getInput())) {
            return;
        }
    }
}
