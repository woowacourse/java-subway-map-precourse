package subway.domain.validator;

import subway.domain.Line;
import subway.domain.Order;
import subway.domain.Station;
import subway.view.SectionView;

public class SectionValidator {

    private SectionValidator() {
    }

    public static void checkValidOrderInLine(Order order, Line line) {
        if (order.isBiggerThan(line.getStationCount())) {
            throw new IllegalArgumentException("순서는 현재 포함된 역 개수보다 클 수 없습니다.");
        }
    }

    public static void checkStationNotOnLine(Station station, Line line) {
        if (line.isContains(station)) {
            throw new IllegalArgumentException("이미 노선에 포함된 역입니다.");
        }
    }
}
