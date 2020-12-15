package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> lineStations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void setTerminal(Station upTerminal, Station downTerninal) {
        this.lineStations.add(upTerminal);
        this.lineStations.add(downTerninal);
    }

    public void addStation(Station station) {

    }
}
