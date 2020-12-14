package subway.domain.validator;

import subway.domain.Line;
import subway.domain.Order;
import subway.domain.Station;

public class LineValidator {
    private LineValidator() {
    }

    public static void checkNotExistingLine(boolean isContain) {
        if (isContain) {
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
    }

    public static void checkEndStationsAreDifferent(Station start, Station end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException("상행 종점과 하행 종점이 같을 수 없습니다.");
        }
    }

    public static void checkIsNotOnLine(boolean isContain) {
        if (isContain) {
            throw new IllegalArgumentException("이미 노선에 포함된 역입니다.");
        }
    }

    public static void checkIsOnLine(boolean isContain) {
        if (!isContain) {
            throw new IllegalArgumentException("해당 노선에 존재하지 않는 역입니다.");
        }
    }

    public static void checkIsValidOrder(Order order, int maximum) {
        if (order.getIndex() > maximum) {
            throw new IllegalArgumentException("유효하지 않은 순서 입력입니다.");
        }
    }
}
