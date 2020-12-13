package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import subway.utils.PrintUtils;

public class Route {

    private Line line;
    private List<Station> stations;

    private final PrintUtils printUtils = new PrintUtils();

    public Route(Line line, Station upboundTerminal, Station downbounTerminal) {
        this.line = line;
        stations = new ArrayList<>();
        stations.add(upboundTerminal);
        stations.add(downbounTerminal);
    }

    public void getInfo(){
        printUtils.printLineName(line.getName());
        printUtils.printHyphenLine();
        for(Station station: stations)
            printUtils.printStationName(station.getName());
        System.out.println("");
    }

    public void insertStation(Station station, int index) {
        stations.add(index, station);
    }

    public boolean deleteStation(String stationName) {
        return stations.removeIf(station -> Objects.equals(station.getName(), stationName));
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
