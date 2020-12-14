package subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    private LinkedList<Station> line = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public Line addTerminus(String upBoundTerminus, String downBoundTerminus) {
        line.addFirst(StationRepository.findStation(upBoundTerminus));
        line.addLast(StationRepository.findStation(downBoundTerminus));
        return this;
    }

    public LinkedList<Station> stations() {
        return line;
    }
}
