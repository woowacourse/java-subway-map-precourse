package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.service.validation.NameAddingValidation;
import subway.service.validation.NameDeletionValidation;
import subway.type.InputType;
import subway.view.output.station.StationInformationView;
import subway.view.output.ScreenView;
import subway.view.output.station.StationTextView;

import java.util.List;
import java.util.Scanner;

public class StationService implements FeatureChoiceInterface, FeatureInterface {
    public static void manageStation(Scanner scanner) {
        InputService inputService = new InputService();
        StationService stationService = new StationService();

        System.out.println();
        while (true) {
            ScreenView.printStationManagementScreen();
            String stationInput = scanner.nextLine();
            if ((inputService.isInput(stationInput))
                    && (stationService.chooseFeature(stationInput, scanner))) {
                break;
            }
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
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            // TODO: 역 조회 기능 구현
            return false;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        NameAddingValidation nameAddingValidation = new NameAddingValidation();

        StationTextView.printStationAddingText();
        String stationName = scanner.nextLine();

        if (nameAddingValidation.checkAddingValidation(stationName)) {
            StationRepository.addStation(new Station(stationName));
            StationInformationView.printStationAddingInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Scanner scanner) {
        NameDeletionValidation nameDeletionValidation = new NameDeletionValidation();

        StationTextView.printStationDeletionText();
        String stationName = scanner.nextLine();

        if (nameDeletionValidation.checkDeletionValidation(stationName)) {
            StationInformationView.printStationDeletionInformation();
            System.out.println();
            return true;
        }
        return false;
    }
}
