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

/*    private List<Station> stationList = new LinkedList<>();

    public boolean equal(String lineName) {
        return name.equals(lineName);
    }*/

}
