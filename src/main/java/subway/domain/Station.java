package subway.domain;

import java.util.HashSet;

public class Station {

    private String name;
    private HashSet<String> linesIncludedStation = new HashSet<String>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void registerIn(String lineName) {
        linesIncludedStation.add(lineName);
    }

    public void deleteFrom(String lineName) {
        linesIncludedStation.remove(lineName);
    }

    public boolean includedInSomeLines() {
        return !linesIncludedStation.isEmpty();
    }

}
