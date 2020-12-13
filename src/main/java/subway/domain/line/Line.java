package subway.domain.line;

import subway.domain.section.SectionStations;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

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
