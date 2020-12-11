package subway.domain;

import java.util.List;

public class Line {
    private static final int MIN_LENGTH_OF_LINE_NAME = 2;
    private String name;
    private List<Station> stations;

    public Line(String name, List<Station> stations) {
        validateLineName(name);
        this.name = name;
        this.stations = stations;
    }

    private void validateLineName(String name) {
        if (name.length() < MIN_LENGTH_OF_LINE_NAME) {
            throw new IllegalArgumentException("[ERROR] 지하철 노선 이름은 2글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean contains(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Line{" +
            "name='" + name + '\'' +
            ", stations=" + stations +
            '}';
    }
}
