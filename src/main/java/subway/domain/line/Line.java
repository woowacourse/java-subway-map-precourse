package subway.domain.line;

import subway.domain.section.SectionStations;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.NameLengthException;
import subway.exception.NotContainStationException;
import subway.exception.SectionSizeException;

public class Line {
    private static final int NAME_LENGTH_MIN = 2;

    private String name;
    private SectionStations sectionStations;

    public Line(String name) {
        if (name.length() < NAME_LENGTH_MIN) {
            throw new NameLengthException();
        }

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
        if (!isSectionSizeOverMin()) {
            throw new SectionSizeException();
        }

        if (!isContainStation(StationRepository.findStationByName(name))) {
            throw new NotContainStationException();
        }

        return sectionStations.remove(StationRepository.findStationByName(name));
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    public boolean isContainStation(Station station) {
        return sectionStations.isContainStation(station);
    }

    private boolean isSectionSizeOverMin() {
        return sectionStations.isSectionSizeOverMin();
    }
}
