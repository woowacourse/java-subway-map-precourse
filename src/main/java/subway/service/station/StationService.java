package subway.service.station;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.util.ChoiceService;
import subway.service.subway.SubwayService;
import subway.service.util.FeatureInterface;
import subway.service.station.addition.StationAdditionValidation;
import subway.service.station.deletion.StationDeletionValidation;
import subway.service.station.show.StationShowService;
import subway.view.input.station.StationScanView;
import subway.view.output.station.StationInformationView;

import java.util.List;
import java.util.Scanner;

/**
 * StationService.java : 지하철 역 비즈니스 로직에 대한 서비스 클래스
 *
 * @author Daeun Lee
 * @version 1.0
 */
public class StationService extends SubwayService implements FeatureInterface {
    @Override
    public void manage(Scanner scanner) {
        ChoiceService stateService = new ChoiceService();

        System.out.println();
        while (true) {
            String stationInput = StationScanView.scanStationInputForManagement(scanner);

            if (stateService.choose(stationInput, scanner)) {
                break;
            }
        }
    }

    @Override
    public boolean add(Scanner scanner) {
        StationAdditionValidation stationAdditionValidation = new StationAdditionValidation();

        String stationName = StationScanView.scanStationNameForAddition(scanner);

        if (stationAdditionValidation.checkNameAdditionValidation(stationName)) {
            StationRepository.addStation(new Station(stationName));
            StationInformationView.printStationAdditionInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Scanner scanner) {
        StationDeletionValidation stationNameDeletionValidation = new StationDeletionValidation();

        String stationName = StationScanView.scanStationNameForDeletion(scanner);

        if (stationNameDeletionValidation.checkNameDeletionValidation(stationName)) {
            StationInformationView.printStationDeletionInformation();
            System.out.println();
            return true;
        }
        return false;
    }

    @Override
    public boolean show() {
        StationShowService stationShowService = new StationShowService();

        StringBuilder stringBuilder = new StringBuilder();
        List<String> stationNames = StationRepository.stationNames();

        stationShowService.readNames(stringBuilder, stationNames);
        System.out.println(stringBuilder);
        return true;
    }
}
