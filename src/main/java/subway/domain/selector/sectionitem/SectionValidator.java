package subway.domain.selector.sectionitem;

import java.util.List;
import subway.domain.line.Line;
import subway.domain.station.Station;

public class SectionValidator {

    private static final String SECTION_ORDER_ERROR = "[ERROR] 입력한 구간 순서가 올바르지 않습니다.";
    private static final String SECTION_FORK_LOAD_ERROR = "[ERROR] 노선에 갈래길은 허용되지 않습니다.";
    private static final String SECTION_STATION_COUNT_ERROR = "[ERROR] 노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다.";

    public void validateSectionOrder(int order, int size) {
        if (order <= 0 || order > size + 1) {
            throw new IllegalArgumentException(SECTION_ORDER_ERROR);
        }
    }

    public void validateStationsDuplication(Line line, Station station) {
        if (line.isContainsStation(station)) {
            throw new IllegalArgumentException(SECTION_FORK_LOAD_ERROR);
        }
    }

    public void validateStationCount(Line line) {
        List<Station> stations = line.stations();
        if (stations.size() <= 2) {
            throw new IllegalArgumentException(SECTION_STATION_COUNT_ERROR);
        }
    }

}
