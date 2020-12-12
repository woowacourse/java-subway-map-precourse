package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.type.StationType;
import subway.view.OutputView;

import java.util.Scanner;

public class StationService {
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
        FeatureService featureService = new FeatureService();

        System.out.println();
        while (true) {
            OutputView.printStationManagementScreen();
            String stationInput = scanner.next();
            if (featureService.isInput(stationInput)) {
                featureService.chooseFeature(stationInput);
                break;
            }
            OutputView.printInvalidFeatureChoiceException();
        }
    }
}
