package subway.domain;

public class SectionStation {
    private Station station;
    private int index;

    public SectionStation(Station station, int index) {
        this.station = station;
        this.index = index;
    }

    public Station getStation() {
        return station;
    }

    public int getIndex() {
        return index;
    }
}
