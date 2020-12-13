package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManager extends Manager implements Message {

    public static void request(String selection) {
        if (selection.equals(REGISTER)) {
            registerStation();
            return;
        }
        if (selection.equals(DELETE)) {
            deleteStation();
            return;
        }
        if (selection.equals(PRINT)) {
            OutputView.printStations();
            return;
        }
        OutputView.printError(ERROR_INVALID_SELECTION);
    }

    private static void registerStation() {
        try {
            String name = InputView.getStationName();
            StationRepository.addStation(new Station(name));
            OutputView.printInfo(INFO_STATION_REGISTERED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    private static void deleteStation() {
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
