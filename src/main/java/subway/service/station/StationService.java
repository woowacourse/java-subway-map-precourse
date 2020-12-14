package subway.service.station;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.SubwayService;
import subway.service.abstraction.FeatureInterface;
import subway.type.InputType;
import subway.view.output.ExceptionView;
import subway.view.output.station.StationInformationView;
import subway.view.output.ScreenView;
import subway.view.output.station.StationTextView;

import java.util.List;
import java.util.Scanner;

public class StationService extends SubwayService implements FeatureInterface {
    @Override
    public void manage(Scanner scanner) {
        StationService stationService = new StationService();

        System.out.println();
        while (true) {
            ScreenView.printStationManagementScreen();
            String stationInput = scanner.nextLine();

            if ((stationService.check(stationInput))
                    && (stationService.choose(stationInput, scanner))) {
                break;
            }
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
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return true;
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            return true;
        }
        ExceptionView.printInvalidFeatureChoiceException();
        return false;
    }

    @Override
    public boolean choose(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            return add(scanner);
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            return delete(scanner);
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            return show();
        }
        if (input.equals(InputType.INPUT_BACK.getInput())) {
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Scanner scanner) {
        StationAddingValidation nameAddingValidation = new StationAddingValidation();

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
        StationDeletionValidation stationNameDeletionValidation = new StationDeletionValidation();

        StationTextView.printStationDeletionText();
        String stationName = scanner.nextLine();

        if (stationNameDeletionValidation.checkDeletionValidation(stationName)) {
            StationInformationView.printStationDeletionInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean show() {
        StationNameService stationNameService = new StationNameService();

        StringBuilder stringBuilder = new StringBuilder();
        List<String> stationNames = StationRepository.stationNames();

        stationNameService.readNames(stringBuilder, stationNames);
        System.out.println(stringBuilder);
        return true;
    }
}
