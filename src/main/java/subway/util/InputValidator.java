package subway.util;

import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.regex.Pattern;

public class InputValidator {

    final static String MAIN_MENU_INPUT_REGULAR_EXPRESS = "^[1-4Q]{1}$";
    final static String SUB_MENU_INPUT_REGULAR_EXPRESS = "^[1-3B]{1}$";
    final static int STATION_MIN_LENGTH = 2;
    final static String MENU_INPUT_ERROR = "\n[ERROR] 선택할 수 없는 기능 입니다.";
    final static String STATION_TOO_SHORT = "\n[ERROR] 역 이름은 2글자 이상 입니다.";
    final static String DUPLICATED_STATION_NAME = "\n[ERROR] 이미 등록된 역 입니다.";
    final static String INVALID_STATION_NAME = "\n[ERROR] 존재하지 않는 역 입니다.";


    public static void validateMainMenuInput(String input) throws IllegalArgumentException {
        if (!Pattern.matches(MAIN_MENU_INPUT_REGULAR_EXPRESS, input)) {
            throw new IllegalArgumentException(MENU_INPUT_ERROR);
        }
    }

    public static void validateSubMenuInput(String input) throws IllegalArgumentException {
        if (!Pattern.matches(SUB_MENU_INPUT_REGULAR_EXPRESS, input)) {
            throw new IllegalArgumentException(MENU_INPUT_ERROR);
        }
    }

    public static void validateInputLength(String input) throws IllegalArgumentException {
        if (input.length() < STATION_MIN_LENGTH) {
            throw new IllegalArgumentException(STATION_TOO_SHORT);
        }
    }

    public static void validateInputDuplication(String target) throws IllegalArgumentException {
        if (StationRepository.findByName(target)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_NAME);
        }
    }

    public static void validateExistence(String target) throws IllegalArgumentException {
        if (!StationRepository.findByName(target)) {
            throw new IllegalArgumentException(INVALID_STATION_NAME);
        }
    }
}
