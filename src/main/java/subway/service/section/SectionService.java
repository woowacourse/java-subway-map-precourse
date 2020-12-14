package subway.service.section;

import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.output.ExceptionView;
import subway.view.output.ScreenView;
import subway.view.output.section.SectionTextView;

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
            return add(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return delete(scanner);
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        SectionAddingValidation sectionAddingValidation = new SectionAddingValidation();

        String lineName = SectionAddingService.scanLineName(scanner);
        if (!sectionAddingValidation.checkLineNameValidation(lineName)) {
            return false;
        }
        String stationName = SectionAddingService.scanStationName(scanner);
        if (!sectionAddingValidation.checkStationNameValidation(lineName, stationName)) {
            return false;
        }
        String order = SectionAddingService.scanOrder(scanner);

        return true;
    }

    @Override
    public boolean delete(Scanner scanner) {
        SectionTextView.printSectionDeletionLineText();
        String lineName = scanner.nextLine();
        SectionTextView.printSectionDeletionStationText();
        String stationName = scanner.nextLine();

        return true;
    }
}
