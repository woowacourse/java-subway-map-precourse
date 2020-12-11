package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String CONTOUR = "---";
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public boolean isContaining(Station station) {
        return stations.contains(station);
    }

    public boolean equalWith(String newName) {
        return name.equals(newName);
    }

    public List<String> inquiryStations() {
        List<String> stationNames = new ArrayList<>();
        stationNames.add(this.name);
        stationNames.add(CONTOUR);

        for(Station station: stations) {
            stationNames.add(station.getName());
        }
        return stationNames;
    }
        // 추가 기능 구현
}
