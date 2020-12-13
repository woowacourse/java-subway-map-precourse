package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private Line line;
    private List<Station> stations;

    public Route(Line line, Station upboundTerminal, Station downbounTerminal) {
        this.line = line;
        stations = new ArrayList<>();
        stations.add(upboundTerminal);
        stations.add(downbounTerminal);
    }

    public void getInfo(){
        System.out.println(line.getName());
        for(Station s:stations)
            System.out.printf(s.getName()+" ");
        System.out.println("");
    }

    public void insertStation(Station station, int index) {
        stations.add(index, station);
    }

    public boolean matchLineName(String lineName) {
        if (line.getName().equals(lineName)) {
            return true;
        }
        return false;
    }

    public boolean doesIncludeStation(String stationName) {
        for (Station station : stations) {
            if (station.getName().equals(stationName)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfStations(){
        return stations.size();
    }
}
