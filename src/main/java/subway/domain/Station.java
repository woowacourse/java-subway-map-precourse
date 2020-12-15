package subway.domain;

import java.util.ArrayList;

public class Station {
    private String name;

    private ArrayList<Line> belongToWhichLine = new ArrayList<Line>();

    public Station(String name) {
        this.name = name;
    }

    public void addBelongToWhichLine(Line line) {
        belongToWhichLine.add(line);
    }

    public void deleteBelongToWhichLine(Line line) {
        belongToWhichLine.remove(line);
    }

    public boolean checkSameStationName(String name) {
        return (this.name.equals(name));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Line> getBelongToWhichLine() {
        return belongToWhichLine;
    }
}
