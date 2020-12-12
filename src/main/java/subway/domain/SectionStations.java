package subway.domain;

import java.util.*;
import java.util.stream.Collectors;

public class SectionStations {
    private static final int FIRST_STATION_INDEX = 0;
    private static final int LAST_STATION_INDEX = 1;
    private static final int USER_INTERFACE_INDEX = 1; // 사용자 입력은 1번 인덱스 부터...

    private List<SectionStation> sectionStations = new LinkedList<>();

    public SectionStations(Station upStation, Station downStation) {
        sectionStations.add(new SectionStation(upStation));
        sectionStations.add(new SectionStation(downStation));
        sectionStations.get(LAST_STATION_INDEX).setPrevSectionStation(sectionStations.get(FIRST_STATION_INDEX));
    }

    public void add(Station station, int index) {
        SectionStation sectionStation = new SectionStation(station);

        if (index > sectionStations.size()) {
            sectionStation.setPrevSectionStation(sectionStations.get(sectionStations.size() - LAST_STATION_INDEX));
            sectionStations.add(sectionStation);

            return;
        }

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

        if (targetSectionStation.getStation().equals(station)) {
            sectionStations.remove(targetSectionStation);
        }

        for (int i = 0; i < sectionStations.size() - USER_INTERFACE_INDEX; i++) {
            if (targetSectionStation.getPrevStation().getStation().equals(station)) {
                SectionStation prevStation = targetSectionStation.getPrevStation();
                targetSectionStation.setPrevSectionStation(prevStation.getPrevStation());

                sectionStations.remove(prevStation);

                break;
            }

            targetSectionStation = targetSectionStation.getPrevStation();
        }

        return true;
    }

    public List<Station> getStations() {
        SectionStation targetSectionStation = sectionStations.get(sectionStations.size() - LAST_STATION_INDEX);
        List<SectionStation> sectionStations = new ArrayList<>();

        sectionStations.add(targetSectionStation);

        for (int i = 0; i < this.sectionStations.size() - LAST_STATION_INDEX; i++) {
            targetSectionStation = targetSectionStation.getPrevStation();
            sectionStations.add(targetSectionStation);
        }

        Collections.reverse(sectionStations);

        return sectionStations.stream()
                .map(SectionStation::getStation)
                .collect(Collectors.toList());
    }
}
