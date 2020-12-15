package subway.domain;

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

    List<Station> stationList = new LinkedList<>();

    public Line(String name, String upLineLastStop, String downLineLastStop) {
        this.name = name;
        stationList.add(new Station(upLineLastStop));
        stationList.add(new Station(downLineLastStop));
    }



    /*public boolean equal(String lineName) {
        return name.equals(lineName);
    }*/

}
