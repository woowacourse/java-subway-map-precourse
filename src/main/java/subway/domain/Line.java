package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    private List<Station> stationList = new LinkedList<>();

    public Line(String name, String upLineLastStop, String downLineLastStop) {
        this.name = name;
        addStation(upLineLastStop);
        addStation(downLineLastStop);
    }

    public int size() {
        return stationList.size();
    }

    public void addStation(String stationName) {
        Station station = StationRepository.findStationByName(stationName);
        stationList.add(station);
        station.increaseCount();
    }

    public void addStation(String index, String stationName) {
        Station station = StationRepository.findStationByName(stationName);
        stationList.add(Integer.parseInt(index)-1, station);
        station.increaseCount();
    }

    public boolean isRemovable(String stationName) {
        if (stationList.removeIf(station -> station.getName().equals(stationName))) {
            Objects.requireNonNull(StationRepository.findStationByName(stationName)).decreaseCount();
            return true;
        }
        return false;
    }

    public List<Station> stationList() {
        return Collections.unmodifiableList(stationList);
    }



    /*public boolean equal(String lineName) {
        return name.equals(lineName);
    }*/

}
