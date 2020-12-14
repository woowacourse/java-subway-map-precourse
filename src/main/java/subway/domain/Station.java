package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;

    private List<String> lines = new ArrayList<String>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현

    public void involvedLine(String name) {
        lines.add(name);
    }

    public void deleteLines(String name) {
        lines.remove(name);
    }

    public boolean isLineStation() {
        if (lines.size() == 0) {
            return false;
        }
        return true;
    }
}
