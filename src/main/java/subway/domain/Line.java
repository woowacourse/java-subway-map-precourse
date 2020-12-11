package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String CONTOUR = "---";
    private static final int LEAST_STATION_NUM= 3;
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

    public void addInterval(Station station, int position) {
        stations.add(position - 1, station);
    }

    public void removeInterval(String stationName) {
        if(removePossible()) {
            stations.removeIf(station -> station.equalWith(stationName));
        }
    }

    public boolean removePossible() {
        return stations.size() >= LEAST_STATION_NUM;
    }

        // 추가 기능 구현
}
