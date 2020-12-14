package subway.domain;

import subway.exception.SubwayException;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.utils.ValidateUtils;
import subway.view.TextCollection;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public void addSection(Station station) {
        if (StationRepository.stations().contains(station)) {
            sections.add(station);
        }
    }

    public void addSectionWithPosition(int position, Station station) {
        if (StationRepository.stations().contains(station)) {
            ValidateUtils.isPositionOutOfLine(sections, position);
            sections.add(position - 1, station);
        }
    }

    public void deleteSection(Station inputStation) {
        Line line = LineRepository.searchLine(name);
        ValidateUtils.isAtLeastTwoStations(line);
        if (!(sections.removeIf(station -> inputStation == station))) {
            throw new SubwayException(TextCollection.NOT_EXIST_SECTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return sections;
    }
}
