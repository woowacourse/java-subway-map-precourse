package subway.controller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.PathRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.SubwayRepository;
import subway.view.ErrorMessage;
import subway.view.Menu;

public class PathInputManager {
    private Scanner scanner;

    public PathInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getPathToAdd() {
        String[] lineInfo = new String[3];
        lineInfo[0] = getLineNameToAdd();
        if (lineInfo[0].equals(ErrorMessage.OUT)) {
            return lineInfo;
        }
        lineInfo[1] = getStationNameToAdd(lineInfo[0]);
        if (lineInfo[1].equals(ErrorMessage.OUT)) {
            return lineInfo;
        }
        lineInfo[2] = getIndexToAdd(lineInfo[0]);
        return lineInfo;
    }

    private String getIndexToAdd(String lineName) {
        Menu.printIndexToAddPath();
        String index = scanner.nextLine().trim();
        if (!checkValidIndex(index, lineName)) {
            return ErrorMessage.OUT;
        }
        return index;
    }

    private boolean checkValidIndex(String index, String lineName) {
        try {
            int indexNumber = Integer.parseInt(index);
            return checkOverOne(indexNumber) && checkNotOverSize(indexNumber, lineName);
        } catch (NumberFormatException n) {
            ErrorMessage.printNotNumber();
            return false;
        }
    }

    private boolean checkNotOverSize(int indexNumber, String lineName) {
        if (indexNumber > SubwayRepository.getSizeOfPathByLineName(lineName) - 1) {
            ErrorMessage.printOverSizePath();
            return false;
        }
        return true;
    }

    private boolean checkOverOne(int indexNumber) {
        if (indexNumber < 1) {
            ErrorMessage.printNotOverOne();
            return false;
        }
        return true;
    }

    private String getStationNameToAdd(String line) {
        Menu.printStationToAddPath();
        String stationName = scanner.nextLine().trim();
        if (checkEnrolledStationNameOnPath(stationName, line) || !checkEnrolledStation(stationName)) {
            return ErrorMessage.OUT;
        }
        return stationName;

    }

    private boolean checkEnrolledStation(String stationName) {
        if(!StationRepository.containsName(stationName)){
            ErrorMessage.printNotExistStation();
            return false;
        }
        return true;
    }

    private boolean checkEnrolledStationNameOnPath(String stationName, String lineName) {
        if (SubwayRepository.containsStationOnLine(stationName, lineName)) {
            ErrorMessage.printStationAlreadyOnPath();
            return true;
        }
        return false;
    }


    private String getLineNameToAdd() {
        Menu.printLineToAddPath();
        String lineName = scanner.nextLine().trim();
        if (!checkLineNameExist(lineName)) {
            return ErrorMessage.OUT;
        }
        return lineName;
    }

    private boolean checkLineNameExist(String lineName) {
        if (!LineRepository.containsName(lineName)) {
            ErrorMessage.printNotExistLine();
            return false;
        }
        return true;
    }
}
