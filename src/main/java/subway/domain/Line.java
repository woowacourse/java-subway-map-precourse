package subway.domain;

import java.util.LinkedList;

public class Line {

    private static final int FIRST_INDEX = 0;
    private static final int PREVIOUS_INDEX = -1;
    private static final int NEXT_INDEX = 1;

    private final String name;
    private String northboundTerminal;
    private String southboundTerminal;
    private final LinkedList<String> stationsIncludedLine = new LinkedList<String>();

    public Line(String name, String northboundTerminal, String southboundTerminal) {
        this.name = name;
        this.northboundTerminal = northboundTerminal;
        this.southboundTerminal = southboundTerminal;
        addOnLine(northboundTerminal);
        addOnLine(southboundTerminal);
        StationRepository.getStationNamed(northboundTerminal).registerIn(name);
        StationRepository.getStationNamed(southboundTerminal).registerIn(name);
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getStationsIncludedLine() {
        return stationsIncludedLine;
    }

    public int getLineLength() {
        return stationsIncludedLine.size();
    }

    public void addOnLine(String stationName) {
        stationsIncludedLine.add(stationName);
        southboundTerminal = stationName;
    }

    public void addOnLine(int index, String stationName) {
        stationsIncludedLine.add(index, stationName);
        if (index == FIRST_INDEX) {
            northboundTerminal = stationName;
            return;
        }
        if (index == getLineLength() + PREVIOUS_INDEX) {
            southboundTerminal = stationName;
        }
    }

    public void deleteOnLine(String stationName) {
        int index = stationsIncludedLine.indexOf(stationName);
        stationsIncludedLine.remove(stationName);
        if (index == FIRST_INDEX) {
            northboundTerminal = stationsIncludedLine.get(index + NEXT_INDEX);
            return;
        }
        if (index == getLineLength() + PREVIOUS_INDEX) {
            southboundTerminal = stationsIncludedLine.get(index + PREVIOUS_INDEX);
        }
    }

    public boolean includedInSomeStations() {
        return !stationsIncludedLine.isEmpty();
    }

}
