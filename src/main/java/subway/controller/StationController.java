package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.validator.StationValidator;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationView;

import java.util.Scanner;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
        Station station = getStationToAdd();
        StationRepository.addStation(station);
        stationView.announceAdditionSuccess();
    }

    public Station getStationToAdd() {
        try {
            Name name = stationView.getStationNameToAdd();
            StationValidator.checkNonExistingName(name);
            return Station.create(name);
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getStationToAdd();
        }
    }

    public void deleteStation() {
        Station station = getStationToDelete();
        StationRepository.remove(station);
        stationView.announceDeletionSuccess();
    }

    private Station getStationToDelete() {
        try {
            Name name = stationView.getStationNameToDelete();
            Station station = StationRepository.getByName(name);
            StationValidator.checkIsNotOnLine(station);
            return station;
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            return getStationToDelete();
        }
    }

    public void printStations() {
        List<String> names = StationRepository.getStationNames();
        stationView.printStationList(names);
    }
}
