package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subway.exception.SubwayCustomException;

public class Line {

    private static final String NOT_VALID_SECTION_EXCEPTION_MESSAGE = "존재하지 않는 구간입니다.";

    private String name;
    private List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void addSection(Station inputStation) {
        if (StationRepository.stations().contains(inputStation)) {
            sections.add(inputStation);
        }
    }

    public void addSectionWithPosition(int position, Station inputStation) {
        if (StationRepository.stations().contains(inputStation)) {
            sections.add(position - 1, inputStation);
        }
    }

    public void deleteSection(Station inputStation) {
        if (!(sections.removeIf(station -> inputStation == station))) {
            throw new SubwayCustomException(NOT_VALID_SECTION_EXCEPTION_MESSAGE);
        }
    }

    public Station searchSection(String name) {
        return sections.stream()
            .filter(station -> Objects.equals(station.getName(), name))
            .findFirst()
            .orElseThrow(() -> new SubwayCustomException(NOT_VALID_SECTION_EXCEPTION_MESSAGE));
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return sections;
    }
}
