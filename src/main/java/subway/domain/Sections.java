package subway.domain;

import subway.exception.SubwayException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static subway.util.TextConstant.*;
import static subway.util.TextConstant.ERR_NO_SUCH_NAME_STATION_MSG;

public class Sections {
    private final List<Station> sections = new ArrayList<>();

    public void addSection(int index, Station station) {
        if (!sections.contains(station)) {
            try {
                sections.add(index, station);
            } catch (IndexOutOfBoundsException e) {
                throw new SubwayException(ERR_WRONG_SEQUENCE_MSG);
            }
            return;
        }
        throw new SubwayException(ERR_ALREADY_ADD_STATION_NAME_MSG);
    }

    public void deleteSection(String name) {
        if (!sections.removeIf(station -> Objects.equals(station.getName(), name))) {
            throw new SubwayException(ERR_NO_SUCH_NAME_STATION_MSG);
        }
    }

    public int size() {
        return sections.size();
    }

    public Station findStation(String name) {
        return sections.stream()
                .filter(station -> Objects.equals(station.getName(), name))
                .findFirst()
                .orElseThrow(() -> new SubwayException(ERR_NO_SUCH_NAME_STATION_MSG));
    }

    public List<String> sectionNames() {
        return sections.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    public boolean isPresentStation(Station station) {
        return sections.contains(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sections)) return false;
        Sections sections1 = (Sections) o;
        return Objects.equals(sections, sections1.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sections);
    }

    @Override
    public String toString() {
        return "Sections{" +
                "sections=" + sections +
                '}';
    }
}
