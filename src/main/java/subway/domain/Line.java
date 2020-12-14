package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Station> lineMembers = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station stationName){
        this.lineMembers.add(stationName);
    }
    public List<Station> getLineMembers(){
        return this.lineMembers;
    }
}
