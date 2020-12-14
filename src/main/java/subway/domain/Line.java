package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> lineInStationList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isEqualName(String name) {
        return name.equals(this.name);
    }

    public void initLineInStation(Station firstStation, Station lastStation) {
        lineInStationList.add(firstStation);
        lineInStationList.add(lastStation);
    }

    public boolean isExistStation(String name) {
        for (Station station : lineInStationList) {
            if (station.isEqualName(name)) {
                return true;
            }
        }
        return false;
    }
}
