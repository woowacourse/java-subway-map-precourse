package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.TextCollection;

public class StationService {
    private static StationService stationService;

    public static StationService getInstance() {
        if (stationService == null) {
            stationService = new StationService();
        }
        return stationService;
    }

    public boolean insert() {
        OutputView.printQuestion(TextCollection.REGISTER_STATION_MESSAGE);
        String stationName = InputView.inputValue();
        Station station = new Station(stationName);
        StationRepository.addStation(station);
        OutputView.printInformation(TextCollection.REGISTERED_STATION_MESSAGE);
        return true;
    }

    public boolean delete() {
        OutputView.printQuestion(TextCollection.DELETE_STATION_MESSAGE);
        String stationName = InputView.inputValue();
        StationRepository.deleteStation(stationName);
        OutputView.printInformation(TextCollection.DELETED_STATION_MESSAGE);
        return true;
    }

    public boolean search() {
        OutputView.printQuestion(TextCollection.STATION_LIST_MESSAGE);
        StationRepository.printAllStation();
        return true;
    }

    public boolean backup() {
        return true;
    }
}
