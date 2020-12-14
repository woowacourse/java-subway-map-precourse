package subway.exception;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.screen.ActionType;
import subway.screen.EntityType;
import subway.screen.Screen;

public class Validator {
    private static String INVALID_USER_COMMAND_MESSAGE = "선택할 수 없는 기능입니다.";
    private static String INVALID_STATION_NAME_LENGTH_MESSAGE_SUFFIX = "글자 이상 입력해 주십시오.";
    private static String STATION_NAME_DUPLICATED_MESSAGE = "이미 등록된 역 이름입니다.";
    private static String STATION_NAME_NOT_REGISTERED_MESSAGE = "등록되지 않은 역 이름입니다.";
    private static String LINE_NAME_DUPLICATED_MESSAGE = "이미 등록된 노선 이름입니다.";
    private static String END_STATION_NAMES_DUPLICATED_MESSAGE = "서로 다른 상·하행 종점역 이름을 입력해 주십시오.";
    private static String LINE_NAME_NOT_REGISTERED_MESSAGE = "등록되지 않은 노선 이름입니다.";
    private static String STATION_NAME_REGISTERED_IN_ROUTE_MESSAGE = "이미 구간에 등록된 역 이름입니다.";
    private static String STATION_NAME_NOT_REGISTERED_IN_ROUTE_MESSAGE = "구간에 등록되지 않은 역 이름입니다.";
    private static String UNDER_MINIMUN_ROUTE_LENGTH_MESSAGE = "하나의 노선은 최소 "
            + LineRepository.ROUTE_LENGTH_MIN + "개 이상의 역을 포함해야 합니다.";
    private static String NOT_DIGIT_MESSAGE = "숫자만 입력해 주십시오.";
    private static String INTEGER_OVERFLOW_MESSAGE = Integer.MAX_VALUE + " 이하의 수를 입력해 주십시오.";
    private static String OUT_OF_BOUND_MESSAGE = "%d 이상 %d 이하의 수를 입력해 주십시오.";

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
            checkValidLineName(name, actionType);
        }
        if (entityType == EntityType.ROUTE) {
            checkLineNameRegistered(name);
        }
    }
    
    public static void checkValidEndStationName(String endStationName, List<String> endStationNames) throws IllegalArgumentException {
        checkStationNameRegistered(endStationName);
        
        if (endStationNames.contains(endStationName)) {
            throw new IllegalArgumentException(END_STATION_NAMES_DUPLICATED_MESSAGE);
        }
    }
    
    public static void checkValidStationNameToRegisterToRoute(String stationNameToRegisterToRoute, String lineName) throws IllegalArgumentException {
        checkStationNameRegistered(stationNameToRegisterToRoute);
        checkStationNameNotRegisteredInRoute(stationNameToRegisterToRoute, lineName);
    }

    public static void checkStationOrderInRoute(String stationOrderInRoute, String lineName) throws IllegalArgumentException {
        checkAllDigits(stationOrderInRoute);
        checkIntegerNotOverflow(stationOrderInRoute);
        checkInValidRange(Integer.parseInt(stationOrderInRoute),
                LineRepository.ROUTE_START, LineRepository.getRouteLengthByName(lineName) + LineRepository.ROUTE_START);
    }

    public static void checkValidStationNameToDeleteFromRoute(String stationNameToDeleteFromRoute, String lineName)
            throws IllegalArgumentException {
        checkStationNameRegistered(stationNameToDeleteFromRoute);
        checkStationNameRegisteredInRoute(stationNameToDeleteFromRoute, lineName);
        checkMinimumRouteLength(lineName);
    }

    private static void checkValidStationName(String stationName, ActionType actionType) throws IllegalArgumentException {
        if (actionType == ActionType.REGISTER) {
            checkValidStationNameToRegister(stationName);
        }
        if (actionType == ActionType.DELETE) {
            checkValidStationNameToDelete(stationName);
        }
    }
    
    private static void checkValidLineName(String lineName, ActionType actionType) throws IllegalArgumentException {
        if (actionType == ActionType.REGISTER) {
            checkValidLineNameToRegister(lineName);
        }
        if (actionType == ActionType.DELETE) {
            checkValidLineNameToDelete(lineName);
        }
    }
    
    private static void checkValidStationNameToRegister(String stationName) throws IllegalArgumentException {
        checkValidNameLength(stationName, Station.NAME_LENGTH_MIN);
        checkStationNameNotDuplicated(stationName);
    }
    
    private static void checkValidStationNameToDelete(String stationName) throws IllegalArgumentException {
        checkStationNameRegistered(stationName);
        checkStationNameNotRegisteredInRoute(stationName);
    }
    
    private static void checkValidLineNameToRegister(String lineName) throws IllegalArgumentException {
        checkValidNameLength(lineName, Line.NAME_LENGTH_MIN);
        checkLineNameNotDuplicated(lineName);
    }
    
    private static void checkValidLineNameToDelete(String lineName) throws IllegalArgumentException {
        checkLineNameRegistered(lineName);
    }
    
    private static void checkValidNameLength(String name, int nameLengthMin) {
        if (name.length() < nameLengthMin) {
            throw new IllegalArgumentException(nameLengthMin + INVALID_STATION_NAME_LENGTH_MESSAGE_SUFFIX);
        }
    }
    
    private static void checkStationNameNotDuplicated(String stationName) {
        if (StationRepository.containsName(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_DUPLICATED_MESSAGE);
        }
    }
    
    private static void checkStationNameRegistered(String stationName) {
        if (!StationRepository.containsName(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_NOT_REGISTERED_MESSAGE);
        }
    }
    
    private static void checkStationNameNotRegisteredInRoute(String stationName) {
        // TODO 구간 관리 기능 구현 이후에 구현 예정
    }
    
    private static void checkLineNameNotDuplicated(String lineName) {
        if (LineRepository.containsName(lineName)) {
            throw new IllegalArgumentException(LINE_NAME_DUPLICATED_MESSAGE);
        }
    }
    
    private static void checkLineNameRegistered(String lineName) {
        if (!LineRepository.containsName(lineName)) {
            throw new IllegalArgumentException(LINE_NAME_NOT_REGISTERED_MESSAGE);
        }
    }
    
    private static void checkStationNameNotRegisteredInRoute(String stationName, String lineName) {
        if (LineRepository.routeContainsByName(lineName, stationName)) {
            throw new IllegalArgumentException(STATION_NAME_REGISTERED_IN_ROUTE_MESSAGE);
        }
    }
    
    private static void checkStationNameRegisteredInRoute(String stationName, String lineName) {
        if (!LineRepository.routeContainsByName(lineName, stationName)) {
            throw new IllegalArgumentException(STATION_NAME_NOT_REGISTERED_IN_ROUTE_MESSAGE);
        }
    }
    
    private static void checkMinimumRouteLength(String lineName) {
        if (LineRepository.getRouteLengthByName(lineName) <= LineRepository.ROUTE_LENGTH_MIN) {
            throw new IllegalArgumentException(UNDER_MINIMUN_ROUTE_LENGTH_MESSAGE);
        }
    }
    
    private static void checkAllDigits(String digits) {
        for (char digit : digits.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException(NOT_DIGIT_MESSAGE);
            }
        }
    }
    
    private static void checkIntegerNotOverflow(String integer) {
        try {
            Integer.parseInt(integer);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(INTEGER_OVERFLOW_MESSAGE);
        }
    }
    
    private static void checkInValidRange(int number, int lowerBound, int upperBound) {
        if (number < lowerBound || upperBound < number) {
            throw new IllegalArgumentException(String.format(OUT_OF_BOUND_MESSAGE, lowerBound, upperBound));
        }
    }
}
