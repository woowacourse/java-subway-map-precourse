package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.StationView;

import java.util.Scanner;
import java.util.List;

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
        Name name = stationView.getStationNameToAdd();
        return Station.create(name);
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
        Name name = stationView.getStationNameToDelete();
        return StationRepository.getByName(name);
    }

    public void printStations() {
        List<String> names = StationRepository.getStationNames();
        stationView.printStationList(names);
    }
}
