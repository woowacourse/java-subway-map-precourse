package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private final List<Station> stationList = new ArrayList<>();

    public Line(String name, Station upStation, Station downStation) {
        this.name = name;
        stationList.add(upStation);
        stationList.add(downStation);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addSection(int index, Station station) {
        stationList.add(index, station);
    }

    public void enrollStation(Station station){
        stationList.add(station);
    }

    public List<Station> getStationList() {
        return Collections.unmodifiableList(stationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Line) {
            Line o = (Line) obj;
            return this.name.equals(o.name);
        }
        return false;
    }
}
