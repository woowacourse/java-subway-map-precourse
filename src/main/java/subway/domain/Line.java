package subway.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> lineStations;

    public Line(String name) {
        validateLength(name);
        this.name = name;
        this.lineStations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Station> getLineStations(){
        return lineStations;
    }

    public void initiateLineStations(Station firstStation, Station lastStation) {
        validateIfDuplicate(firstStation, lastStation);
        validateIfStationsAtLeastTwo();
        this.lineStations.add(firstStation);
        this.lineStations.add(lastStation);
    }

    public void validateIfDuplicate(Station firstStation, Station lastStation) {
        if (firstStation.equals(lastStation)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateIfStationsAtLeastTwo() {
        if (StationRepository.stations().size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String userInput) {
        if (!(userInput.length() >= 2)) {
            throw new IllegalArgumentException();
        }
    }

    // 추가 기능 구현
}
