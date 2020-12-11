package subway.domain;

import java.util.HashSet;

public class Station {

    private String name;
    private boolean northboundTerminal;
    private boolean southboundTerminal;
    private HashSet<String> linesIncludedStation = new HashSet<String>();

    public Station(String name) {
        this.name = name;
        this.northboundTerminal = false;
        this.southboundTerminal = false;
    }

    public String getName() {
        return name;
    }

    public boolean isNorthboundTerminal() {
        return northboundTerminal;
    }

    public boolean isSouthboundTerminal() {
        return southboundTerminal;
    }

    public void registerToNorthbound() {
        northboundTerminal = true;
    }

    public void deleteFromNorthbound() {
        northboundTerminal = false;
    }

    public void registerToSouthbound() {
        southboundTerminal = true;
    }

    public void deleteFromSouthbound() {
        southboundTerminal = false;
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
