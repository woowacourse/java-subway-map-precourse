package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManager implements Message {

    protected static void register() {
        try {
            String name = InputView.getStationName();
            StationRepository.addStation(new Station(name));
            OutputView.printInfo(INFO_STATION_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    protected static void delete() {
        String stationName = InputView.getStationNameToDelete();
        try {
            StationRepository.deleteStation(stationName);
            OutputView.printInfo(INFO_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    protected static Station getStation(String name) {
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
        return StationRepository.getStation(name);
    }
}
