package subway.domain.station;

import subway.exception.ErrorCode;
import subway.exception.SectionException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stations {
    private static final int MIN_SIZE = 2;

    private List<Station> stations;

    private Stations(List<Station> stations) {
        this.stations = new ArrayList<>(stations);
    }

    public static Stations of(List<Station> stations) {
        return new Stations(stations);
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public int size() {
        return stations.size();
    }

    public void addStation(Station station, int sequence) {
        stations.add(sequence, station);
    }

    public boolean deleteStation(Station station) {
        if (stations.size() == MIN_SIZE) {
            throw new SectionException(ErrorCode.SECTION_CANNOT_DELETE_STATION);
        }
        return stations.remove(station);
    }
}
