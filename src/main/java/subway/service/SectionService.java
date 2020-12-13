package subway.service;

import subway.service.abstraction.input.InputInterface;
import subway.type.InputType;
import subway.view.output.ExceptionView;
import subway.view.output.ScreenView;

import java.util.Scanner;

public class SectionService extends StationService implements InputInterface {
    public static void manageSection(Scanner scanner) {
        SectionService sectionService = new SectionService();

        System.out.println();
        while (true) {
            ScreenView.printSectionManagementScreen();
            String sectionInput = scanner.nextLine();
            if (sectionService.isInput(sectionInput)) {
                sectionService.chooseFeature(sectionInput, scanner);
                break;
            }
            ExceptionView.printInvalidFeatureChoiceException();
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
    public boolean chooseFeature(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            // TODO: 구간 등록 기능 구현
            return false;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            // TODO: 구간 삭제 기능 구현
            return false;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        return false;
    }

    @Override
    public boolean delete(Scanner scanner) {
        return false;
    }
}
