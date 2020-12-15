package subway.controller;

import subway.domain.StationManager;
import subway.view.PrintInfo;
import subway.view.Error;

import java.util.Scanner;

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
}
