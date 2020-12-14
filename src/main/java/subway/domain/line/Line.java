package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.line.SectionSizeLowException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private static final int MINIMUM_SECTIONS_LENGTH = 2;
    private static final int MINIMUM_POSITION_RANGE = 1;

    private LineName name;
    private List<Station> sections;

    private Line(LineName name, Station upLine, Station downLine) {
        List<Station> sections = createSectionsWithUpLineAndDownLine(upLine, downLine);
        this.name = name;
        this.sections = sections;
    }

    public static Line fromNameAndUpLineAndDownLine(LineName name, Station upLine, Station downLine) {
        return new Line(name, upLine, downLine);
    }

    private static List<Station> createSectionsWithUpLineAndDownLine(Station upLine, Station downLine) {
        List<Station> sections = new LinkedList<>();
        sections.add(upLine);
        sections.add(downLine);

        return sections;
    }

    public List<Station> sections() {
        return Collections.unmodifiableList(sections);
    }

    public boolean isRightPosition(int position) {
        return MINIMUM_POSITION_RANGE <= position && position < sections.size();
    }

    public void add(int position, Station station) {
        sections.add(position, station);
    }

    public boolean deleteStationByName(StationName stationName) {
        if (sections.size() == MINIMUM_SECTIONS_LENGTH) {
            throw new SectionSizeLowException();
        }

        return sections.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public LineName getName() {
        return name;
    }

    public boolean contains(StationName name) {
        return sections.stream()
                .anyMatch(station -> Objects.equals(name, station.getName()));
    }
}
