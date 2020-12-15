package subway.domain;

import subway.exception.SubwayException;

import static subway.util.TextConstant.*;

import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private Sections sections = new Sections();

    public Line(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        this.name = name;
        this.sections.addSection(0, uplineTerminalStation);
        this.sections.addSection(0, downlineTerminalStation);
    }

    public String getName() {
        return name;
    }

    public void addSection(int index, Station station) {
        if (!sections.isPresentStation(station)) {
            sections.addSection(index, station);
            return;
        }

        throw new SubwayException(ERR_ALREADY_ADD_STATION_NAME_MSG);
    }

    public void deleteStation(String name) {
        if (sections.size() <= STATION_MINIMUM_SIZE) {
            throw new SubwayException(ERR_POOR_SIZE_OF_STATION_MSG);
        }
        sections.deleteSection(name);
    }

    public int size() {
        return sections.size();
    }

    public List<String> sectionsNames() {
        return sections.sectionNames();
    }

    public boolean isPresentStation(Station station) {
        return sections.isPresentStation(station);
    }

    public Station findStation(String stationName) {
        return sections.findStation(stationName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
