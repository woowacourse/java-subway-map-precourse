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

    public boolean isEmpty(){
        if(getLineStations().isEmpty()){
            return true;
        }
        return false;
    }

    public void removeLineStation(Station station){
        this.getLineStations().remove(station);
    }

    public ArrayList<Station> getLineStations() {
        return lineStations;
    }

    public void initiateLineStations(Station upstreamStation, Station downstreamStation) {
        validateIfDuplicate(upstreamStation, downstreamStation);
        this.lineStations.add(upstreamStation);
        this.lineStations.add(downstreamStation);
    }
}
