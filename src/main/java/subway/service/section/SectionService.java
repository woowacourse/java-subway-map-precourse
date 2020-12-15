package subway.service.section;

import subway.domain.Section;
import subway.service.section.addition.SectionAdditionService;
import subway.service.section.addition.SectionAdditionValidation;
import subway.service.section.deletion.SectionDeletionService;
import subway.service.section.deletion.SectionDeletionValidation;
import subway.service.station.StationService;
import subway.type.InputType;
import subway.view.input.section.SectionScanView;
import subway.view.output.util.FeatureChoiceExceptionView;
import subway.view.output.util.ScreenView;
import subway.view.output.section.SectionInformationView;

import java.util.Scanner;

/**
 * SectionService.java : 지하철 구간 비즈니스 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class SectionService extends StationService {
    @Override
    public void manage(Scanner scanner) {
        SectionService sectionService = new SectionService();

        System.out.println();
        while (true) {
            String sectionInput = SectionScanView.scanSectionInputForManagement(scanner);

            if (sectionService.choose(sectionInput, scanner)) {
                break;
            }
        }
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
            return ScreenView.printNewLine();
        }
        return FeatureChoiceExceptionView.printInvalidChoiceException();
    }

    @Override
    public boolean add(Scanner scanner) {
        SectionAdditionValidation sectionAdditionValidation = new SectionAdditionValidation();

        String lineName = SectionScanView.scanLineNameForAddition(scanner);
        String stationName = SectionScanView.scanStationNameForAddition(scanner);
        String order = SectionScanView.scanOrderForAddition(scanner);
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

        String lineName = SectionScanView.scanLineNameForDeletion(scanner);
        String stationName = SectionScanView.scanStationNameForDeletion(scanner);

        if (sectionDeletionValidation.checkSectionDeletionValidation(lineName, stationName)) {
            SectionDeletionService.deleteSection(lineName, stationName);
            SectionInformationView.printSectionDeletionInformation();
            System.out.println();
            return true;
        }
        return false;
    }
}
