package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private String name;
    private List<Station> lineInStationList = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public List<Station> lineInStationList() {
        return Collections.unmodifiableList(lineInStationList);
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

    public void insertLineInStation(Station station, int index) {
        if (index > lineInStationList.size()) {
            lineInStationList.add(lineInStationList.size(), station);
            return;
        }
        lineInStationList.add(index, station);
    }

    public boolean deleteLineByName(String name) {
        return lineInStationList.removeIf(station -> Objects.equals(station.getName(), name));
    }
}
