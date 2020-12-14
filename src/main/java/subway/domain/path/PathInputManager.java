package subway.domain.path;

import java.util.Scanner;
import subway.domain.SubwayRepository;
import subway.domain.line.LineOutputManager;
import subway.domain.line.LineRepository;
import subway.domain.station.StationRepository;
import subway.common.ErrorMessageException;

public class PathInputManager {
    private static final int MIN_ORDER = 1;
    private static final String NOT_EXIST_LINE = "존재하지 않는 노선입니다.";
    private static final String NOT_ENROLLED_STATION = "등록되지 않은 역입니다.";
    private static final String STATION_ALREADY_ON_PATH = "입력하신 역은 구간에 이미 등록되어 있습니다.";
    private static final String NOT_NUMBER = "정수가 아닙니다. 순서는 1이상의 정수를 입력해 주세요.";
    private static final String NOT_OVER_ONE = "순서는 1이상의 정수로 가능합니다.";
    private static final String OVER_SIZE_PATH = "순서가 가능한 순서의 크기를 넘어갑니다.";
    private static final String NOT_EXIST_STATION_ON_PATH = "노선에 등록되어 있지 않은 역입니다.";
    private static final String NOT_DELETE_ENDS_ONLY_EXIST = "종점만 남은 노선의 구간은 삭제할 수 없습니다.";

    private final Scanner scanner;

    public PathInputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getPathInfoToAdd() {
        String[] pathInfo = new String[3];
        pathInfo[0] = getLineNameToAdd();
        pathInfo[1] = getStationNameToAdd(pathInfo[0]);
        pathInfo[2] = getIndexToAdd(pathInfo[0]);
        return pathInfo;
    }

    private String getLineNameToAdd() {
        PathOutputManager.printLineToAddPathGuide();
        String lineName = scanner.nextLine().trim();
        checkEnrolledLineName(lineName);
        return lineName;
    }

    //등록되어 있는 라인인지
    private void checkEnrolledLineName(String lineName) {
        if (!LineRepository.containsName(lineName)) {
            throw new ErrorMessageException(NOT_EXIST_LINE);
        }
    }

    private String getStationNameToAdd(String lineName) {
        PathOutputManager.printStationToAddPathGuide();
        String stationName = scanner.nextLine().trim();
        checkEnrolledStationNameOnPath(stationName, lineName);
        checkEnrolledStation(stationName);
        return stationName;
    }

    //그 노선에 등록되어 있는 역인지
    private void checkEnrolledStationNameOnPath(String stationName, String lineName) {
        if (SubwayRepository.containsStationOnPathInTheLine(stationName, lineName)) {
            throw new ErrorMessageException(STATION_ALREADY_ON_PATH);
        }
    }

    //역에 등록되어 있는 역인지
    private void checkEnrolledStation(String stationName) {
        if (!StationRepository.containsStationByName(stationName)) {
            throw new ErrorMessageException(NOT_ENROLLED_STATION);
        }
    }

    private String getIndexToAdd(String lineName) {
        PathOutputManager.printIndexToAddGuide();
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
            throw new ErrorMessageException(NOT_NUMBER);
        }
    }

    //순서가 1이상인지
    private void checkOverOne(int indexNumber) {
        if (indexNumber < MIN_ORDER) {
            throw new ErrorMessageException(NOT_OVER_ONE);
        }
    }

    //순서가 가능한 사이즈를 넘지는 않는지
    private void checkNotOverSize(int indexNumber, String lineName) {
        if (SubwayRepository.isUnacceptableIndexSize(lineName, indexNumber)) {
            throw new ErrorMessageException(OVER_SIZE_PATH);
        }
    }

    public String[] getPathInfoToDelete() {
        String[] pathInfo = new String[2];
        pathInfo[0] = getLineNameToDelete();
        pathInfo[1] = getStationNameToDelete(pathInfo[0]);
        return pathInfo;
    }

    private String getLineNameToDelete() {
        PathOutputManager.printLineToDeleteGuide();
        String lineName = scanner.nextLine().trim();
        checkLineSizeOverTwo(lineName);
        checkEnrolledLineName(lineName);
        return lineName;
    }

    //종점만 남은건 아닌지 체크.
    private void checkLineSizeOverTwo(String lineName) {
        if (SubwayRepository.isOnlyEndsRemained(lineName)) {
            throw new ErrorMessageException(NOT_DELETE_ENDS_ONLY_EXIST);
        }
    }

    private String getStationNameToDelete(String lineName) {
        PathOutputManager.printStationToDeleteGuide();
        String stationName = scanner.nextLine().trim();
        checkEnrolledStationOnPathToDelete(stationName, lineName);
        return stationName;
    }


    //노선에 등록되어 있는 역인지 확인
    private void checkEnrolledStationOnPathToDelete(String stationName, String lineName) {
        if (!SubwayRepository.containsStationOnPathInTheLine(stationName, lineName)) {
            throw new ErrorMessageException(NOT_EXIST_STATION_ON_PATH);
        }
    }
}
