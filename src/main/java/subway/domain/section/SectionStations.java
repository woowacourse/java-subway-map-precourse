package subway.domain.section;

import subway.domain.station.Station;
import subway.exception.AlreadyRegisteredSectionException;

import java.util.*;
import java.util.stream.Collectors;

public class SectionStations {
    private static final int FIRST_STATION_INDEX = 0;
    private static final int LAST_STATION_INDEX = 1;
    private static final int USER_INTERFACE_INDEX = 1; // 사용자 입력은 1번 인덱스 부터...
    private static final int STATION_MIN_COUNT = 2;

    private List<SectionStation> sectionStations = new LinkedList<>();

    public SectionStations(Station upStation, Station downStation) {
        sectionStations.add(new SectionStation(upStation));
        sectionStations.add(new SectionStation(downStation));
        sectionStations.get(LAST_STATION_INDEX).setPrevSectionStation(sectionStations.get(FIRST_STATION_INDEX));
    }

    public void add(Station station, int index) {
        SectionStation sectionStation = new SectionStation(station);

        if (isExistStation(station)) {
            throw new AlreadyRegisteredSectionException();
        }

        if (addIfLastIndex(sectionStation, index)) {
            return;
        }

        addIndex(sectionStation, index);
    }

    private boolean addIfLastIndex(SectionStation sectionStation, int index) {
        if (index > sectionStations.size()) {
            sectionStation.setPrevSectionStation(sectionStations.get(sectionStations.size() - LAST_STATION_INDEX));
            sectionStations.add(sectionStation);

            return true;
        }

        return false;
    }

    private void addIndex(SectionStation sectionStation, int index) {
        SectionStation targetSectionStation = sectionStations.get(sectionStations.size() - LAST_STATION_INDEX);

        for (int i = 0; i < sectionStations.size() - index; i++) {
            targetSectionStation = targetSectionStation.getPrevStation();
        }

        sectionStation.setPrevSectionStation(targetSectionStation.getPrevStation());
        targetSectionStation.setPrevSectionStation(sectionStation);

        sectionStations.add(index - USER_INTERFACE_INDEX, sectionStation);
    }

    public boolean remove(Station station) {
        SectionStation targetSectionStation = sectionStations.get(sectionStations.size() - LAST_STATION_INDEX);

        if (targetSectionStation.isEqualStation(station)) {
            sectionStations.remove(targetSectionStation);
        }

        for (int i = 0; i < sectionStations.size() - USER_INTERFACE_INDEX; i++) {
            changePrevStation(targetSectionStation, station);
            targetSectionStation = targetSectionStation.getPrevStation();
        }

        return true;
    }

    private void changePrevStation(SectionStation targetSectionStation, Station station) {
        if (targetSectionStation.isEqualPrevStation(station)) {
            SectionStation prevStation = targetSectionStation.getPrevStation();
            targetSectionStation.setPrevSectionStation(prevStation.getPrevStation());

            sectionStations.remove(prevStation);
        }
    }

    public List<Station> getStations() {
        SectionStation targetSectionStation = sectionStations.get(sectionStations.size() - LAST_STATION_INDEX);

        return getStations(targetSectionStation).stream()
                .map(SectionStation::getStation)
                .collect(Collectors.toList());
    }

    private List<SectionStation> getStations(SectionStation targetSectionStation) {
        List<SectionStation> sectionStations = new ArrayList<>();

        sectionStations.add(targetSectionStation);

        for (int i = 0; i < this.sectionStations.size() - LAST_STATION_INDEX; i++) {
            targetSectionStation = targetSectionStation.getPrevStation();
            sectionStations.add(targetSectionStation);
        }

        Collections.reverse(sectionStations);

        return sectionStations;
    }

    private boolean isExistStation(Station station) {
        return sectionStations.stream().anyMatch(sectionStation -> sectionStation.isEqualStation(station));
    }

    public boolean isContainStation(Station staiton) {
        return sectionStations.stream()
                .anyMatch(sectionStation -> sectionStation.isEqualStation(staiton));
    }

    public boolean isSectionSizeOverMin() {
        return sectionStations.size() > STATION_MIN_COUNT;
    }
}
