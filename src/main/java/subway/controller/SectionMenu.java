package subway.controller;

import subway.domain.LineManager;
import subway.domain.StationManager;
import subway.view.PrintInfo;
import subway.view.Error;

import java.util.Scanner;

public class SectionMenu extends Menu {
    public SectionMenu(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected void info() {
        PrintInfo.manageSection();
    }

    @Override
    protected boolean functionOne() {
        return addSection();
    }

    private boolean addSection() {
        PrintInfo.inputAddSectionLineName();
        String lineName = scanner.nextLine();
        if (!LineManager.anyMatchLineName(lineName)) {
            return Error.notExist();
        }
        return checkLineHasStation(lineName);
    }

    private boolean checkLineHasStation(String lineName) {
        PrintInfo.inputAddSectionStationName();
        String stationName = scanner.nextLine();
        if (StationManager.getByName(stationName) == null) {
            return Error.notExist();
        }
        if (LineManager.hasStation(lineName, stationName)) {
            return Error.alreadyExist();
        }
        return inputSectionIndex(lineName, stationName);
    }

    private boolean inputSectionIndex(String lineName, String stationName) {
        PrintInfo.inputAddSectionIndex();
        String indexInput = scanner.nextLine();
        if (!indexInput.chars().allMatch(Character::isDigit)) {
            return Error.numberOnly();
        }
        int index = Integer.parseInt(indexInput) - 1;
        if ((index < 0) || (LineManager.getLineByName(lineName).getSubStations().size() < index)) {
            return Error.indexOutOfRange();
        }
        LineManager.addSectionInLine(lineName, stationName, index);
        PrintInfo.addSectionSuccess();
        return true;
    }
}
