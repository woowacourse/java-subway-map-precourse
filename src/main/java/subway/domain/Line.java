package subway.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import subway.exception.LineErrorMessage;

public class Line implements LineErrorMessage {
    private static final int MINIMUM_STATIONS_WHEN_SECTION_TO_BE_DELETED = 3;
    private static final String SYMBOL_INFO = "[INFO] ";
    private static final String HORIZONTAL_DELIMITER = SYMBOL_INFO + "---";
    private String name; // 변경 불가능
    private LinkedList<Station> stationsOnLine = new LinkedList<>(); // 해당 노선에 소속된 역(들)

    public Line(String name) { // 변경 불가능
        this.name = name;
    }

    public String getName() { // 변경 불가능
        return name;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stationsOnLine);
    }

    public void initializeEndStations(Station upEndStation, Station downEndStation) {
        upEndStation.enroll(this);
        downEndStation.enroll(this);
        stationsOnLine.add(upEndStation);
        stationsOnLine.add(downEndStation);
    }

    public void addStation(String stationName, String stationIndex) {
        int index = validateIndex(stationIndex);
        Station station = getStation(stationName);
        if (isStationInLine(station)) {
            throw new IllegalArgumentException(ERROR_STATION_ALREADY_ON_LINE);
        }
        if (!isIndexInRange(index - 1)) { // 순서는 1부터 입력 가능하므로
            throw new IllegalArgumentException(ERROR_INDEX_NOT_IN_RANGE);
        }
        station.enroll(this);
        stationsOnLine.add(index - 1, station);
    }

    private int validateIndex(String stationIndex) {
        try {
            return Integer.parseInt(stationIndex);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_INDEX);
        }
    }

    private Station getStation(String stationName) {
        Stream<Station> stationStream = StationRepository.stations().stream();
        try {
            return stationStream.filter(station -> station.getName().equals(stationName)).findFirst().get();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_STATION_NOT_ON_STATION_REPOSITORY);
        }
    }

    public void deleteStation(String stationName) {
        if(!isSectionAbleToBeDeleted()) {
            throw new IllegalArgumentException(ERROR_NOT_BE_ABLE_TO_DELETE_SECTION);
        }
        Station station = getStation(stationName);
        if(!isStationInLine(station)) {
            throw new IllegalArgumentException(ERROR_STATION_NOT_ON_LINE);
        }
        station.disEnroll(this);
        stationsOnLine.remove(station);
    }

    private boolean isSectionAbleToBeDeleted() {
        return stationsOnLine.size() >= MINIMUM_STATIONS_WHEN_SECTION_TO_BE_DELETED;
    }

    private boolean isIndexInRange(int index) {
        return index <= stationsOnLine.size() && index >= 0;
    }

    private boolean isStationInLine(Station station) {
        return stationsOnLine.contains(station);
    }

    public void printStations() {
        System.out.println(HORIZONTAL_DELIMITER);
        Iterator iterator = stationsOnLine.iterator();
        while (iterator.hasNext()) {
            Station station = (Station)iterator.next();
            System.out.println(SYMBOL_INFO + station.getName());
        }
    }
}
