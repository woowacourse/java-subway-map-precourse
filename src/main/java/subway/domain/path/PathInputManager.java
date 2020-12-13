package subway.domain.path;

import java.util.Scanner;
import subway.domain.SubwayRepository;
import subway.domain.line.LineOutputManager;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.common.ErrorMessage;
import subway.common.Guide;

public class PathInputManager {
    private Scanner scanner;

    private static final String NOT_EXIST_LINE = "존재하지 않는 노선입니다.";
    private static final String NOT_ENROLLED_STATION = "등록되지 않은 역입니다.";
    private static final String STATION_ALREADY_ON_PATH = "입력하신 역은 구간에 이미 등록되어 있습니다.";
    private static final String NOT_NUMBER = "정수가 아닙니다. 순서는 1이상의 정수를 입력해 주세요.";
    private static final String NOT_OVER_ONE = "순서는 1이상의 정수로 가능합니다.";
    private static final String OVER_SIZE_PATH = "구간의 크기가 기존 사이즈를 넘어갑니다.";
    private static final String NOT_EXIST_STATION_ON_PATH = "노선에 등록되어 있지 않은 역입니다.";


    public PathInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getPathInfoToAdd() {
        String[] pathInfo = new String[3];
        try {
            pathInfo[0] = getLineName();
            pathInfo[1] = getStationNameToAdd(pathInfo[0]);
            pathInfo[2] = getIndexToAdd(pathInfo[0]);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            pathInfo[0] = ErrorMessage.OUT;
        }
        return pathInfo;
    }

    private String getLineName() {
        Guide.print(LineOutputManager.LINE_TO_ADD_PATH_GUIDE);
        String lineName = scanner.nextLine().trim();
        checkEnrolledLineName(lineName);
        return lineName;
    }

    private void checkEnrolledLineName(String lineName) {
        if (!LineRepository.containsName(lineName)) {
            throw new ErrorMessage(NOT_EXIST_LINE);
        }
    }

    private String getStationNameToAdd(String lineName) {
        Guide.print(PathOutputManager.STATION_TO_ADD_PATH_GUIDE);
        String stationName = scanner.nextLine().trim();
        checkEnrolledStationNameOnPath(stationName, lineName);
        checkEnrolledStation(stationName);
        return stationName;
    }

    private void checkEnrolledStationNameOnPath(String stationName, String lineName) {
        if (SubwayRepository.containsStationOnLine(stationName, lineName)) {
            throw new ErrorMessage(STATION_ALREADY_ON_PATH);
        }
    }

    private void checkEnrolledStation(String stationName) {
        if (!StationRepository.containsName(stationName)) {
            throw new ErrorMessage(NOT_ENROLLED_STATION);
        }
    }

    private String getIndexToAdd(String lineName) {
        Guide.print(PathOutputManager.INDEX_TO_ADD_PATH_GUIDE);
        String index = scanner.nextLine().trim();
        checkValidIndex(index, lineName);
        return index;
    }

    private void checkValidIndex(String index, String lineName) {
        try {
            int indexNumber = Integer.parseInt(index);
            checkOverOne(indexNumber);
            checkNotOverSize(indexNumber, lineName);
        } catch (NumberFormatException n) {
            throw new ErrorMessage(NOT_NUMBER);
        }
    }

    private void checkOverOne(int indexNumber) {
        if (indexNumber < 1) {
            throw new ErrorMessage(NOT_OVER_ONE);
        }
    }

    private void checkNotOverSize(int indexNumber, String lineName) {
        if (indexNumber > SubwayRepository.getSizeOfPathByLineName(lineName) - 1) {
            throw new ErrorMessage(OVER_SIZE_PATH);
        }
    }

    public String[] getPathInfoToDelete() {
        String[] pathInfo = new String[2];
        try {
            pathInfo[0] = getLineName(); //삭제할으로 문구 변경
            pathInfo[1] = getStationNameToDelete(pathInfo[0]);
        } catch (ErrorMessage error) {
            System.out.println(error.getMessage());
            pathInfo[0] = ErrorMessage.OUT;
        }
        return pathInfo;
    }

    private String getStationNameToDelete(String lineName) {
        Guide.print(PathOutputManager.STATION_TO_DELETE_PATH_GUIDE);
        String stationName = scanner.nextLine().trim();
        checkEnrolledStationOnPathToDelete(stationName, lineName);
        return stationName;
    }

    private void checkEnrolledStationOnPathToDelete(String stationName, String lineName) {
        if (!SubwayRepository.containsStationOnLine(stationName, lineName)) {
            throw new ErrorMessage(NOT_EXIST_STATION_ON_PATH);
        }
    }
}
