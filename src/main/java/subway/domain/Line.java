package subway.domain;

import java.util.List;

import static subway.utils.Constant.MIN_STATION_AND_LINE_NAME_LENGTH;

public class Line {
    private final String name;
    private final List<Station> stations;

    public Line(String name, List<Station> stations) {
        if(name.length() < MIN_STATION_AND_LINE_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 2글자 이상이여야 합니다.");
        }
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addSectionStation(Station station, int index) {
        this.stations.add(index, station);
    }
}
