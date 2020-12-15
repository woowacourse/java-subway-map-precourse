package subway.system.helper;

import subway.manager.SubwayManager;

public class StationSystemInputValidator {
    static final String WANT_QUIT_CODE = "B";
    static final int OPTION_MIN = 1;
    static final int OPTION_MAX = 3;
    static final int MIN_NAME_LENGTH = 2;
    static final String ERROR_PREFIX = "[ERROR] ";
    static final String OPTION_ERROR_MESSAGE = "1~3 또는 B 옵션 중 하나를 입력하세요";
    static final String STATION_NAME_ERROR_MESSAGE = "존재하지 않는 2자 이상의 역 이름을 입력하세요";
    static final String STATION_EXIST_ERROR_MESSAGE = "존재하는 2자 이상의 역 이름을 입력하세요";
    static final String STATION_IN_LINE_ERROR_MESSAGE = "노선에 존재하는 역은 삭제할 수 없습니다";

    public static void validateUserOption(String userOption) throws IllegalArgumentException {
        if (userOption.equals(WANT_QUIT_CODE)) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber < OPTION_MIN || optionNumber > OPTION_MAX) {
            throw new IllegalArgumentException(OPTION_ERROR_MESSAGE);
        }
    }

    public static void validateStationNameForEnrollment(String stationName) throws IllegalArgumentException {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
        if (SubwayManager.isDuplicatedStation(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateStationNameForDeletion(String stationName) throws IllegalArgumentException {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
        if (!SubwayManager.isExistStation(stationName)) {
            throw new IllegalArgumentException(STATION_EXIST_ERROR_MESSAGE);
        }
        if (SubwayManager.isStationInLine(stationName)) {
            throw new IllegalArgumentException(STATION_IN_LINE_ERROR_MESSAGE);
        }
    }
}
