package subway.exception;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.screen.ActionType;
import subway.screen.EntityType;
import subway.screen.Screen;

public class Validator {
    private static String INVALID_USER_COMMAND_MESSAGE = "선택할 수 없는 기능입니다.";
    private static String INVALID_STATION_NAME_LENGTH_MESSAGE = Station.NAME_LENGTH_MIN + "글자 이상 입력해 주십시오.";
    private static String STATION_NAME_DUPLICATED_MESSAGE = "이미 등록된 역 이름입니다.";
    private static String STATION_NAME_NOT_REGISTERED_MESSAGE = "등록되지 않은 역 이름입니다.";

    public static void checkValidUserCommand(String userCommand, Screen screen) {
        if (!screen.containsCommand(userCommand)) {
            throw new IllegalArgumentException(INVALID_USER_COMMAND_MESSAGE);
        }
    }
    
    public static void checkValidName(String name, EntityType entityType, ActionType actionType) throws IllegalArgumentException {
        if (entityType == EntityType.STATION) {
            checkValidStationName(name, actionType);
        }
        if (entityType == EntityType.LINE) {
            // TODO 구현 예정
        }
    }
    
    private static void checkValidStationName(String stationName, ActionType actionType) throws IllegalArgumentException {
        if (actionType == ActionType.REGISTER) {
            checkValidStationNameToRegister(stationName);
        }
        if (actionType == ActionType.DELETE) {
            checkValidStationNameToDelete(stationName);
        }
    }
    
    private static void checkValidStationNameToRegister(String stationName) throws IllegalArgumentException {
        checkValidStationNameLength(stationName);
        checkStationNameNotDuplicated(stationName);
    }
    
    private static void checkValidStationNameToDelete(String stationName) throws IllegalArgumentException {
        checkStationNameNotRegistered(stationName);
        checkStationNameNotRegisteredInRoute(stationName);
    }
    
    private static void checkValidStationNameLength(String stationName) {
        if (stationName.length() < Station.NAME_LENGTH_MIN) {
            throw new IllegalArgumentException(INVALID_STATION_NAME_LENGTH_MESSAGE);
        }
    }
    
    private static void checkStationNameNotDuplicated(String stationName) {
        if (StationRepository.containsName(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_DUPLICATED_MESSAGE);
        }
    }
    
    private static void checkStationNameNotRegistered(String stationName) {
        if (!StationRepository.containsName(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_NOT_REGISTERED_MESSAGE);
        }
    }
    
    private static void checkStationNameNotRegisteredInRoute(String stationName) {
        // TODO 구간 관리 기능 구현 이후에 구현 예정
    }
}
