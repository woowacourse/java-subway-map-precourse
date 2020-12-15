package subway.section;

import subway.line.Line;
import subway.station.Station;

public class SectionService {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String STATION_NUMBER_LACK = ERROR_PREFIX + "등록된 역이 2개 이하이므로 삭제할 수 없습니다.";

    public static boolean addSection(Line line, Station station, int order) {
        line.addSection(station, order);
        return true;
    }

    public static boolean deleteSection(Line line, Station station) {
        if (!line.deleteSection(station)) {
            throw new IllegalArgumentException(STATION_NUMBER_LACK);
        }
        return true;
    }
}
