package subway.service;

import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.service.abstraction.input.InputInterface;
import subway.type.InputType;
import subway.view.OutputView;

import java.util.Scanner;

public class SectionService implements InputInterface, FeatureChoiceInterface, FeatureInterface {
    public static void manageSection(Scanner scanner) {
        SectionService sectionService = new SectionService();

        System.out.println();
        while (true) {
            OutputView.printSectionManagementScreen();
            String sectionInput = scanner.next();
            if (sectionService.isInput(sectionInput)) {
                sectionService.chooseFeature(sectionInput, scanner);
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
    public void chooseFeature(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            // TODO: 구간 등록 기능 구현
            return;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            // TODO: 구간 삭제 기능 구현
            return;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return;
        }
    }

    @Override
    public void add(Scanner scanner) {

    }

    @Override
    public void delete(Scanner scanner) {

    }
}
