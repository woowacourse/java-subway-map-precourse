package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> lineIntervals = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addIntervals (Station intervalStation) {
        lineIntervals.add(intervalStation);
    }
}
