package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.exception.AlreadyRegisteredLineNameException;
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

        List<Station> list = new ArrayList<>();
        list.add(firstStation);
        list.add(lastStation);

        return new Line(name, list);
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
            throw new AlreadyRegisteredLineNameException(name);
        }
    }
}
