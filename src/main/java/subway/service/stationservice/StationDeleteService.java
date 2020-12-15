package subway.service.stationservice;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.views.InputView;
import subway.views.stationviews.StationOutputView;

import java.util.Scanner;

public class StationDeleteService {
    private static final String NOT_EXIST_TO_DELETE_MESSAGE = "\n[ERROR] 삭제할 역이 존재하지 않습니다.";
    private static final String CANNOT_DELETE_LINE_REGISTERED_STATION = "\n[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.";
    private static final StationDeleteService stationDeleteService = new StationDeleteService();

    private StationDeleteService() {
    }

    public static StationDeleteService getInstance() {
        return stationDeleteService;
    }

    public void stationDeleteService(Scanner scanner) {
        try {
            String stationNameToDelete = makeStationNameToDelete(scanner);
            deleteStationFromRepository(stationNameToDelete);
        } catch (IllegalArgumentException e) {
            StationService.goToMenu(e, scanner);
        }
    }

    private String makeStationNameToDelete(Scanner scanner) {
        StationOutputView.printStationNameToDeleteMessage();
        String stationNameToDelete = InputView.userInput(scanner);
        isNotExistStation(new Station(stationNameToDelete));
        isLineRegisteredStation(stationNameToDelete);
        return stationNameToDelete;
    }

    private void isNotExistStation(Station station) {
        if (!StationRepository.stations().contains(station)) {
            throw new IllegalArgumentException(NOT_EXIST_TO_DELETE_MESSAGE);
        }
    }

    private void isLineRegisteredStation(String stationNameToDelete) {
        if (LineRepository.lines().stream().map(Line::getStations).anyMatch(station -> station.contains(new Station(stationNameToDelete)))) {
            throw new IllegalArgumentException(CANNOT_DELETE_LINE_REGISTERED_STATION);
        }
    }

    private void deleteStationFromRepository(String stationNameToDelete) {
        StationRepository.deleteStation(stationNameToDelete);
        StationOutputView.printDeleteSuccess();
    }
}
