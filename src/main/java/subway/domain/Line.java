package subway.domain;

import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private static final Integer MIN_LINE_NAME_LENGTH=2;
    private static final Integer MIN_STATION_NAME_LENGTH=2;
    private static final Integer MIN_ARRAY_INDEX=0;

    private List<Station> stations;
    private String name;

    public Line(String name) {
        this.stations=new LinkedList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean addStation(int i,String name){
        if(i<MIN_ARRAY_INDEX||i>stations.size()){
            return false;
        }
        if(name.length()<MIN_STATION_NAME_LENGTH){
            return false;
        }
        stations.add(i,new Station(name));
        return true;
    }

    public void addAllStation(String...names){
        Arrays.stream(names)
                .forEach(name->stations.add(new Station(name)));
    }

    public List<Station> getStations() {
        return stations;
    }
}
