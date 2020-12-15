package subway.system.validator;

import subway.system.manager.SubwayManager;

public class SectionSystemInputValidator {

    static final int OPTION_MIN = 1;
    static final int OPTION_MAX = 2;
    static final String OPTION_ERROR_MESSAGE = "1~2 또는 B 옵션 중 하나를 입력하세요";
    static final String WANT_QUIT_CODE = "B";
    static final String ERROR_PREFIX = "[ERROR] ";
    static final String LINE_NAME_DELETION_ERROR_MESSAGE = "존재하는 2자 이상의 노선 이름을 입력하세요";
    static final String STATION_NAME_ERROR_MESSAGE = "존재하는 2자 이상의 역 이름을 입력하세요";
    static final String ORDER_ERROR_MESSAGE = "숫자로 순서를 입력하세요";
    static final int MIN_NAME_LENGTH = 2;


    public static void validateUserOption(String userOption) throws IllegalArgumentException {
        if (userOption.equals(WANT_QUIT_CODE)) {
            return;
        }
        int optionNumber = Integer.parseInt(userOption);
        if (optionNumber < OPTION_MIN || optionNumber > OPTION_MAX) {
            throw new IllegalArgumentException(OPTION_ERROR_MESSAGE);
        }
    }

    public static void validateLineNameForEnrollment(String lineName)
        throws IllegalArgumentException {
        if (lineName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_NAME_DELETION_ERROR_MESSAGE);
        }
        if (!SubwayManager.isExistLine(lineName)) {
            throw new IllegalArgumentException(LINE_NAME_DELETION_ERROR_MESSAGE);
        }
    }

    public static void validateStationNameForEnrollment(String stationName)
        throws IllegalArgumentException {
        if (stationName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
        if (!SubwayManager.isDuplicatedStation(stationName)) {
            throw new IllegalArgumentException(STATION_NAME_ERROR_MESSAGE);
        }
    }

    public static void validateOrderForEnrollment(String order) throws IllegalArgumentException {
        try {
            Integer.parseInt(order);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + ORDER_ERROR_MESSAGE);
        }
    }

}
