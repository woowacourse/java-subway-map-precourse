package subway.domain;

import java.util.LinkedList;

public class Line {
    private String name;
    public LinkedList<Station> line = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addTerminus(String upBoundTerminus, String downBoundTerminus) {
        line.addFirst(StationRepository.findStation(upBoundTerminus));
        line.addLast(StationRepository.findStation(downBoundTerminus));
    }
}
