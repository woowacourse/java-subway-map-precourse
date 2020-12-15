package subway.service.section;

import subway.domain.Section;
import subway.service.section.addition.SectionAdditionService;
import subway.service.section.addition.SectionAdditionValidation;
import subway.service.section.deletion.SectionDeletionService;
import subway.service.section.deletion.SectionDeletionValidation;
import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.input.section.SectionScanView;
import subway.view.output.util.FeatureExceptionView;
import subway.view.output.util.ScreenView;
import subway.view.output.util.StateView;
import subway.view.output.section.SectionInformationView;
import subway.view.output.section.SectionTextView;

import java.util.Scanner;

public class SectionService extends StationService {
    @Override
    public void manage(Scanner scanner) {
        SectionService sectionService = new SectionService();

        System.out.println();
        while (true) {
            ScreenView.printSectionManagementScreen();
            String sectionInput = scanner.nextLine();

            if (sectionService.check(sectionInput)) {
                sectionService.choose(sectionInput, scanner);
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
        return input.equals(InputType.INPUT_BACK.getInput());
    }

    @Override
    public boolean choose(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return add(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return delete(scanner);
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return StateView.printNewLine();
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        SectionAdditionValidation sectionAdditionValidation = new SectionAdditionValidation();

        String lineName = SectionScanView.scanLineName(scanner);
        String stationName = SectionScanView.scanStationName(scanner);
        String order = SectionScanView.scanOrder(scanner);
        Section section = new Section(lineName, stationName, order);

        if (sectionAdditionValidation.checkSectionAdditionValidation(section)) {
            SectionAdditionService.addSection(section);
            SectionInformationView.printSectionAdditionInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Scanner scanner) {
        SectionDeletionValidation sectionDeletionValidation = new SectionDeletionValidation();

        SectionTextView.printSectionDeletionLineText();
        String lineName = scanner.nextLine();
        SectionTextView.printSectionDeletionStationText();
        String stationName = scanner.nextLine();

        if (sectionDeletionValidation.checkSectionDeletionValidation(lineName, stationName)) {
            SectionDeletionService.deleteSection(lineName, stationName);
            SectionInformationView.printSectionDeletionInformation();
            System.out.println();
            return true;
        }
        return false;
    }
}
