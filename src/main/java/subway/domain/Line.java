package subway.domain;

import java.util.List;

public class Line {

    private String name;
    private List<Station> section;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Station> getSection() {
        return section;
    }
}
