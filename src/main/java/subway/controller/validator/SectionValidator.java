package subway.controller.validator;

import subway.controller.exception.IllegalElementException;
import subway.controller.exception.NotExistedElementException;
import subway.domain.LineRepository;

public class SectionValidator {
    private static final String ORDER_FORMAT_REGEX = "\\d{1,}";
    private static final String ZERO = "0";
    private static final int ONE = 1;
    private static final int MINIMUM_STATIONS_IN_LINE_WHEN_DELETE_SECTION = 3;

    public static void validateSectionDuplication(String lineName, String stationName) {
        if (hasStationInLine(lineName, stationName)) {
            throw new IllegalElementException("[ERROR] 해당 노선에 이미 역이 존재합니다.");
        }
    }

    public static void validateStationIsExistedInTheLine(String lineName, String stationName) {
        if (!hasStationInLine(lineName, stationName)) {
            throw new NotExistedElementException("[ERROR] 존재하지 않는 역 이름입니다.");
        }
    }

    private static boolean hasStationInLine(String lineName, String stationName) {
        return LineRepository.hasSection(lineName, stationName);
    }

    public static void validateLineSizeIsSufficient(String lineName) {
        if (!isBiggerLineSizeThanNumber(lineName, MINIMUM_STATIONS_IN_LINE_WHEN_DELETE_SECTION)) {
            throw new IllegalElementException("[ERROR] 노선에 등록된 역이 2개 이하인 경우 삭제할 수 없습니다.");
        }
    }

    private static boolean isBiggerLineSizeThanNumber(String lineName, int number) {
        return LineRepository.isBiggerLineSizeThan(lineName, number);
    }

    public static void validateOrder(String lineName, String order) {
        validateOrderIsNaturalNumber(order);
        validateOrderIsLowerThanLineSize(lineName, parseInt(order));
    }

    private static int parseInt(String order) {
        return Integer.parseInt(order);
    }

    private static void validateOrderIsNaturalNumber(String order) {
        if (isNotOrderNaturalNumber(order)) {
            throw new IllegalElementException("\n[ERROR] 순서는 1 이상의 자연수여야 합니다.");
        }
    }

    private static boolean isNotOrderNaturalNumber(String order) {
        return (isNotOrderMatchFormat(order) || isOrderZero(order));
    }

    private static boolean isNotOrderMatchFormat(String order) {
        return !order.matches(ORDER_FORMAT_REGEX);
    }

    private static boolean isOrderZero(String order) {
        return order.equals(ZERO);
    }

    private static void validateOrderIsLowerThanLineSize(String lineName, int order) {
        int actualOrderInLine = order - ONE; // List의 index는 실제 순서보다 -1
        if (!isBiggerLineSizeThanNumber(lineName, actualOrderInLine)) {
            throw new IllegalElementException("\n[ERROR] 순서는 노선의 범위를 넘지 않아야 합니다.");
        }
    }
}
