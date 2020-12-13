package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> lineStations;

    public Line(String name) {
        validateLength(name);
        this.name = name;
        this.lineStations = new ArrayList<>();
    }

    private void validateIfDuplicate(Station firstStation, Station lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIfStationsAtLeastTwo() {
        if (StationRepository.stations().size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String userInput) {
        if (!(userInput.length() >= 2)) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public boolean contains(Station station) {
        if (lineStations.contains(station)) {
            return true;
        }
        return false;
    }

    public ArrayList<Station> getLineStations() {
        return lineStations;
    }

    public void initiateLineStations(Station firstStation, Station lastStation) {
        validateIfDuplicate(firstStation, lastStation);
        validateIfStationsAtLeastTwo();
        this.lineStations.add(firstStation);
        this.lineStations.add(lastStation);
    }
}
