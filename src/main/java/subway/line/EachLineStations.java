package subway.line;

import subway.station.Station;
import subway.station.StationService;

import java.util.ArrayList;
import java.util.List;

public class EachLineStations {
    private List<Station> stations;

    public EachLineStations() {
        this.stations = new ArrayList<>();
    }

    public EachLineStations(List<Station> stations) {
        this.stations = stations;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public boolean isRegistered(String name) {
        for (Station station : stations) {
            if (station.isSame(name)) {
                return true;
            }
        }
        return false;
    }

    public void addSection(String stationName, int sectionNumber) {
        Station station = StationService.findStation(stationName);
        stations.add(sectionNumber, station);
    }
}
