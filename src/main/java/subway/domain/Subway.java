package subway.domain;

import java.util.List;

public class Subway {

    public StationRepository stationRepository = new StationRepository();
    public LineRepository lineRepository = new LineRepository();

    public void addStation(String stationName) {
        stationRepository.addStation(new Station(stationName));
    }

    public boolean deleteStation(String stationName) {
        return stationRepository.deleteStation(stationName);
    }

    public boolean deleteLine(String lineName) {
        return lineRepository.deleteLineByName(lineName);
    }

    public boolean isDuplicatedStation(String stationName) {
        return stationRepository.isDuplicated(stationName);
    }

    public void addLine(String lineName, String upwardStationName,
        String downwardStationName) {
        lineRepository.addLine(lineName, upwardStationName, downwardStationName);
    }

    public boolean isDuplicatedLine(String lineName) {
        return lineRepository.isDuplicated(lineName);
    }

    public void addSection(String lineName, String stationName, int order) {
        lineRepository.addSection(lineName, stationName, order);
    }

    public boolean deleteSection(String lineName, String stationName) {
        return lineRepository.deleteSection(lineName, stationName);
    }

    public boolean isStationInLine(String name) {
        return lineRepository.isStationInLine(name);
    }

    public void printMap() {
        lineRepository.printAll();
    }

    public List<Station> stations() {
        return stationRepository.stations();
    }

    public List<Line> lines() {
        return lineRepository.lines();
    }
}
