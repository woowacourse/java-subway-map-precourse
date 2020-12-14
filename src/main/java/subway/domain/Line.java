package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    public static final String ERR_ALREADY_ADD_STATION_MSG = "[ERROR] 이미 등록된 역입니다.";
    private String name;
    private Stations stations = new Stations();

    public Line(String name, Station uplineTerminalStation, Station downlineTerminalStation) {
        this.name = name;
        this.stations.addStation(uplineTerminalStation);
        this.stations.addStation(downlineTerminalStation);
    }

    public String getName() {
        return name;
    }

    public void addStation(int index, Station station) {
        if (!stations.contains(station)) {
            stations.addStation(index, station);
            return;
        }

        throw new IllegalStateException(ERR_ALREADY_ADD_STATION_MSG);
    }

    public Station getUplineTerminalStation(){
        return stations.firstStation();
    }

    public Station getDownlineTerminalStation(){
        return stations.lastStation();
    }

    public List<String> stationsNames(){
        return stations.stationNames();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
