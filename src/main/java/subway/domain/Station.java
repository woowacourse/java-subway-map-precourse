package subway.domain;

import java.util.ArrayList;

public class Station {
    private String name;
    private ArrayList<Line> registeredLines = new ArrayList<>();

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRegisteredLine(Line registeredLine) {
        registeredLines.add(registeredLine);
    }

    public boolean isRegisteredToLine() {
        return !registeredLines.isEmpty();
    }
}
