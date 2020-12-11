package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class SectionStations {
    private static final int UP_STATION_INDEX = 0;
    private static final int DOWN_STATION_INDEX = 2147483647;

    private List<SectionStation> sectionStations = new LinkedList<>();

    public SectionStations(Station upStation, Station downStation) {
        sectionStations.add(new SectionStation(upStation, UP_STATION_INDEX));
        sectionStations.add(new SectionStation(downStation, DOWN_STATION_INDEX));
    }
}
