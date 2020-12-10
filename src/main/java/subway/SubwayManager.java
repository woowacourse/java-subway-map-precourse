package subway;

import java.util.Scanner;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.OutputView;

public class SubwayManager implements Message {

    private static final int MIN_NAME_LENGTH = 3;
    private final Scanner scanner;

    SubwayManager(Scanner scanner) {
        this.scanner = scanner;

    }

    public void run() {
        registerStation();
        OutputView.printStations();
        deleteStation();
    }

    private void registerStation() {
        OutputView.printAnnouncement(ANN_REGISTER_STATION);
        try {
            String stationName = getStationName();
            validateStationName(stationName);
            Station newStation = new Station(stationName);
            StationRepository.addStation(newStation);
            OutputView.printInfo(INFO_STATION_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            registerStation();
        }
    }

    private void deleteStation() {
        OutputView.printAnnouncement(ANN_DELETE_STATION);
        String stationName = getStationName();
        try {
            checkDeletable(stationName);
            OutputView.printInfo(INFO_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private void checkDeletable(String stationName) {
        // TODO: 해당 역이 노선에 등록되어 있는지 확인

        if (!StationRepository.deleteStation(stationName)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
    }

    private String getStationName() {
        return scanner.nextLine().trim();
    }

    public void validateStationName(String stationName) {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_STATION_NAME_LENGTH);
        }
        if (StationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(ERROR_ALREADY_REGISTERED_STATION);
        }
    }


}
