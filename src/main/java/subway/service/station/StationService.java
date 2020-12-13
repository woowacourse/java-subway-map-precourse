package subway.service.station;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.InputService;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.service.validation.NameAddingValidation;
import subway.service.validation.NameDeletionValidation;
import subway.type.InputType;
import subway.view.output.station.StationInformationView;
import subway.view.output.ScreenView;
import subway.view.output.station.StationTextView;

import java.util.LinkedList;
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
            return show();
        }
        return input.equals(InputType.INPUT_BACK.getInput());
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

    @Override
    public boolean show() {
        StringBuilder stringBuilder = new StringBuilder();

        List<Station> stations = StationRepository.stations();
        List<String> stationNames = getStationNames(stations);

        StationNameService.readStationName(stringBuilder, stationNames);
        System.out.println(stringBuilder);
        return true;
    }

    public static List<String> getStationNames(List<Station> stations) {
        List<String> stationNames = new LinkedList<>();

        for (Station station : stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }
}
