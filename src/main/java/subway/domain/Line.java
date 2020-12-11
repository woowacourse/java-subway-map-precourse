package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private SectionStations sectionStations;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public void initializeSectionStation(Station upStation, Station downStation) {
        sectionStations = new SectionStations(upStation, downStation);
    }

    public SectionStations getSectionStations() {
        return sectionStations;
    }

    public void addStation(Station station, int index) {
        sectionStations.add(station, index);
    }

    public boolean deleteStation(String name) {
        return sectionStations.remove(StationRepository.findStationByName(name));
    }
}
