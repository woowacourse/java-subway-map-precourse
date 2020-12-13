package subway.service.section;

import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.output.ExceptionView;
import subway.view.output.ScreenView;

import java.util.Scanner;

public class SectionService extends StationService {
    public static void manageSection(Scanner scanner) {
        SectionService sectionService = new SectionService();
        SectionInputService sectionInputService = new SectionInputService();

        System.out.println();
        while (true) {
            ScreenView.printSectionManagementScreen();
            String sectionInput = scanner.nextLine();

            if (sectionInputService.isInput(sectionInput)) {
                sectionService.chooseFeature(sectionInput, scanner);
                break;
            }
            ExceptionView.printInvalidFeatureChoiceException();
        }
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
            System.out.println();
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
