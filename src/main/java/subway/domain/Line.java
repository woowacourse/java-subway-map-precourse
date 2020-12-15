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

    //TODO 삭제 여부를 알아보는 메서드와 삭제를 진행하는 메서드로 나눠야함
    // 구간 삭제
    public boolean removeStation(String stationName) {
        return stationList.removeIf(station -> station.getName().equals(stationName));
    }

    public void beforeRemove() {
        for (Station station : stationList()) {
            station.decreaseCount();
        }
    }

    public void deleteLine() {
        beforeRemove();
        LineRepository.deleteLineByName(this.name);
    }

    public List<Station> stationList() {
        return Collections.unmodifiableList(stationList);
    }


}
