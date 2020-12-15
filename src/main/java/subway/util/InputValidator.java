package subway.util;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.StationRepository;
import java.util.regex.Pattern;

public class InputValidator {
    final static String MAIN_MENU_INPUT_REGULAR_EXPRESS = "^[1-4Q]{1}$";
    final static String SUB_MENU_INPUT_REGULAR_EXPRESS = "^[1-3B]{1}$";
    final static String POSITIVE_INT_REGULAR_EXPRESS = "^[0-9]+$";
    final static String MENU_INPUT_ERROR = "\n[ERROR] 선택할 수 없는 기능 입니다.";
    final static String STATION_TOO_SHORT = "\n[ERROR] 이름은 2글자 이상 입니다.";
    final static String DUPLICATED_STATION_NAME = "\n[ERROR] 이미 등록된 역 입니다.";
    final static String INVALID_STATION_NAME = "\n[ERROR] 존재하지 않는 역 입니다.";
    final static String DUPLICATED_LINE_NAME = "\n[ERROR] 이미 등록된 노선 입니다.";
    final static String INVALID_LINE_NAME = "\n[ERROR] 존재하지 않는 노선 입니다.";
    final static String INVALID_INTERVAL_POS = "\n[ERROR] 올바르지 않은 구간 순서입니다.";
    final static int STATION_MIN_LENGTH = 2;

    public static void validateMainMenuInput(String input) throws
            IllegalArgumentException {
        if (!Pattern.matches(MAIN_MENU_INPUT_REGULAR_EXPRESS, input)) {
            throw new IllegalArgumentException(MENU_INPUT_ERROR);
        }
    }

    public static void validateSubMenuInput(String input) throws
            IllegalArgumentException {
        if (!Pattern.matches(SUB_MENU_INPUT_REGULAR_EXPRESS, input)) {
            throw new IllegalArgumentException(MENU_INPUT_ERROR);
        }
    }

    public static void validateInputLength(String input) throws
            IllegalArgumentException {
        if (input.length() < STATION_MIN_LENGTH) {
            throw new IllegalArgumentException(STATION_TOO_SHORT);
        }
    }

    public static void validateStationDuplication(String target) throws
            IllegalArgumentException {
        if (StationRepository.findByName(target)) {
            throw new IllegalArgumentException(DUPLICATED_STATION_NAME);
        }
    }

    public static void validateStationExistence(String target) throws
            IllegalArgumentException {
        if (!StationRepository.findByName(target)) {
            throw new IllegalArgumentException(INVALID_STATION_NAME);
        }
    }

    public static void validateLineDuplication(String target) throws
            IllegalArgumentException {
        if (LineRepository.findByName(target)) {
            throw new IllegalArgumentException(DUPLICATED_LINE_NAME);
        }
    }

    public static void validateLineExistence(String target) throws
            IllegalArgumentException {
        if (!LineRepository.findByName(target)) {
            throw new IllegalArgumentException(INVALID_LINE_NAME);
        }
    }

    public static void validateIntervalPosition(String target, Line currentLine) throws
            IllegalArgumentException {
        if (!Pattern.matches(POSITIVE_INT_REGULAR_EXPRESS, target)) {
            throw new IllegalArgumentException(INVALID_INTERVAL_POS);
        }
        if (Integer.parseInt(target) > currentLine.intervals().size() + 1) {
            throw new IllegalArgumentException(INVALID_INTERVAL_POS);
        }
    }
}
