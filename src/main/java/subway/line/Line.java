package subway.line;

import subway.model.ResultDto;
import subway.station.Station;

import java.util.LinkedList;

public class Line {

    private static final String ADD_STATION_ERROR_MESSAGE = "추가할 수 없는 순서 입니다.";
    private static final String REMOVE_STATION_ERROR_MESSAGE = "노선에 포함된 역이 두개 이하이므로 삭제할 수 없습니다.";
    private static final String NOT_EXISTS_STATION_ERROR_MESSAGE = "해당 노선에 존재하지 않는 역입니다.";

    private String name;
    private LinkedList<Station> stations;

    public Line(String name) {
        this.name = name;
        this.stations = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public static Line of(String lineName, String upEndStation, String downEndStation) {
        Line line = new Line(lineName);
        line.addStation(new Station(upEndStation),1);
        line.addStation(new Station(downEndStation), 2);
        return line;
    }

    public void addStation(Station station, int order) {
        int orderIdx = order - 1;
        int numOfStations = stations.size();
        if (orderIdx > numOfStations || numOfStations < 0) {
            throw new IllegalArgumentException(ADD_STATION_ERROR_MESSAGE);
        }
        stations.add(orderIdx, station);
    }

    public boolean isStationInLine(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public void removeStationByName(String stationName) {
        if (stations.size() <= 2) {
            throw new IllegalArgumentException(REMOVE_STATION_ERROR_MESSAGE);
        }

        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                stations.remove();
                return;
            }
        }
        throw new IllegalArgumentException(NOT_EXISTS_STATION_ERROR_MESSAGE);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result
            .append(ResultDto.RESULT_OK_PREFIX + this.name + "\n")
            .append(ResultDto.RESULT_OK_PREFIX + "---" + "\n");
        for (Station station : stations) {
            result.append(ResultDto.RESULT_OK_PREFIX + station.getName() + "\n");
        }
        return result.toString();
    }
}
