package subway.controller;

import subway.domain.*;
import subway.view.OutputView;
import subway.view.StationView;

import java.util.Scanner;

public class StationController {
    private static StationController stationController = null;

    private final Scanner scanner;
    private final StationView stationView;

    private StationController(Scanner scanner) {
        this.scanner = scanner;
        stationView = StationView.getInstance(scanner);
    }

    public static StationController getInstance(Scanner scanner) {
        if (stationController == null) {
            stationController = new StationController(scanner);
            return stationController;
        }
        return stationController;
    }

    public void addStation() {
        try {
            StationRepository.addStation(getStationToAdd());
            stationView.announceAdditionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            addStation();
        }
    }

    private Station getStationToAdd() {
        return Station.create(stationView.getStationNameToAdd());
    }

    public void deleteStation() {
        try {
            StationRepository.remove(getStationToDelete());
            stationView.announceDeletionSuccess();
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            deleteStation();
        }
    }

    private Station getStationToDelete() {
        return StationRepository.getByName(stationView.getStationNameToDelete());
    }

    public void printStations() {
        stationView.printStationList(StationRepository.getStationNames());
        OutputView.printLineSeparator();
    }
}
