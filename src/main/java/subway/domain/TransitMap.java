package subway.domain;

import java.util.LinkedList;

public class TransitMap {
    private Line transitMapLine;
    private LinkedList<Station> transitMapStations;

    public TransitMap(Line transitMapLine, LinkedList<Station> transitMapStations) {
        this.transitMapLine = transitMapLine;
        this.transitMapStations = transitMapStations;
    }

    public Line getTransitMapLine() {
        return transitMapLine;
    }

    public LinkedList<Station> getTransitMapStations() {
        return transitMapStations;
    }
}
