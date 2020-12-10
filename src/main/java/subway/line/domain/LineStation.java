package subway.line.domain;

import subway.station.domain.Station;

public class LineStation {

    private final Station station;
    private Station prevStation;

    private LineStation(Station station, Station prevStation) {
        this.station = station;
        this.prevStation = prevStation;
    }

    public static LineStation from(Station station) {
        return new LineStation(station, null);
    }

    public static LineStation of(Station station, Station prevStation) {
        return new LineStation(station, prevStation);
    }

    public boolean isFirst() {
        return prevStation == null;
    }

    public String getName() {
        return station.getName();
    }

    public Station getStation() {
        return station;
    }

    public Station getPrevStation() {
        return prevStation;
    }

    public void setPrevStation(Station station) {
        prevStation = station;
    }
}
