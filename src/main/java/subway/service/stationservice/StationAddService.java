package subway.service.stationservice;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.views.InputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationAddService {
    private static final String DUPLICATED_STATION_NAME_MESSAGE = "\n[ERROR] 해당 역은 이미 등록되었습니다.";
    private static final StationAddService stationAddService = new StationAddService();

    private StationAddService() {
    }

    public static StationAddService getInstance() {
        return stationAddService;
    }

    public void stationAddService(Scanner scanner) {
        try {
            Station newStation = makeNewStation(scanner);
            addStationToRepository(newStation);
        } catch (IllegalArgumentException e) {
            StationService.goToMenu(e, scanner);
        }
    }
    private Station makeNewStation(Scanner scanner) {
        StationOutputView.printStationNameToAddMessage();
        Station newStation = new Station(InputView.userInput(scanner));
        isDuplicatedStation(newStation);
        return newStation;
    }

    private void isDuplicatedStation(Station station) {
        if (StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_NAME_MESSAGE);
        }
    }

    private void addStationToRepository(Station newStation) {
        StationRepository.addStation(newStation);
        StationOutputView.printAddSuccess();
    }
}