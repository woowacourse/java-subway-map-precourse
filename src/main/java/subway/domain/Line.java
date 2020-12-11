package subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    private String northboundTerminal;
    private String southboundTerminal;
    private LinkedList<String> stationsIncludedLine = new LinkedList<String>();

    public Line(String name, String northboundTerminal, String southboundTerminal) {
        this.name = name;
        this.northboundTerminal = northboundTerminal;
        this.southboundTerminal = southboundTerminal;
    }

    public String getName() {
        return name;
    }

    public String getNorthboundTerminal() {
        return northboundTerminal;
    }

    public String getSouthboundTerminal() {
        return southboundTerminal;
    }

    public LinkedList<String> getStationsIncludedLine() {
        return stationsIncludedLine;
    }

    public int getLineLength() {
        return stationsIncludedLine.size();
    }

    public void appendStation(String stationName) {
        stationsIncludedLine.add(stationName);
    }

    public boolean includedInSomeStations() {
        return !stationsIncludedLine.isEmpty();
    }

}
