package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.abstraction.feature.FeatureChoiceInterface;
import subway.service.abstraction.feature.FeatureInterface;
import subway.type.InputType;
import subway.type.StationType;
import subway.view.OutputView;

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
            OutputView.printStationManagementScreen();
            String stationInput = scanner.next();
            if (inputService.isInput(stationInput)) {
                stationService.chooseFeature(stationInput, scanner);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }

    @Override
    public void chooseFeature(String input, Scanner scanner) {
        if (input.equals(InputType.INPUT_ONE.getInput())) {
            // TODO: 역 등록 기능 구현
            return;
        }
        if (input.equals(InputType.INPUT_TWO.getInput())) {
            // TODO: 역 삭제 기능 구현
            return;
        }
        if (input.equals(InputType.INPUT_THREE.getInput())) {
            // TODO: 역 조회 기능 구현
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
