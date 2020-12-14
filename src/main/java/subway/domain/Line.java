package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static subway.domain.StationRepository.searchStation;

public class Line {
    private String name;
    private ArrayList<Station> section;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void initializeSection(String start, String end) throws IllegalArgumentException {
        section = new ArrayList<>();
        section.add(0, searchStation(start));
        section.add(1, searchStation(end));
        if (section.get(0).getName().equals(section.get(1).getName())) {
            throw new IllegalArgumentException("[ERROR] 시작역과 종점역의 이름이 같습니다.");
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" - ");
        for (Station station : section) {
            joiner.add(station.getName());
        }
        return name + "\n" + joiner + "\n";
    }
}
