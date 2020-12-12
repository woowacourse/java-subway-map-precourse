package subway.domain;

import java.util.Arrays;
import java.util.List;
import subway.exception.DuplicatedStationInOneLineException;
import subway.exception.LineNameLengthException;

public class Line {

    private final String name;
    private final List<Station> sections;

    private Line(String name, List<Station> sections) {
        this.name = name;
        this.sections = sections;
    }

    public static Line of(String name, Station firstStation, Station lastStation) {
        validateLength(name);
        validateDuplicatedStations(firstStation, lastStation);
        return new Line(name, Arrays.asList(firstStation, lastStation));
    }

    public void save() {
        LineRepository.addLine(this);
    }

    public String getName() {
        return name;
    }

    private static void validateLength(String name) {
        if (name.length() < 2) {
            throw new LineNameLengthException(name);
        }
        if (5 < name.length()) {
            throw new LineNameLengthException(name);
        }
    }

    private static void validateDuplicatedStations(Station firstStation, Station lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new DuplicatedStationInOneLineException(firstStation.getName());
        }
    }
}
