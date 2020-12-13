package subway.domain.path;

import java.util.Scanner;
import subway.domain.SubwayRepository;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.common.ErrorMessage;
import subway.common.Guide;

public class PathInputManager {
    private Scanner scanner;

    public PathInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getPathInfoToAdd() {
        String[] pathInfo = new String[3];
        pathInfo[0] = getLineName();
        if (pathInfo[0].equals(ErrorMessage.OUT)) {
            return pathInfo;
        }
        pathInfo[1] = getStationNameToAdd(pathInfo[0]);
        if (pathInfo[1].equals(ErrorMessage.OUT)) {
            return pathInfo;
        }
        pathInfo[2] = getIndexToAdd(pathInfo[0]);
        return pathInfo;
    }

    private String getIndexToAdd(String lineName) {
        Guide.printIndexToAddPath();
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

    //todo: refactor 검사할 조건을 넣어주는 것으로 가능할까?
    private String getStationNameToAdd(String lineName) {
        Guide.printStationToAddPath();
        String stationName = scanner.nextLine().trim();
        if (checkEnrolledStationNameOnPath(stationName, lineName) || !checkEnrolledStation(stationName)) {
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


    private String getLineName() {
        Guide.printLineToAddPath();
        String lineName = scanner.nextLine().trim();
        if (!checkEnrolledLineName(lineName)) {
            return ErrorMessage.OUT;
        }
        return lineName;
    }

    private boolean checkEnrolledLineName(String lineName) {
        if (LineRepository.containsName(lineName)) {
            return true;
        }
        ErrorMessage.printNotExistLine();
        return false;
    }

    public String[] getPathInfoToDelete() {
        String[] pathInfo = new String[2];
        pathInfo[0] = getLineName(); // print 삭제할 으로 변경해야함
        if (pathInfo[0].equals(ErrorMessage.OUT)) {
            return pathInfo;
        }
        pathInfo[1] = getStationNameToDelete(pathInfo[0]);
        return pathInfo;
    }

    private String getStationNameToDelete(String lineName) {
        Guide.printStationToAddPath(); // print 변경
        String stationName = scanner.nextLine().trim();
        if (!checkEnrolledStationNameOnPathToDelete(stationName, lineName)) {
            return ErrorMessage.OUT;
        }
        return stationName;
    }
    private boolean checkEnrolledStationNameOnPathToDelete(String stationName, String lineName) {
        if (SubwayRepository.containsStationOnLine(stationName, lineName)) {
            return true;
        }
        ErrorMessage.printNotEnrolledStationOnPath();
        return false;
    }
}
