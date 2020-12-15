package subway.domain;

import static subway.message.ErrorMessage.LINE_INVALID_NAME_LENGTH;
import static subway.message.ErrorMessage.LINE_STATIONS_ITEM_DUPLICATED;
import static subway.message.ErrorMessage.LINE_STATIONS_TOO_SMALL;
import static subway.message.ErrorMessage.LINE_STATION_ALREADY_EXIST;
import static subway.message.ErrorMessage.LINE_STATION_DOES_NOT_EXIST;
import static subway.message.ErrorMessage.LINE_STATION_INDEX_OUT_OF_RANGE;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Line {

    public static final int MIN_LINE_NAME_LENGTH = 2;
    public static final int MIN_STATIONS_SIZE = 2;

    private final String name;
    private final List<Station> stations;

    public Line(final String name, final List<Station> initialStations)
        throws IllegalArgumentException {
        validateLineNameLength(name);
        validateInitialStationsDuplicate(initialStations);
        validateInitialStationsSize(initialStations);
        this.name = name;
        this.stations = new LinkedList<>(initialStations);
        this.stations.forEach(station -> station.addParentLine(this));
    }

    private void validateLineNameLength(final String name) {
        if (name.length() < MIN_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException(LINE_INVALID_NAME_LENGTH.toString());
        }
    }

    private void validateInitialStationsDuplicate(final List<Station> stations) {
        final Set<Station> stationSet = new HashSet<>(stations);
        if (stationSet.size() != stations.size()) {
            throw new IllegalArgumentException(LINE_STATIONS_ITEM_DUPLICATED.toString());
        }
    }

    private void validateInitialStationsSize(final List<Station> stations) {
        if (stations.size() < MIN_STATIONS_SIZE) {
            throw new IllegalArgumentException(LINE_STATIONS_TOO_SMALL.toString());
        }
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(int index, Station station) throws IllegalArgumentException {
        validateStationDuplicate(station);
        validateStationIndex(index);
        stations.add(index, station);
    }

    private void validateStationDuplicate(final Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(LINE_STATION_ALREADY_EXIST.toString());
        }
    }

    private void validateStationIndex(final int index) {
        if (index < 0 || index > stations.size()) {
            throw new IllegalArgumentException(LINE_STATION_INDEX_OUT_OF_RANGE.toString());
        }
    }

    public void removeStation(final Station station) throws IllegalArgumentException {
        final int index = validateStationExistInThisLine(station);
        validateStationsSize();
        station.removeParentLine(this);
        stations.remove(index);
    }

    private int validateStationExistInThisLine(final Station station) {
        final int index = stations.indexOf(station);
        if (index == -1) {
            throw new IllegalArgumentException(LINE_STATION_DOES_NOT_EXIST.toString());
        }
        return index;
    }

    private void validateStationsSize() {
        if (stations.size() == MIN_STATIONS_SIZE) {
            throw new IllegalArgumentException(LINE_STATIONS_TOO_SMALL.toString());
        }
    }

    public void removeAllStations() {
        while (!stations.isEmpty()) {
            stations.get(0).removeParentLine(this);
            stations.remove(0);
        }
    }
}
