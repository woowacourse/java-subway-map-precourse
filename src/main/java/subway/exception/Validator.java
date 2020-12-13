package subway.exception;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.screen.Screen;

public class Validator {
    private static String INVALID_USER_COMMAND_MESSAGE = "선택할 수 없는 기능입니다.";
    private static String INVALID_STATION_NAME_LENGTH_MESSAGE = Station.NAME_LENGTH_MIN + "글자 이상 입력해 주십시오.";
    private static String STATION_NAME_DUPLICATED_MESSAGE = "이미 등록된 역 이름입니다.";

    public static void checkValidUserCommand(String userCommand, Screen screen) {
        if (!screen.containsCommand(userCommand)) {
            throw new IllegalArgumentException(INVALID_USER_COMMAND_MESSAGE);
        }
    }
    
    public static void checkValidStationName(String stationName) throws IllegalArgumentException {
        checkValidStationNameLength(stationName);
        checkStationNameNotDuplicated(stationName);
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
}
