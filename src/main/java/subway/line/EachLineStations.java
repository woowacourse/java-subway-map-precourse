package subway.line;

import subway.station.Station;

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

    public void addSection(Station station, int sectionNumber) {
        stations.add(sectionNumber, station);
    }

    public boolean isNotExistSection(int number) {
        int minimumNumber = 1;
        int maximumNumber = stations.size() - 1;
        return number < minimumNumber || number > maximumNumber;
    }
}
