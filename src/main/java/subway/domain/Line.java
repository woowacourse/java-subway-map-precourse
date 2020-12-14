package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private static final int FROM_ORDER_TO_INDEX = 1;//구간 순서 와 인덱스 보정값 네이밍
    private Station upwardStation; //상행 종착점
    private Station downwardStation; // 하행 종착점
    private List<Station> sections = new LinkedList<>();

    // 구간 관련 메소드 시작
    public List<Station> getSections() {
        return sections;
    }

    public void addSectionByStation(Station station) {
        sections.add(station);
    }
    // orderOfRoute-1 == index
    public void addSectionByOrderAndStation(int orderOfRoute, Station station) {
        sections.add(orderOfRoute-FROM_ORDER_TO_INDEX,station);
    }

    public boolean deleteSectionByName(String name) {
        return sections.removeIf(station -> Objects.equals(station.getName(), name));
    }
    // 구간 관련 메소드 끝

    // 상행, 하행 getter setter 시작
    public Station getUpwardStation() {
        return upwardStation;
    }

    public void setUpwardStation(Station upwardStation) {
        this.upwardStation = upwardStation;
    }

    public Station getDownwardStation() {
        return downwardStation;
    }

    public void setDownwardStation(Station downwardStation) {
        this.downwardStation = downwardStation;
    }
    // 상행, 하행 getter setter 끝
}
