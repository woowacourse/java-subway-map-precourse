package subway.section;

import subway.line.Line;
import subway.line.validation.SatisfyLineMinimumStation;
import subway.station.Station;

public class SectionService {
    public static boolean addSection(Line line, Station station, int order) {
        line.addSection(station, order);
        return true;
    }

    public static boolean deleteSection(Line line, Station station) {
        return SatisfyLineMinimumStation.validation(line, station);
    }
}
