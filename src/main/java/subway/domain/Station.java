package subway.domain;

import java.util.ArrayList;

public class Station {
    private String name;
    private boolean enrolled = false;
    private ArrayList<Line> linesEnrolled = new ArrayList<>();

    public Station(String name) { // 변경 불가능
        this.name = name;
    }

    public String getName() { // 변경 불가능
        return name;
    }

    public boolean isEnrolled() {
        return enrolled;
    }
    public void enroll(Line line) {
        linesEnrolled.add(line);
        enrolled = true;
    }
    public void disEnroll(Line line) {
        linesEnrolled.remove(line);
        if (linesEnrolled.size() == 0) {
            enrolled = false;
        }
    }
}
