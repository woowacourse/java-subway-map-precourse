package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> sections = new ArrayList<>();

    public Line(String name, String upboundStationName, String downboundStationName) {
        this.name = name;
        sections.add(StationRepository.getByName(upboundStationName));
        sections.add(StationRepository.getByName(downboundStationName));
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
