package subway.controller;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.PathRepository;
import subway.domain.Station;
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
            if (indexNumber < 1) {
                ErrorMessage.printNotOverOne();
                return false;
            }
            System.out.println(SubwayRepository.getSizeOfPathByLineName(lineName));
            if (indexNumber - 1 > SubwayRepository.getSizeOfPathByLineName(lineName)) {
                ErrorMessage.printOverSizePath();
                return false;
            }
        } catch (NumberFormatException n) {
            ErrorMessage.printNotNumber();
        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());
        }
        return true;

    }

    private String getStationNameToAdd(String line) {
        Menu.printStationToAddPath();
        String stationName = scanner.nextLine().trim();
        if (checkStationNameExist(stationName, line)) {
            return ErrorMessage.OUT;
        }
        return stationName;

    }

    private boolean checkStationNameExist(String stationName, String lineName) {
        if (SubwayRepository.containsStationOnPathByLineName(stationName, lineName)) {
            ErrorMessage.printStationAlreadyOnPath();
            return true;
        }
        return false;
    }

    private String getLineNameToAdd() {
        Menu.printLineToAddPath();
        for(Line line:SubwayRepository.getSubwayRealLines().keySet()) {
            System.out.println(line.getName());
        }
        String lineName = scanner.nextLine().trim();
        //확인용
        PathRepository path = SubwayRepository.getPathByLineName(lineName);
        for(Station station : path.getPath() ){
            System.out.println(station.getName());
        }
        //
        if (!checkLineNameExist(lineName)) {
            return ErrorMessage.OUT;
        }
        return lineName;
    }
    /*
    subwayRepository에 있는지 확인?
     */
    private boolean checkLineNameExist(String lineName) {
        if (!LineRepository.lineNames().contains(lineName)) {
            ErrorMessage.printNotExistLine();
            return false;
        }
        return true;
    }
}
