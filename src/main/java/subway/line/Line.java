package subway.line;

import subway.model.ResultDto;
import subway.station.Station;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private String name;
    private LinkedList<Station> stations;

    public Line(String name, Station upEndStation, Station downEndStation) {
        this.name = name;
        this.stations = new LinkedList<>();
        this.stations.add(upEndStation);
        this.stations.add(downEndStation);
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station, int order) {
        int orderIdx = order - 1;
        int numOfStations = stations.size();
        if (orderIdx > numOfStations || numOfStations < 0) {
            throw new IllegalArgumentException("추가할 수 없는 순서 입니다.");
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
            throw new IllegalArgumentException("노선에 포함된 역이 두개 이하이므로 삭제할 수 없습니다.");
        }

        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                stations.remove();
                return;
            }
        }
        throw new IllegalArgumentException("해당 노선에 존재하지 않는 역입니다.");
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
