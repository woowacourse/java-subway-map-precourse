package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.utils.ValidateUtils;
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
        InputView.printQuestion(TextCollection.REGISTER_STATION_MESSAGE);
        String stationName = InputView.inputValue();
        Station station = new Station(stationName);
        StationRepository.addStation(station);
        OutputView.printInformation(TextCollection.REGISTERED_STATION_MESSAGE);
        return true;
    }

    public boolean delete() {
        return true;
    }

    public boolean search() {
        return true;
    }

    public boolean backup() {
        return true;
    }
}
