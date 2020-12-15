package subway.section;

import subway.line.Line;
import subway.station.Station;

public class SectionService {
    public static void addSection(Line line, Station station, int order) {
        line.addSection(station, order);
    }

    public static void deleteSection(Line line, Station station) {
        line.deleteSection(station);
    }
}
