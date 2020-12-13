package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.utils.Message;
import subway.view.InputView;
import subway.view.OutputView;

public class StationManager implements Message {

    private static final String REGISTER = "1";
    private static final String DELETE = "2";
    private static final String PRINT = "3";

    public static void request(String selection) {
        if (selection.equals(REGISTER)) {
            registerStation();
        }
        if (selection.equals(DELETE)) {
            deleteStation();
        }
        if (selection.equals(PRINT)) {
            OutputView.printStations();
        }
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
        OutputView.printAnnouncement(ANN_DELETE_STATION);
        String stationName = InputView.getInput();
        try {
            StationRepository.deleteStation(stationName);
            OutputView.printInfo(INFO_STATION_DELETED);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }

    protected static Station getStation() {
        String name = InputView.getInput();
        if (!StationRepository.hasStation(name)) {
            throw new IllegalArgumentException(ERROR_NOT_REGISTERED_STATION);
        }
        return StationRepository.getStation(name);
    }
}
