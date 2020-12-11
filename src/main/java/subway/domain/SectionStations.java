package subway.domain;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SectionStations {
    private static final int UP_STATION_INDEX = 0;
    private static final int DOWN_STATION_INDEX = 2147483647;

    private List<SectionStation> sectionStations = new LinkedList<>();

    public SectionStations(Station upStation, Station downStation) {
        sectionStations.add(new SectionStation(upStation, UP_STATION_INDEX));
        sectionStations.add(new SectionStation(downStation, DOWN_STATION_INDEX));
    }

    public void add(Station station, int index) {
        sectionStations.add(new SectionStation(station, index));
    }

    public boolean remove(Station station) {
        return sectionStations.removeIf(sectionStation -> Objects.equals(sectionStation.getStation(), station));
    }

    public List<Station> getStations() {
        return sectionStations.stream()
                .sorted(Comparator.comparing(SectionStation::getIndex))
                .map(SectionStation::getStation)
                .collect(Collectors.toList());
    }
}
