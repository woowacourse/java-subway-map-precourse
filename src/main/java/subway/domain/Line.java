package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MINIMUM_LENGTH = 2;
    private static final int DELETE_SECTION_MINIMUM_SIZE = 2;
    private static final int UP_TERMINAL = 0;
    private static final int DOWN_TERMINAL = 1;
	
    private static final String DELETE_SECTION_MINIMUM_SIZE_ERROR = "노선에 포함된 역이 2개 이하입니다.";
    
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
    
    public void addUpTerminal(Station station){
        addStation(station, UP_TERMINAL);
    }
	
    public void addDownTerminal(Station station) {
        addStation(station, DOWN_TERMINAL);
    }
    
    public boolean deleteStation(Station station) {
        if (stations.size() <= DELETE_SECTION_MINIMUM_SIZE) {
            throw new IllegalArgumentException(DELETE_SECTION_MINIMUM_SIZE_ERROR);
        }
        return stations.remove(station);
    }
}
