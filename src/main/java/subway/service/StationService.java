package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.views.stationviews.StationInputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationService {
    private static final String DUPLICATED_STATION_NAME_MESSAGE = "\n[ERROR] 해당 역은 이미 등록되었습니다.";

    final Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStationService() {
        try {
            String inputName = StationInputView.inputStationName(scanner);
            Station newStation = new Station(inputName);
            isDuplicatedStation(newStation);
            StationRepository.addStation(newStation);
            StationOutputView.printInsertSuccess();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            addStationService();
        }
    }

    private void isDuplicatedStation(Station station) {
        if (StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_NAME_MESSAGE);
        }
    }
}
