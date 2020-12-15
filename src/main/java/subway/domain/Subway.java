package subway.domain;

import java.util.Collections;
import java.util.List;

public class Subway {
    private static final String INFO_PREFIX = "[INFO] ";

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

    public void printStation() {
        for (Station station : stationRepository.stations()) {
            System.out.println(INFO_PREFIX + station.getName());
        }
        System.out.println();
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

    public boolean isExistStation(String stationName) {
        for (Station station : stationRepository.stations()) {
            if (station.isSameName(stationName)) {
                return true;
            }
        }
        return false;
    }
    public boolean isExistLine(String lineName) {
        for (Line line : lineRepository.lines()) {
            if (line.isSameName(lineName)) {
                return true;
            }
        }
        return false;
    }

    public void printLine() {
        for (Line line : lineRepository.lines()) {
            System.out.println(INFO_PREFIX + line.getName());
        }
        System.out.println();
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
