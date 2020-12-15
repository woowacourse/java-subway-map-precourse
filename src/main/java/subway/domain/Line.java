package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> stationList;

    public Line(String name, List<Station> stationList) {
        this.name = name;
        this.stationList = stationList;
    }

    public void addStation(Station station, int order) {
        stationList.add(order, station);
    }

    public void deleteStation(Station station) {
        stationList.remove(station);
    }

    public boolean isStationInLine(String name) {
        for(Station s : stationList) {
            if(s.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public int getStationSize() {
        return stationList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Line)) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
