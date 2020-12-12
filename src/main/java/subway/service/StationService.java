package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.service.validation.StationValidation;
import subway.type.InputType;
import subway.type.StationType;
import subway.view.output.ExceptionView;
import subway.view.output.InformationView;
import subway.view.output.ScreenView;
import subway.view.output.TextView;

import java.util.Scanner;

public class StationService implements FeatureChoiceInterface, FeatureInterface {
    public static void initializeStations() {
        StationRepository.addStation(new Station(StationType.EDUCATION_UNIVERSITY.getStation()));
        StationRepository.addStation(new Station(StationType.GANGNAM.getStation()));
        StationRepository.addStation(new Station(StationType.YEOKSAM.getStation()));
        StationRepository.addStation(new Station(StationType.NAMBU_BUS_TERMINAL.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE.getStation()));
        StationRepository.addStation(new Station(StationType.YANGJAE_CITIZENS_FOREST.getStation()));
        StationRepository.addStation(new Station(StationType.MAEBONG.getStation()));
    }

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
        TextView.printStationAddingText();
        String stationName = scanner.nextLine();
        if (checkValidation(stationName)) {
            StationRepository.addStation(new Station(stationName));
            InformationView.printStationAddingInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    public static boolean checkValidation(String stationName) {
        StationValidation stationValidation = new StationValidation();

        if (stationValidation.checkNameDuplication(stationName)) {
            ExceptionView.printInvalidStationNameException();
            return false;
        }
        if (stationValidation.checkNameLength(stationName)) {
            ExceptionView.printInvalidStationNameLengthException();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Scanner scanner) {
        return false;
    }
}
