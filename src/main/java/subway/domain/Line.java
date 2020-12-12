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

    public static void validateLineName(String name) {
        if (name.trim().length() < MIN_LENGTH_OF_LINE_NAME) {
            throw new IllegalArgumentException(
                "[ERROR] 지하철 노선 이름은 2글자 이상이어야 합니다. (문자열의 양 끝에 있는 공백 제외한 이름이 2글자 이상이어야 합니다.)");
        }
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public boolean contains(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public void addStation(String stationName, Order order) {
        int index = order.getOrder() - 1;
        stations.add(index, new Station(stationName));
    }

    public void deleteStation(String stationName) {
        stations.removeIf(station -> station.getName().equals(stationName));
    }


    @Override
    public String toString() {
        return "Line{" +
            "name='" + name + '\'' +
            ", stations=" + stations +
            '}';
    }
}
