package subway.domain;

import java.util.Arrays;
import java.util.List;

public class LineManager {
    public static void initLine(String name, String[] stations) {
        Line line = new Line(name);
        Arrays.asList(stations).forEach(station -> line.addSubStation(StationManager.getByName(station)));
        LineRepository.addLine(line);
    }

    public static boolean anyMatchLineName(String name) {
        return LineRepository.lines().stream().anyMatch(line -> line.getName().equals(name));
    }

    public static void addLine(String name, Station from, Station to) {
        Line line = new Line(name);
        line.addSubStation(from);
        line.addSubStation(to);
        LineRepository.addLine(line);
    }

    public static Line getLineByName(String name) {
        for (Line line : LineRepository.lines()) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }

    public static boolean deleteLineByName(String name) {
        Line target = getLineByName(name);
        if (target == null) {
            return false;
        }
        deleteLineFromStations(target);
        LineRepository.deleteLineByName(name);
        return true;
    }

    private static void deleteLineFromStations(Line line) {
        for (Station station : line.getSubStations()) {
            station.deleteBelongingLine(line);
        }
    }

    public static List<Line> allLines() {
        return LineRepository.lines();
    }

    public static boolean addSectionInLine(String lineName, String stationName, int index) {
        Line line = LineManager.getLineByName(lineName);
        Station station = StationManager.getByName(stationName);
        if ((line == null) || (station == null)) {
            return false;
        }
        line.addSubStationAt(index, station);
        return true;
    }

    public static boolean hasStation(String lineName, String stationName) {
        Line line = LineManager.getLineByName(lineName);
        if (line == null) {
            return false;
        }
        return line.getSubStations().stream().anyMatch(station -> station.getName().equals(stationName));
    }

    public static boolean deleteSectionInLine(String lineName, String stationName) {
        Line line = LineManager.getLineByName(lineName);
        if ((line == null) || line.getSubStations().stream().noneMatch(station -> station.getName().equals(stationName))) {
            return false;
        }
        line.deleteSubStation(StationManager.getByName(stationName));
        return true;
    }
}
