package subway.controller;

import subway.domain.Name;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
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

    public static StationController getInstance(Scanner scanner){
        if(stationController == null){
            stationController = new StationController(scanner);
            return stationController;
        }
        return stationController;
    }

    public void addStation() {
        Station station = new Station(stationView.getStationNameToAdd());
        StationRepository.addStation(station);
        stationView.announceAdditionSuccess();
    }

    public void deleteStation() {
        Station station = getStationToDelete();
        StationRepository.remove(station);
        stationView.announceDeletionSuccess();
    }

    private Station getStationToDelete() {
        try {
            Name name = stationView.getStationNameToDelete();
            return StationRepository.getByName(name);
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
