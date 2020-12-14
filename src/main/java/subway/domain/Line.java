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
        addStationToSection(0, start);
        addStationToSection(1, end);
    }

    public void addStationToSection(int index, String name) throws IllegalArgumentException {
        validateIndex(index);
        validateDuplicate(name);
        section.add(index, searchStation(name));
    }

    private void validateIndex(int index) {
        if (index > section.size() || index < 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 순서입니다.");
        }
    }

    private void validateDuplicate(String name) {
        for (Station station : section) {
            if (station.getName().equals(name)) {
                throw new IllegalArgumentException("[ERROR] 노선에 중복된 역이 존재합니다.");
            }
        }
    }

    public boolean hasStation(String name) {
        for (Station station : section) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String topString = "[INFO] " + name + "\n";
        String horizontalLine = "[INFO] " + "---" + "\n";
        StringBuilder sb = new StringBuilder();
        for (Station station : section) {
            sb.append("[INFO] ");
            sb.append(station.getName());
            sb.append("\n");
        }
        return topString + horizontalLine + sb;
    }
}
