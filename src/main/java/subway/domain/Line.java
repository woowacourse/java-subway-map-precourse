package subway.domain;

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

    private StationRepository stationRepository = new StationRepository();

    /*public boolean equal(String lineName) {
        return name.equals(lineName);
    }*/

}
