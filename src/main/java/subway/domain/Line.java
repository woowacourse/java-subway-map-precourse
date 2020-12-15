package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private String name;
    private List<Station> section = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationInLine(int i, Station station) {
        station.changeStatus();
        section.add(i - 1, station);
    }

    public void addStationListInLine(List<String> stationNames) {
        for (int i = 0; i < stationNames.size(); i++) {
            Station station = new Station(stationNames.get(i));
            station.changeStatus();
            section.add(station);
        }
    }

    public void deleteStationInLine(Station station) {
        section.remove(station);
    }

    public List<String> getSectionName() {
        List<String> sectionName = new ArrayList<>();
        for (int i = 0; i < section.size(); i++) {
            sectionName.add(section.get(i).getName());
        }
        return sectionName;
    }

    public int getSectionSize() {
        return section.size();
    }
}
