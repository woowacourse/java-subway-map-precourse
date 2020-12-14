package subway.controller.exception;

import subway.domain.LineRepository;

public class SectionValidator {
    public static void validateSectionDuplication(String lineName, String stationName) {
        if (LineRepository.hasSection(lineName, stationName)) {
            throw new IllegalElementException("\n[ERROR] 해당 노선에 이미 역이 존재합니다.");
        }
    }

    public static void validateOrder(String lineName, String order) {
        validateOrderIsNaturalNumber(order);
        validateOrderIsLowerThanLineSize(lineName, Integer.parseInt(order));
    }

    private static void validateOrderIsNaturalNumber(String order) {
        if (!order.matches("\\d{1,}") || order.equals("0")) {
            throw new IllegalElementException("\n[ERROR] 순서는 1 이상의 자연수여야 합니다.");
        }
    }

    private static void validateOrderIsLowerThanLineSize(String lineName, int order) {
        if (!LineRepository.isBiggerLineSizeThan(lineName, order)) {
            throw new IllegalElementException("\n[ERROR] 순서는 노선의 범위를 넘지 않아야 합니다.");
        }
    }
    
    public static void validateStationIsExistedInTheLine(String lineName, String stationName) {
        if (!LineRepository.hasSection(lineName, stationName)) {
            throw new NotExistedElementException("\n[ERROR] 존재하지 않는 역 이름입니다.");
        }
    }
    
    public static void validateLineSizeIsSufficient(String lineName) {
        if (!LineRepository.isBiggerLineSizeThan(lineName, 3)) {
            throw new IllegalElementException("\n[ERROR] 노선에 등록된 역이 2개 이하인 경우 삭제할 수 없습니다.");
        }
    }
}
