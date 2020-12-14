package subway.domain.line;

import subway.domain.station.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;
    private List<Station> sections;

    public Line(String name) {
    private Line(String name, List<Station> sections) {
        this.name = name;
        this.sections = sections;
    }

    public static Line createLine(String name, String upwardEndStationName, String downwardEndStationName) {
        LineValidator.validate(name, upwardEndStationName, downwardEndStationName);
        List<Station> sections = new ArrayList<>();
        sections.add(new Station(upwardEndStationName));
        sections.add(new Station(downwardEndStationName));
        return new Line(name, sections);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
