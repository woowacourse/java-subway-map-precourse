package subway.domain.section;

import subway.domain.station.Station;

public class SectionStation {
    private Station station;
    private SectionStation prevStation;

    public SectionStation(Station station) {
        this.station = station;
    }

    public Station getStation() {
        return station;
    }

    public SectionStation getPrevStation() {
        return prevStation;
    }

    public void setPrevSectionStation(SectionStation sectionStation) {
        prevStation = sectionStation;
    }

    public boolean isEqualStation(Station station) {
        return this.station.equals(station);
    }

    public boolean isEqualPrevStation(Station station) {
        return this.prevStation.isEqualStation(station);
    }
}
