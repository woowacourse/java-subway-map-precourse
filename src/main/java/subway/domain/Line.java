package subway.domain;

import java.util.LinkedList;
import java.util.stream.Stream;

public class Line {
    private static final String ERROR_INDEX_NOT_IN_RANGE = "[ERROR] 잘못된 순서입니다.";
    private static final String ERROR_STATION_ALREADY_ON_LINE = "[ERROR] 이미 존재하는 역입니다.";
    private static final String ERROR_STATION_NOT_ON_LINE = "[ERROR] 노선에 해당 역이 없습니다.";
    private static final String ERROR_STATION_NOT_ON_STATION_REPOSITORY = "[ERROR] 데이터베이스에 등록되지 않은 역입니다.";
    private String name; // 변경 불가능
    private LinkedList<Station> stationsOnLine = new LinkedList<>(); // 해당 노선에 소속된 역(들)

    public Line(String name) { // 변경 불가능
        this.name = name;
    }

    public String getName() { // 변경 불가능
        return name;
    }

    public void initializeEndStations(Station upEndStation, Station downEndStation) {
        stationsOnLine.add(upEndStation);
        stationsOnLine.add(downEndStation);
    }

    public void addStation(String stationName, int index) {
        Station station = getStation(stationName);
        if(isStationInLine(station)) {
            throw new IllegalArgumentException(ERROR_STATION_ALREADY_ON_LINE);
        }
        if(!isIndexInRange(index - 1)) { // 순서는 1부터 입력 가능하므로
            throw new IllegalArgumentException(ERROR_INDEX_NOT_IN_RANGE);
        }
        stationsOnLine.add(index - 1, station);
    }

    private Station getStation(String stationName) {
        Stream<Station> stationStream = StationRepository.stations().stream();
        try {
            return stationStream.filter(station -> station.getName().equals(stationName)).findFirst().get();
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_STATION_NOT_ON_STATION_REPOSITORY);
        }
    }

    public void deleteStation(Station station) {
        if(!isStationInLine(station)) {
            throw new IllegalArgumentException(ERROR_STATION_NOT_ON_LINE);
        }
        stationsOnLine.remove(station);
    }

    private boolean isIndexInRange(int index) {
        return index < stationsOnLine.size() && index >= 0;
    }

    private boolean isStationInLine(Station station) {
        return stationsOnLine.contains(station);
    }
}
