package subway.controller;

import subway.domain.StationManager;
import subway.view.PrintInfo;
import subway.view.Error;

import java.util.Scanner;
import java.util.stream.Collectors;

public class StationMenu extends Menu {
    public StationMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void info() {
        PrintInfo.manageStation();
    }

    @Override
    protected boolean functionOne() {
        return addStation();
    }

    @Override
    protected boolean functionTwo() {
        return deleteStation();
    }

    @Override
    protected boolean functionThree() {
        return printStations();
    }

    private boolean printStations() {
        PrintInfo.stations(StationManager.allStations().stream().map(station -> station.getName()).collect(Collectors.toList()));
        return true;
    }

    private boolean addStation() {
        PrintInfo.inputAddStationName();
        String stationName = scanner.nextLine();
        if (!StationManager.validNameLength(stationName)) {
            return Error.nameLength();
        }
        if (!StationManager.addStation(stationName)) {
            return Error.alreadyExist();
        }
        PrintInfo.addStationSuccess();
        return true;
    }

    private boolean deleteStation() {
        PrintInfo.inputDeleteStationName();
        String stationName = scanner.nextLine();
        if (!StationManager.containsName(stationName)) {
            return Error.notExist();
        }
        if (!StationManager.deleteStationByName(stationName)) {
            return Error.stationHasLine();
        }
        PrintInfo.deleteStationSuccess();
        return true;
    }
}
