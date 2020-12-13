package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
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
    private ArrayList<Station> stationsInLine = new ArrayList<Station>();

    public ArrayList<Station> getStationsInLine() { return stationsInLine; }

    public void addStationsInLine(Station station) {
        stationsInLine.add(station);
    }

    public boolean checkSameName(String name) {
        return (this.name.equals(name));
    }

}
