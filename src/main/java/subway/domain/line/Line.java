package subway.domain.line;

import subway.domain.station.Station;
import subway.domain.station.StationName;
import subway.exception.SameUpLineAndDownLineException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> sections;

    private Line(String name, Station upLine, Station downLine) {
        List<Station> sections = createSectionsWithUpLineAndDownLine(upLine, downLine);
        this.name = name;
        this.sections = sections;
    }

    public static Line fromNameAndUpLineAndDownLine(String name, Station upLine, Station downLine) {
        return new Line(name, upLine, downLine);
    }

    private static List<Station> createSectionsWithUpLineAndDownLine(Station upLine, Station downLine) {
        List<Station> sections = new LinkedList<>();
        sections.add(upLine);
        sections.add(downLine);

        return sections;
    }

    public String getName() {
        return name;
    }

    public boolean contains(StationName name) {
        return sections.stream()
                .anyMatch(station -> Objects.equals(name, station.getName()));
    }
}
