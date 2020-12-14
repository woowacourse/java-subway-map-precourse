package subway.domain;

import subway.view.ErrorView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LENGTH = 2;
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        if(name.length() < MINIMUM_LENGTH){
            return;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

// 추가 기능 구현
    public void addStations(String[] stationNames){
        for(String station : stationNames){
            stations.add(new Station(station));
        }
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean existStation(String name) {
        for(Station station : stations){
            if(station.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean addStation(String stationName) {
        if(stationName.length() < MINIMUM_LENGTH){
            ErrorView.nameLengthError();
            return false;
        }
        stations.add(new Station(stationName));
        return true;
    }
}
