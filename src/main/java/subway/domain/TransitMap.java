package subway.domain;

import java.util.LinkedList;

/**
 * TransitMap.java : 지하철 노선도에 대한 도메인 모델 클래스
 *
 * @author Daeun lee
 * @version 1.0
 */
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
