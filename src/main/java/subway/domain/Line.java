package subway.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Line {
    private static String ERR_OUT_OF_BOUND = "노선의 길이 범위를 벗어나는 순서값입니다.";
    private String name;
    private List<Station> stations;

    public Line(String name, Station... stations) {
        this.name = name;
        this.stations = new LinkedList<>(Arrays.asList(stations));
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void add(int index, Station station) {
        try {
            stations.add(index, station);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERR_OUT_OF_BOUND);
        }
    }

    public boolean remove(Station station) {
        return stations.remove(station);
    }
}
