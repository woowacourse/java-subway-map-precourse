package subway.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        stationList.add(StationRepository.findStationByName(upLineLastStop));
        stationList.add(StationRepository.findStationByName(downLineLastStop));
    }

    public int size() {
        return stationList.size();
    }

    public void addStation(String stationName) {
        Station station = StationRepository.findStationByName(stationName);
        stationList.add(station);
    }

    public void addStation(String index, String stationName) {
        Station station = StationRepository.findStationByName(stationName);
        stationList.add(Integer.parseInt(index)-1, station);
    }

    public boolean isRemovable(String stationName) {
        return stationList.removeIf(station -> station.getName().equals(stationName));
    }

    public List<Station> stationList() {
        return Collections.unmodifiableList(stationList);
    }



    /*public boolean equal(String lineName) {
        return name.equals(lineName);
    }*/

}
