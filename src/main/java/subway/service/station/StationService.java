package subway.service.station;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.util.StateService;
import subway.service.subway.SubwayService;
import subway.service.util.FeatureInterface;
import subway.service.station.addition.StationAdditionValidation;
import subway.service.station.deletion.StationDeletionValidation;
import subway.service.station.show.StationShowService;
import subway.view.output.station.StationInformationView;
import subway.view.output.util.ScreenView;
import subway.view.output.station.StationTextView;

import java.util.List;
import java.util.Scanner;

public class StationService extends SubwayService implements FeatureInterface {
    @Override
    public void manage(Scanner scanner) {
        StateService stateService = new StateService();

        System.out.println();
        while (true) {
            ScreenView.printStationManagementScreen();
            String stationInput = scanner.nextLine();

            if ((stateService.check(stationInput))
                    && (stateService.choose(stationInput, scanner))) {
                break;
            }
        }
    }

    @Override
    public boolean add(Scanner scanner) {
        StationAdditionValidation stationAdditionValidation = new StationAdditionValidation();

        StationTextView.printStationAddingText();
        String stationName = scanner.nextLine();

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

        StationTextView.printStationDeletionText();
        String stationName = scanner.nextLine();

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
