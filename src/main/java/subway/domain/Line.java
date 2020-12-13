package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private String upBoundTerminus;
    private String downstreamTerminus;
    private List<String> stations;

    public Line(String name, List<String> stations) {
        this.name = name;
        this.upBoundTerminus = stations.get(0);
        this.downstreamTerminus = stations.get(stations.size() - 1);
        this.stations = new ArrayList<>(stations);
    }
    
    public Line(String name, String upBoundTerminus, String downstreamTerminus) {
        this.name = name;
        this.upBoundTerminus = upBoundTerminus;
        this.downstreamTerminus = downstreamTerminus;
        this.stations = new ArrayList<>() {
        	{
        		add(upBoundTerminus);
        		add(downstreamTerminus);
        	}
        };
    }

    public String getName() {
        return name;
    }
    
    public void addStation(int idx, String station) {
    	stations.add(idx, station);
    }
}
