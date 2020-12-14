package subway.domain;

import java.util.Arrays;
import java.util.List;
import subway.exception.DuplicatedStationInOneLineException;
import subway.exception.LineAlreadyExistsException;
import subway.exception.LineNameLengthException;
import subway.exception.StationAlreadyExistsException;

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
        validateExists(name);
        LineRepository.addLine(this);
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return sections;
    }

    private static void validateLength(String name) {
        if (name.length() < 2) {
            throw new LineNameLengthException(name);
        }
    }

    private static void validateDuplicatedStations(Station firstStation, Station lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new DuplicatedStationInOneLineException(firstStation.getName());
        }
    }

    private static void validateExists(String name) {
        if (LineRepository.exists(name)) {
            throw new LineAlreadyExistsException(name);
        }
    }
}
