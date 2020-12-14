package subway.domain;

import subway.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.view.OutputView.*;
import static subway.view.OutputView.warnMessage;

public class Line {
    private static final int MIN_NAME_LENGTH = 2;
    private static final String LINE_NAME_LENGTH_WARN = "노선 이름은 2글자 이상이어야 합니다.";

    private String name;
    private final List<Station> stationList = new ArrayList<>();

    public Line(String lineName, Station upStation, Station downStation) {
        name = lineName;
        stationList.add(upStation);
        stationList.add(downStation);
    }

    public static boolean validateLineName(String lineName) {
        if (lineName.length() < MIN_NAME_LENGTH) {
            warnMessage(LINE_NAME_LENGTH_WARN);
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stationList);
    }

    public void printLineDetail() {
        lineDetailPrint(name, stations());
    }

    public void addSection(int index, Station station) {
        stationList.add(index - 1, station);
    }

    public void deleteSection(Station station) {
        stationList.remove(station);
    }

    public void enrollStation(Station station){
        stationList.add(station);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Line) {
            Line o = (Line) obj;
            return this.name.equals(o.name);
        }
        return false;
    }
}
