package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LENGTH = 2;
    
    private String name;
    private List<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isValidName() {
        if (name.length() >= MINIMUM_LENGTH) {
            return true;
        }
        return false;
    }   
    
    @Override
    public boolean equals(Object obj) {
        if (((Line)obj).getName().equals(name)) {
            return true;
        }
        return false;
    }

    public boolean hasStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void addStation(Station station, int order) {
        stations.add(order, station);
    }
}
