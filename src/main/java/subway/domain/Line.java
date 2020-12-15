package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<String> stationNamesInLine = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStationName(int index, String stationName) {
        stationNamesInLine.add(index - 1, stationName);
    }

    public boolean deleteStationName(String deleteName) {
        return stationNamesInLine.removeIf(stationName -> Objects.equals(stationName, deleteName));
    }

    public List<String> getStationNames() {
        return stationNamesInLine;
    }

    public void addStationNames(List<String> stationNames) {
        stationNamesInLine.addAll(stationNames);
    }

    public boolean contains(String specificStationName) {
        return stationNamesInLine.stream().anyMatch(stationName -> stationName.equals(specificStationName));
    }

    public int size() {
        return stationNamesInLine.size();
    }
}
