package subway.line;

import subway.line.validation.CheckLineNameDuplicate;
import subway.line.validation.CheckLineNameLength;
import subway.station.Station;

public class Line {
    private String name;
    private EachLineStations stations;

    public Line(String name) {
        validLineName(name);
        this.name = name;
        this.stations = new EachLineStations();
    }

    public Line(String name, EachLineStations stations) {
        validLineName(name);
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.addStation(station);
    }

    private void validLineName(String name) {
        CheckLineNameLength.validation(name);
        CheckLineNameDuplicate.validation(name);
    }

    public boolean isRegistered(String name) {
        return stations.isRegistered(name);
    }

    public void addSection(Station station, int sectionNumber) {
        stations.addSection(station, sectionNumber);
    }

    public boolean isNotExistSection(int number) {
        return stations.isNotExistSection(number);
    }
}
