package subway.domain;

import java.util.ArrayList;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private ArrayList<Line> belongToWhichLine = new ArrayList<Line>();

    public void addBelongToWhichLine(Line line) {
        belongToWhichLine.add(line);
    }

    public void deleteBelongToWhichLine(Line line) {
        belongToWhichLine.remove(line);
    }

    public ArrayList<Line> getBelongToWhichLine() {
        return belongToWhichLine;
    }

    public boolean checkSameName(String name) {
        return (this.name.equals(name));
    }
}
