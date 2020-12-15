package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManager implements Message {

    protected static void register() {
        String name = InputView.getStationName();
        StationRepository.addStation(new Station(name));
        OutputView.printInfo(INFO_STATION_REGISTERED);
    }

    protected static void delete() {
        String stationName = InputView.getStationNameToDelete();
        StationRepository.deleteStation(stationName);
        OutputView.printInfo(INFO_STATION_DELETED);
    }

    protected static Station getStation(String name) {
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
        return StationRepository.getStation(name);
    }
}
