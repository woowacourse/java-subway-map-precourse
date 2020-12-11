package subway.service;

import subway.constant.Information;
import subway.constant.InitialData;
import subway.repository.StationRepository;

import java.util.Scanner;

public class StationService {

    private Scanner scanner;

    public StationService(Scanner scanner) {
        this.scanner = scanner;
        initStations();
    }

    private void initStations() {
        StationRepository.addStation(InitialData.stations);
    }

    public void run() {
        System.out.println(Information.STATION_INFO);
    }
}
