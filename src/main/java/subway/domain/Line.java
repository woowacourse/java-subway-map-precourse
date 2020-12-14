package subway.domain;

import subway.repository.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getSections() {
        return sections;
    }

    public void addSection(Station station) {
        if (StationRepository.stations().contains(station)) {
            sections.add(station);
        }
    }
}
